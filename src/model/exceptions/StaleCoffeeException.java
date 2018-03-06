package model.exceptions;

public class StaleCoffeeException extends Exception {
    private int timeSinceLastBrew;

    public StaleCoffeeException(int timeSinceLastBrew){
        super(timeSinceLastBrew + " is too much time since the last brew");
    }
}
