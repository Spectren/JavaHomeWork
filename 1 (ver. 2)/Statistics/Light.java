package Statistics;

import ru.kor.cars.Car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Light implements FullCosts {
    private double costOfALiterOfFuel;
    private double fuelConsumptionPerHundredKm;
    private List<Car> cars = new ArrayList<>();

    public Light(double _costOfALiterOfFuel, double _fuelConsumptionPerHundredKm) {
        this.costOfALiterOfFuel = _costOfALiterOfFuel;
        this.fuelConsumptionPerHundredKm = _fuelConsumptionPerHundredKm;
    }

    public void append(String _code, int _regNum, int _mileage) {
        cars.add(new Car(_code, _regNum, _mileage,
                this.costOfALiterOfFuel, this.fuelConsumptionPerHundredKm));
    }

    public double getFullCost() {
        double sumCost = 0.0;
        for (Car car : cars) {
            sumCost += car.getFullExpenses();
        }
        return sumCost;
    }

    public void printInfoOrderByMileage() {
        cars.sort((c1, c2) -> c2.getMileage() - c1.getMileage());
        System.out.println("<----\tлегковые автомобили\t--->");
        for (Car car : cars) {
            System.out.println(car.toString());
        }
    }

    public String getTypeTitle() {
        return "легковые автомобили";
    }
}
