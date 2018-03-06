package test;

import model.CoffeeMaker;
import model.exceptions.*;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;


public class CoffeeMakerTest {
    private CoffeeMaker barrista;

    @Before
    public void setUp(){
        barrista = new CoffeeMaker();
    }

    @Test
    public void testConstructor(){
        assertEquals(barrista.getTimeSinceLastBrew(), barrista.getCupsRemaining(), 0);
    }

    @Test
    public void testBrewNotEnoughBeansNotEnoughWater(){
        //expecting NotEnoughBeansException
        try {
            barrista.brew(1.5, 8.25);
        } catch (NotEnoughBeansException e) {
            //don't need to do anything here!
        } catch (TooManyBeansException e) {
            fail();
        } catch (WaterException e) {
            fail();
        }
    }

    @Test
    public void testBrewTooManyEnoughBeansNotEnoughWater(){
        //expecting TooManyBeansException
        try {
            barrista.brew(2.8, 8.25);
        } catch (NotEnoughBeansException e) {
            fail();
        } catch (TooManyBeansException e) {
            //don't need to do anything here!
        } catch (WaterException e) {
            fail();
        }
    }

    @Test
    public void testBrewEnoughBeansNotEnoughWater(){
        //expecting WaterException
        try {
            barrista.brew(2.5, 8.25);
        } catch (NotEnoughBeansException e) {
            fail();
        } catch (TooManyBeansException e) {
            fail();
        } catch (WaterException e) {
            //don't need to do anything here!
        }
    }

    @Test
    public void testBrewEnoughBeansEnoughWater(){
        //expecting no exceptions
        successfulBrew();
    }

    @Test
    public void testPourStaleCoffee(){
        //expecting StaleCoffeeException
        successfulBrew();
        barrista.setTimeSinceLastBrew(61);
        try {
            barrista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            fail();
        } catch (StaleCoffeeException e) {
            //don't have to do anything!
        }
    }

    @Test
    public void testPourNotEnoughCoffee(){
        //expecting NoCupsRemainingException
        successfulBrew();
        pourTwentyCups();
        barrista.areCupsRemaining();
        try {
            barrista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            //don't have to do anything!
        } catch (StaleCoffeeException e) {
            fail();
        }
    }

    @Test
    public void testPourCoffee(){
        //expecting no exceptions
        successfulBrew();
        try {
            barrista.pourCoffee();
        } catch (NoCupsRemainingException e) {
            fail();
        } catch (StaleCoffeeException e) {
            fail();
        }
    }

    @Test
    public void testSetTimeSinceLastBrew(){
        barrista.setTimeSinceLastBrew(4);
        assertEquals(barrista.getTimeSinceLastBrew(), 4);
        barrista.setTimeSinceLastBrew(78);
        assertEquals(barrista.getTimeSinceLastBrew(), 78);
    }

    @Test
    public void testCupsRemaining(){
        successfulBrew();
        assertEquals(barrista.getCupsRemaining(), 20);
        assertEquals(barrista.areCupsRemaining(), true);
    }

    private void successfulBrew() {
        try {
            barrista.brew(2.5, 15.2);
        } catch (Exception e) {
            fail();
        }
    }

    private void pourTwentyCups() {
        for(int i = 0; i < 20; i++) {
            try {
                barrista.pourCoffee();
            } catch (NoCupsRemainingException e) {
                fail();
            } catch (StaleCoffeeException e) {
                fail();
            }
        }
    }

}
