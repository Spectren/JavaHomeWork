package com.company.Statistics;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class CarPark {
    private Light lights;
    private CarWithPayload freights;
    private CarWithPayload passengers;
    private CarWithPayload heavies;
    FullCosts[] fullCosts;

    public CarPark(String[] inputData) {
        this.lights = newGarage(46.1, 12.5);
        this.freights = newGarage(48.9, 12.0,
                "грузовые автомобили", "объем перевезенного груза см. куб.");
        this.passengers = newGarage(47.5, 11.5,
                "пассажирский транспорт",
                "число перевезенных пассажиров");
        this.heavies = newGarage(48.9, 20.0,
                "тяжелая техника(краны)",
                "вес поднятых грузов тонн");

        Pattern pattern = Pattern.compile("([A-Za-zА-Яа-я])(\\d+)_(\\d+)-(\\d+)-?(\\w+)?");
        for (String inputRow : inputData) {
            Matcher matcher = pattern.matcher(inputRow);
            if (matcher.find()) {
                switch (matcher.group(2)) {
                    case "100":
                        this.lights.append(matcher.group(1) + matcher.group(2),
                                parseInt(matcher.group(3)), parseInt(matcher.group(4)));
                        break;
                    case "200":
                        this.freights.append(matcher.group(1) + matcher.group(2),
                                parseInt(matcher.group(3)), parseInt(matcher.group(4)), parseInt(matcher.group(5)));
                        break;
                    case "300":
                        this.passengers.append(matcher.group(1) + matcher.group(2),
                                parseInt(matcher.group(3)), parseInt(matcher.group(4)), parseInt(matcher.group(5)));
                        break;
                    case "400":
                        this.heavies.append(matcher.group(1) + matcher.group(2),
                                parseInt(matcher.group(3)), parseInt(matcher.group(4)), parseInt(matcher.group(5)));
                        break;
                }
            }
        }
        fullCosts = new FullCosts[]{this.lights, this.freights, this.passengers, this.heavies};
    }

    public static CarWithPayload newGarage(double a, double b, String c, String d) {
        return new CarWithPayload(a, b, c, d);
    }
    public static Light newGarage(double a, double b) {
        return new Light(a, b);
    }

    public void printTotalCostOfAllCarExpenses() {
        double totalCostOfAllCarExpenses = 0;
        for (FullCosts transpStat : fullCosts) {
            totalCostOfAllCarExpenses += transpStat.getFullCost();
        }
        System.out.printf(
                "ОБЩАЯ СТОИОМСТЬ РАСХОДОВ НА ГСП: %f\n",
                totalCostOfAllCarExpenses);
    }

    public void printCostOfAllCarExpensesByType() {
        for (FullCosts transportStat : fullCosts) {
            System.out.printf(
                    "На %s затрачено %f%n",
                    transportStat.getTypeTitle(), transportStat.getFullCost());
        }

    }

    public void printTypeWithMaxTotalCost() {
        String maxTitle = "";
        double maxValue = 0.0;
        for (FullCosts transpStat : fullCosts) {
            double currentValue = transpStat.getFullCost();
            if (maxValue < currentValue) {
                maxValue = currentValue;
                maxTitle = transpStat.getTypeTitle();
            }
        }
        System.out.printf("НаиБольшую стоимость расходов имеет %s - %f%n",
                maxTitle, maxValue);
    }

    public void printTypeWithMinTotalCost() {
        String minTitle = "";
        double minValue = Double.POSITIVE_INFINITY;
        for (FullCosts transpStat : fullCosts) {
            double currentValue = transpStat.getFullCost();
            if (minValue > currentValue) {
                minValue = currentValue;
                minTitle = transpStat.getTypeTitle();
            }
        }
        System.out.printf("НаиМеньшую стоимость расходов имеет %s, - %f%n",
                minTitle, minValue);
    }

    public void printCarsInfoInTypesByExpenses() {
        for (FullCosts transportStat : fullCosts) {
            transportStat.printInfoOrderByMileage();
        }
    }

    public void printCarsInfoInTypesByPayload() {
        CarWithPayload[] carsInfoInTypesByPayload = {freights, passengers, heavies};
        for (CarWithPayload transportStat : carsInfoInTypesByPayload) {
            transportStat.printInfoOrderByPayload();
        }
    }
}
