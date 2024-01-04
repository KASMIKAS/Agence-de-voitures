package agency;

import util.TimeProvider;

public class Car extends AbstractVehicle {
    /**
     * revoie les proprietes d'une voiture
     * @param numberOfSeats le nombre de sieges
     */

    private final int numberOfSeats;

    /**
     *
     * @param brand la marque de la voiture
     * @param model le modele de la voiture
     * @param productionyear annee de la production
     * @param numberOfSeats nombre de sieges
     * @throws IllegalArgumentException s'affiche si l'annee la production est
     * inferieure strictement a 1900 ou superieure a l'annee courante
     */
    public Car(String brand, String model, int productionyear, int numberOfSeats) throws IllegalArgumentException {
        super(brand,model,productionyear);
        if (numberOfSeats < 1) {
            throw new IllegalArgumentException("Vous ne pouvez pas avoir une vehicule avec " + numberOfSeats + "siege(s)");
        }
        else {
        this.numberOfSeats = numberOfSeats;}
    }

    /**
     * teste si la voiture est neuve
     */
    public boolean isNew() {
        if(productionyear >= TimeProvider.currentYearValue() - 5) {
            return true;
        }
        return false;
    }

    /**
     * @return le prix de location de la voiture
     */
    @Override
    public double dailyRentalPrice() {
        if (isNew()) {
            return numberOfSeats * 40;
        }
        return numberOfSeats * 20;
    }

    /**
     * @return l'affichage des propriete de la voiture
     */
    @Override
    public String toString() {
        if (numberOfSeats == 1) {
            return "Car" +" "+ brand +" "+ model +" "+ productionyear +" "+ "(" +
                    numberOfSeats +" "+ "seat" + ")" +" "+ ":" +" "+ dailyRentalPrice() + "€" ;
        }
        return "Car" +" "+ brand +" "+ model +" "+ productionyear +" "+ "(" +
                numberOfSeats +" "+ "seats" + ")" +" "+ ":" +" "+ dailyRentalPrice() + "€" ;
    }



}