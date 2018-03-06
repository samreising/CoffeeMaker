package model.exceptions;

public class WaterException extends Exception {
    private double amountofWater;

    public WaterException(double amountofWater){
        super(amountofWater + " not enough water");
    }
}
