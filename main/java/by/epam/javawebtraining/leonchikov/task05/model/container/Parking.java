package by.epam.javawebtraining.leonchikov.task05.model.container;

import by.epam.javawebtraining.leonchikov.task05.model.entity.Car;
import by.epam.javawebtraining.leonchikov.task05.model.entity.Lot;
import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Parking {

    private static final int PARKING_SIZE = 4;
    private static final int DEFAULT_VALUE = 0;
    private static final Logger LOGGER;

    private static Semaphore semaphore;
    private static Parking instance;
    private Queue<Lot> queue;

    static {
        LOGGER = Logger.getRootLogger();
        semaphore = new Semaphore(PARKING_SIZE, true);

    }

    private AtomicInteger counter;

    private Parking() {
        this.counter = new AtomicInteger(DEFAULT_VALUE);
        queue = new ArrayBlockingQueue<>(PARKING_SIZE, true);
        LOGGER.info("Parking was created");
    }

    public static Parking getInstance() {

        if (instance == null) {
            return instance = new Parking();
        } else {
            return instance;
        }
    }

    public Queue<Lot> getQueue() {
        return queue;
    }

    public int getCounter() {
        return counter.intValue();
    }

    public static int getMaxCarCount() {
        return PARKING_SIZE;
    }

    public void addLot(Lot lot){
        queue.add(lot);
    }

    public Lot getLot(long maxWaitingTimeMillis) {

        Lot currentLot = null;

        try {
            if (semaphore.tryAcquire(maxWaitingTimeMillis, TimeUnit.MILLISECONDS)) {
                currentLot = queue.poll();
                return currentLot;
            }
        } catch (InterruptedException exception) {
            LOGGER.warn(exception);
        }

        return currentLot;
    }

    public void leaveLot(Lot lot) {
        queue.add(lot);
        semaphore.release();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Parking parking = (Parking) o;
        return Objects.equals(queue, parking.queue) &&
                Objects.equals(counter, parking.counter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queue, counter);
    }

    @Override
    public String toString() {
        return "Parking{" +
                "queue=" + queue +
                ", counter=" + counter +
                '}';
    }
}
