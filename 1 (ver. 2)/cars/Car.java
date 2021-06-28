package cars;


public class Car implements Comparable<Car> {
    protected String code;
    protected int regNum;
    protected int mileage;
    protected double costOfALiterOfFuel;
    protected double fuelConsumptionPerHundredKm;

    public Car(String _code, int _regNum, int _mileage, double _theCostOfALiterOfFuel, double _fuelConsumptionPerHundredKm) {
        this.code = _code;
        this.regNum = _regNum;
        this.mileage = _mileage;
        this.costOfALiterOfFuel = _theCostOfALiterOfFuel;
        this.fuelConsumptionPerHundredKm = _fuelConsumptionPerHundredKm;
    }

    public int getMileage() {
        return mileage;
    }

    public double getFullExpenses() {
        return (double) mileage / 100.0 * fuelConsumptionPerHundredKm * costOfALiterOfFuel;
    }

    @Override
    public int compareTo(Car _car2) {
        return this.mileage - _car2.getMileage();
    }

    public String toString() {
        return String.format("Автомобиль типа %s\tномер %d\t пробег %d", code, regNum, mileage);
    }
}
