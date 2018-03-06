package main;

import model.CoffeeMaker;
import model.exceptions.*;

public class Main {

    public static void main(String[] args){
        CoffeeMaker goodBarrista = new CoffeeMaker();
        CoffeeMaker badBarrista = new CoffeeMaker();

        //successful use path
        //brew coffee correctly
        try {
            goodBarrista.brew(2.5, 15.0);
        } catch (NotEnoughBeansException e) {
            e.getMessage();
        } catch (TooManyBeansException e) {
            e.getMessage();
        } catch (WaterException e) {
            e.getMessage();
        }
        //pour a few cups
        try {
            goodBarrista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            e.getMessage();
        } catch (StaleCoffeeException e) {
            e.getMessage();
        }
        try {
            goodBarrista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            e.getMessage();
        } catch (StaleCoffeeException e) {
            e.getMessage();
        }
        try {
            goodBarrista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            e.getMessage();
        } catch (StaleCoffeeException e) {
            e.getMessage();
        }
        // set the time since last brew.
        goodBarrista.setTimeSinceLastBrew(1);

        //unsuccessful use path
        //wrong amount of water
        try {
            badBarrista.brew(2.50, 11.50);
        } catch (NotEnoughBeansException e) {
            e.getMessage();
        } catch (TooManyBeansException e) {
            e.getMessage();
        } catch (WaterException e) {
            e.getMessage();
        }
        //wrong amount of beans
        try {
            badBarrista.brew(2.20, 15.25);
        } catch (NotEnoughBeansException e) {
            e.getMessage();
        } catch (TooManyBeansException e) {
            e.getMessage();
        } catch (WaterException e) {
            e.getMessage();
        }
        //brew coffee correctly
        try {
            badBarrista.brew(2.50, 15.25);
        } catch (NotEnoughBeansException e) {
            e.getMessage();
        } catch (TooManyBeansException e) {
            e.getMessage();
        } catch (WaterException e) {
            e.getMessage();
        }
        // pour a few cups
        try {
            badBarrista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            e.getMessage();
        } catch (StaleCoffeeException e) {
            e.getMessage();
        }
        try {
            badBarrista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            e.getMessage();
        } catch (StaleCoffeeException e) {
            e.getMessage();
        }
        try {
            badBarrista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            e.getMessage();
        } catch (StaleCoffeeException e) {
            e.getMessage();
        }
        //set the time since last brew > 60
        badBarrista.setTimeSinceLastBrew(75);
        //attempting to pour coffee again
        try {
            badBarrista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            e.getMessage();
        } catch (StaleCoffeeException e) {
            e.getMessage();
        }


    }


}