package by.epam.javawebtraining.leonchikov.task05.model.entity;

import org.apache.log4j.Logger;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Lot {

    private static final Logger logger;

    static {
        logger = Logger.getRootLogger();
    }

    private int id;

    public Lot(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {

        if (id > 0){
            this.id = id;
        }

    }

    public void timeSleeping(long timeSleeping){

        try {
            TimeUnit.MILLISECONDS.sleep(timeSleeping);
            logger.debug("Park lot #" + getId() + " is using for " + timeSleeping + " ms");
        } catch (InterruptedException e){
            logger.warn(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lot lot = (Lot) o;
        return id == lot.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Lot{" +
                "id=" + id +
                '}';
    }
}
