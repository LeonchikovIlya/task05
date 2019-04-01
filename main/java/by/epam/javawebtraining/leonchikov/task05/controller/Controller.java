package by.epam.javawebtraining.leonchikov.task05.controller;

import by.epam.javawebtraining.leonchikov.task05.model.container.Parking;
import by.epam.javawebtraining.leonchikov.task05.model.entity.Car;
import by.epam.javawebtraining.leonchikov.task05.model.entity.Lot;
import by.epam.javawebtraining.leonchikov.task05.util.Creator.CarCreator;
import by.epam.javawebtraining.leonchikov.task05.util.Creator.LotCreator;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * @author Ilya Leonchikov
 * @version 1.0 14 Feb 2019
 */
public class Controller {

    public static void main(String[] args) {

        Parking parking = Parking.getInstance();
        LotCreator.createLots();
        CarCreator.createCars(parking);

    }
}
