import Statistics.CarPark;

import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String[] inputData = {"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50",
                "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29",
                "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"};

        printCommands();
        Scanner in = new Scanner(System.in);
        CarPark carPark = new CarPark(inputData);
        boolean isActive = true;
        while (isActive) {
            System.out.println("\nвведите команду:");
            switch (in.next()) {
                case "1":
                    carPark.printTotalCostOfAllCarExpenses();
                    break;
                case "2":
                    carPark.printCostOfAllCarExpensesByType();
                    break;
                case "3":
                    carPark.printTypeWithMaxTotalCost();
                    break;
                case "4":
                    carPark.printTypeWithMinTotalCost();
                    break;
                case "5":
                    carPark.printCarsInfoInTypesByExpenses();
                    break;
                case "6":
                    carPark.printCarsInfoInTypesByPayload();
                    break;
                case "7":
                    printCommands();
                    break;
                default:
                    isActive = false;
            }
        }
        System.out.println("До скорой встречи :)");
    }

    private static void printCommands() {
        System.out.println("\n\t\tСписок команд");
        System.out.println("1.\tВывести общую стоимость расходов на ГСМ");
        System.out.println("2.\tВывести стоимость расходов на ГСМ по каждому классу");
        System.out.println("3.\tВывести тип авто имеющий наиБольшую стоимость расходов");
        System.out.println("4.\tВывести тип авто имеющий наиМеньшую стоимость расходов");
        System.out.println("5.\tВывести полную информацию о транспорте с сортировкой по пробегу");
        System.out.println("6.\tВывести полную информацию о транспорте с сортировкой по " +
                "доп.параметру (полезной нагрузе)");
        System.out.println("7.\tПоказать команды");
        System.out.println("0.\tЗакончить работу");
    }
}