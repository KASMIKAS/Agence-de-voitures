package agency;
import java.util.*;
import java.util.function.Predicate;

public class RentalAgency {
    /**
     * represente les fonction de l'agence
     */
     public List<Vehicle> vehicles;
     public Map<Client, Vehicle> rentedVehicles = new HashMap<>() ;


    /**
     * cree une instance d'une liste vide des vehicules
     */
    public RentalAgency() {
        this.vehicles = new ArrayList<>();
    }

    /**
     * cree une instance d'une liste des vehicules
     * @param vehicles liste des vehicules disponible dans l'agence
     */
    public RentalAgency(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    /**
     *
     * @param vehicle
     * @return ajoute un vehicule a l'agence
     */
    public boolean add(Vehicle vehicle) {
        if (vehicles.contains(vehicle)) {
            return false;
        }
        vehicles.add(vehicle);
        return true;
    }

    /**
     * enleve un vehicule de l'agence
     * @param vehicle
     * UnknownVehicleException s'affiche si le vehicule n'est pas disponible
     */
    public void remove(Vehicle vehicle){
        removeU(vehicle);
        vehicles.remove(vehicle);
}
    public void removeU(Vehicle vehicle) throws UnknownVehicleException {
        if(!vehicles.contains(vehicle)) {
            throw new UnknownVehicleException(vehicle);
    }
}

    /**
     *
     * @param vehicle
     * @return true si le vehicule est dans l'agence
     */
    public boolean contains(Vehicle vehicle) {
        if(vehicles.contains(vehicle)) {
            return true;
        }
        return false;
    }

    /**
     * @return la liste des vehicules
     */
    public List<Vehicle> getVehicles(){
        return vehicles ;
    }

    /**
     * Prints the vehicles (one by line) of this agency that satisfy the specified criterion
     *
     * @param criterion the criterion that the selected cars must satisfy
     */
    public List<Vehicle> select(Predicate<Vehicle> criterion){
        List<Vehicle> desiredVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles){
            if (criterion.test(vehicle)){
                desiredVehicles.add(vehicle);
            }
        }
        return desiredVehicles;
    }

    /**
     * Prints the vehicles (one by line) of this agency that satisfy the specified criterion
     *
     * @param criterion the criterion that the selected cars must satisfy
     */
    public void printSelectedVehicles(Predicate<Vehicle> criterion){
        for(Vehicle vehicle : vehicles){
            if(criterion == null || criterion.test(vehicle)){
                System.out.println(vehicle);
            }
        }
    }



    /**
     * permet aux clients de louer un vehicule
     * @param client represente un client
     * @param vehicle un vehicule
     * @return le prix de location
     * @throws UnknownVehicleException est levée si le véhicule n’existe pas dans l’agence
     * @throws IllegalStateException est levée s’il est déjà loué ou que le client
     * loue déjà un autre véhicule
     */
    public double rentVehicle(Client client, Vehicle vehicle)throws
            UnknownVehicleException, IllegalStateException {
        removeU(vehicle);
        rentVehiculeI(client);
        rentVehiculeA(vehicle);
        rentedVehicles.put(client, vehicle);
        return vehicle.dailyRentalPrice();
    }

    private void rentVehiculeI(Client client) throws IllegalStateException {
        if(aVehicleIsRentedBy(client)){
            throw new IllegalStateException("Un véhicule est deja loué par" +" "+client);
        }
    }

    private void rentVehiculeA(Vehicle vehicle) throws IllegalStateException {
        if(vehicleIsRented(vehicle)){
            throw new IllegalStateException(vehicle +" "+"est deja loué");
        }
    }

    /**
     *
     * @param client
     * @return true si le client loue actuellement un vehicule
     */
    public boolean aVehicleIsRentedBy(Client client){
        if(rentedVehicles.containsKey(client)){
            return true ;
        }
        return false ;
    }


    /**
     *
     * @param v
     * @return true si le vehicule est actuellment loué
     */
    public boolean vehicleIsRented(Vehicle v){
        if(rentedVehicles.containsValue(v)){
            return true ;
        }
        return false ;
    }

    /**
     * le client rend le vehicule qu'il a loue
     * @param client represente un client
     */

    public void returnVehicle(Client client){
        rentedVehicles.remove(client);
    }
                    
    /**
     * @return la collection des vehicules actuellement loués
     */
    public Collection<Vehicle> allRentedVehicles(){
        return rentedVehicles.values();
    }

}