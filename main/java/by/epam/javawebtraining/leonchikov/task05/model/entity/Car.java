package by.epam.javawebtraining.leonchikov.task05.model.entity;

import by.epam.javawebtraining.leonchikov.task05.model.container.Parking;
import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.Random;


/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Car implements Runnable {

    private static final Logger logger;

    static {
        logger = Logger.getRootLogger();
    }

    private Parking parking;
    private String name;
    private Thread thread;

    public Car() {
        thread = new Thread(this);
        thread.start();
    }

    public Car(String name, Parking parking) {
        this.name = name;
        this.parking = parking;
        thread = new Thread(this);
        thread.start();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {

        Lot lot = null;
        long waitingTime = new Random().nextInt(1000);
        long parkingTime = new Random().nextInt(1000);

        try {

            lot = parking.getLot(waitingTime);

            if (lot != null) {

                logger.info("Car " + getName() + " got place #" + lot.getId() + ".");

                lot.timeSleeping(parkingTime);
            } else {
                logger.info("Car " + getName() + " go away to another parking after waiting for : "
                        + waitingTime + "ms");
            }
        } finally {
            if (lot != null) {
                logger.info("Car " + getName() + " after parking for : "
                        + parkingTime + " ms. Leave lot #" + lot.getId());

                parking.leaveLot(lot);
            }
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "name = " + name;
    }
}
