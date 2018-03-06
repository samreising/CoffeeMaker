package model;

import model.exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int timeSinceLastBrew;
    private int cupsRemaining;

    public CoffeeMaker(){
        timeSinceLastBrew = 0;
        cupsRemaining = 0;
    }

    // getters
    public int getTimeSinceLastBrew() {
        return timeSinceLastBrew;
    }
    public int getCupsRemaining() {
        return cupsRemaining;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        return cupsRemaining > 0;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        if(time < 0){
            System.out.println("Time must be greater than 0.");
        }
        else{
            this.timeSinceLastBrew = time;
        }
    }

    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0
    // throws exception if beans < 2.40, beans > 2.60, or water < 14.75
    public void brew(double beans, double water) throws NotEnoughBeansException, TooManyBeansException, WaterException{
        if(beans < 2.40){
            throw new NotEnoughBeansException(beans);
        }
        if(beans>2.60){
            throw new TooManyBeansException(beans);
        }
        if(water < 14.75){
            throw new WaterException(water);
        }
        this.cupsRemaining = 20;
        this.timeSinceLastBrew = 0;
    }

    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    // throws exception if cups remaining > 0 or if time since last brew > 60
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException{
        if(this.cupsRemaining < 1){
            throw new NoCupsRemainingException();
        }
        if(this.timeSinceLastBrew > 60){
            throw new StaleCoffeeException(this.getTimeSinceLastBrew());
        }
        this.cupsRemaining -= 1;
    }


}
