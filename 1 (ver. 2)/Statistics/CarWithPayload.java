package com.company.Statistics;

import com.company.cars.PayloadCar;

import java.util.ArrayList;
import java.util.List;

public class CarWithPayload implements FullCosts {
    private double costOfALiterOfFuel;
    private double fuelConsumptionPerHundredKm;
    private List<PayloadCar> cars = new ArrayList<>();
    private String typeTitle;
    private String payloadTitle;

    public CarWithPayload(double _theCostOfALiterOfFuel, double _fuelConsumptionPerHundredKm, String _typeTitle, String _payloadTitle) {
        this.costOfALiterOfFuel = _theCostOfALiterOfFuel;
        this.fuelConsumptionPerHundredKm = _fuelConsumptionPerHundredKm;
        this.typeTitle = _typeTitle;
        this.payloadTitle = _payloadTitle;
    }

    public void append(String _code, int _regNum, int _mileage, int _payload) {
        cars.add(new PayloadCar(_code, _regNum, _mileage, costOfALiterOfFuel, fuelConsumptionPerHundredKm, _payload));
    }

    public double getFullCost() {
        double sumCost = 0.0;
        for (PayloadCar car : cars) {
            sumCost += car.getFullExpenses();
        }
        return sumCost;
    }

    public void printInfoOrderByMileage() {
        cars.sort((c1, c2) -> c2.getMileage() - c1.getMileage());
        System.out.printf("<----\t%s\t--->%n", typeTitle);
        for (PayloadCar car : cars) {
            System.out.println(car.toString());
        }
    }

    public void printInfoOrderByPayload() {
        cars.sort((c1, c2) -> c2.getPayload() - c1.getPayload());
        System.out.printf("<----\t%s\t--->%n", typeTitle);
        for (PayloadCar car : cars) {
            System.out.println(car.toString());
        }
        System.out.printf("\tЕд.изм. полезной нагрузки: %s\n", payloadTitle);
    }

    public String getTypeTitle() {
        return typeTitle;
    }
}
