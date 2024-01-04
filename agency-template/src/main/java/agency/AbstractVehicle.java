package agency;

import util.TimeProvider;

public abstract class AbstractVehicle implements Vehicle {
    /**
     * AbstractVehicle est une classe etendu par Car et Motorbike
     */
    String brand;
    String model;
    int productionyear;
    public AbstractVehicle(String brand, String model, int productionyear)throws IllegalArgumentException{
        /**
         * constructeur
         */
        int currentyearValue = TimeProvider.currentYearValue();
        if (productionyear < 1900 || productionyear > currentyearValue) {
            throw new IllegalArgumentException("l'année "+ productionyear +" de ce vehicule est invalide");
        }
        else {
        this.brand = brand;
        this.model = model;
        this.productionyear = productionyear;}
    }

    /**
     *
     * @return la marque
     */
    public String getBrand(){
       return brand ;
    }

    /**
     *
     * @return le modele
     */
    public String getModel() {
        return model;
    }

    /**
     *
     * @return l'annee de production
     */
    public int getProductionYear() {
        return productionyear;
    }

}




