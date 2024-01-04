package agency;

public class UnknownVehicleException extends RuntimeException {
    Vehicle vehicle ;

    public UnknownVehicleException(Vehicle vehicle){
        this.vehicle = vehicle ;
    }

    public String getMessage(){
        return vehicle.toString() + '\n' + "le vehicule n'existe pas dans l'agence" ;
    }

}
