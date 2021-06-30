package com.company.cars;

public class PayloadCar extends Car {
    private int payload;

    public PayloadCar(String _code, int _regNum, int _mileage, double _costOfALiterOfFuel, double _fuelConsumptionPerHundredKm,
                      int _payload) {
        super(_code, _regNum, _mileage, _costOfALiterOfFuel, _fuelConsumptionPerHundredKm);
        this.payload = _payload;
    }

    public int getPayload() {
        return payload;
    }

    public String toString() {
        return String.format("Автомобиль типа %s\tномер %d\t пробег %d  \tполезная нагрузка\t%d", code, regNum, mileage, payload);
    }
}
