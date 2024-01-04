package agency;

public class Motorbike extends AbstractVehicle {
    /**
     * revoie les proprietes du Motorbike
     * @param cylinderCapacity la cylindree du Motorbike
     */


    private final int cylinderCapacity ;

    /**
     *
     * @param brand la marque du moteur
     * @param model le modele du moteur
     * @param productionyear l'annee de production du motorbike
     * @param cylinderCapacity la cylindree du Motorbike
     * @throws IllegalArgumentException s'affiche si l'annee la production est
     * inferieure strictement a 1900 ou superieure a l'annee courante ou la cylindree est inferieure a 50 cc
     */

       public Motorbike( String brand , String model , int productionyear ,  int cylinderCapacity)
               throws IllegalArgumentException{
           super(brand,model,productionyear);
           if(cylinderCapacity < 50){
               throw new IllegalArgumentException
                       ("vous ne pouvez pas avoir " + cylinderCapacity + "dans un Motorbike ") ;
           }
           else{
           this.cylinderCapacity = cylinderCapacity ;
           }
       }

    /**
     * @return le prix de location du motorbike
     */
    @Override
       public double dailyRentalPrice() {
          return 0.25 * cylinderCapacity ;
       }

    /**
     * @return l'affichage des propriete du motorbike
     */
    @Override
       public String toString(){
          return "Motorbike" +" "+ brand +" "+ model +" "+ productionyear +" "+
                   "(" + cylinderCapacity + "cm³" + ")" +" "+":"+" "+ dailyRentalPrice() + "€" ;
       }
}


