package agency;

public interface Vehicle {
    /**
     * l'inteface implementee par Car et Motorbike
     */
    String getBrand() ;
    String getModel() ;
    int getProductionYear() ;
    double dailyRentalPrice() ;
    boolean equals(Object o) ;
    String toString() ;
}
