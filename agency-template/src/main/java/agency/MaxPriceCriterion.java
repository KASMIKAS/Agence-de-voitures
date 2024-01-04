package agency;
import java.util.List ;
import java.util.function.Predicate;
public class MaxPriceCriterion implements Predicate<Vehicle> {
    double maxAmount ;
    public MaxPriceCriterion(double maxAmount){
        this.maxAmount = maxAmount ;
    }

    /**
     *
     * @param vehicle
     * @return vrai si le critere de prix maximal est valide
     */
    @Override
    public boolean test(Vehicle vehicle) {
        if(vehicle.dailyRentalPrice() == maxAmount || vehicle.dailyRentalPrice() < maxAmount ){
            return true ;
        }
        return false ;
    }
}
