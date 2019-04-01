package by.epam.javawebtraining.leonchikov.task05.util.Creator;

import by.epam.javawebtraining.leonchikov.task05.model.container.Parking;
import by.epam.javawebtraining.leonchikov.task05.model.entity.Car;

import java.util.Random;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class CarCreator {

    enum carBrand {
        BMW, FORD, TOYOTA, MERCEDES, OPEL, JEELY
    }

    public static void createCars(Parking parking) {

        Random random = new Random();

        for (int i = 1; i < 100; i++) {
            switch (random.nextInt(carBrand.values().length)) {
                case 0:
                    new Car(carBrand.BMW.toString() + i, parking);
                    break;
                case 1:
                    new Car(carBrand.FORD.toString() + i, parking);
                    break;
                case 2:
                    new Car(carBrand.TOYOTA.toString() + i, parking);
                    break;
                case 3:
                    new Car(carBrand.MERCEDES.toString() + i, parking);
                    break;
                case 4:
                    new Car(carBrand.OPEL.toString() + i, parking);
                    break;
                case 5:
                    new Car(carBrand.JEELY.toString() + i, parking);
                    break;
            }
        }
    }


}
