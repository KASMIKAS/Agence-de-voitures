package agency;
import java.util.function.Predicate;
import java.util.Objects;

public class BrandCriterion implements Predicate<Vehicle> {
    String brand ;
    public BrandCriterion(String brand){
      this.brand = brand ;
    }

    /**
     *
     * @param vehicle
     * @return vrai si le critere de la marque est valide
     */
    @Override
    public boolean test(Vehicle vehicle) {
        if(vehicle.getBrand() == this.brand){
            return true ;
        }
        return false ;
    }




}
