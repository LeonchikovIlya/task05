package by.epam.javawebtraining.leonchikov.task05.util.Creator;

import by.epam.javawebtraining.leonchikov.task05.model.container.Parking;
import by.epam.javawebtraining.leonchikov.task05.model.entity.Lot;

import javax.naming.ldap.PagedResultsControl;
import java.util.Queue;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class LotCreator {

    private static Parking parking = Parking.getInstance();

    public static Queue<Lot> createLots() {

        for (int i = 1; i < Parking.getMaxCarCount() + 1; i++) {
            parking.getQueue().add(new Lot(i));
        }
        return parking.getQueue();
    }
}
