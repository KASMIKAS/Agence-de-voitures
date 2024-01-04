package agency;

import util.TimeProvider ;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 * dans cette classe on a testé les methodes qui
 * n'existe pas dans la partie TestCar et TestClient et TestRentalAgency
 */
public class App {
    public static void main(String[] args){
      Car car = new Car("Ford" , "focus" ,2018,5 );
        System.out.println(car);

      Motorbike motorbike = new Motorbike("Yamaha","Tmax",2020,530);
        System.out.println(motorbike);
        System.out.println(motorbike.dailyRentalPrice());
        List<Vehicle> vehicleList = new ArrayList<>() ;
        vehicleList.add(car);
        vehicleList.add(motorbike);
        RentalAgency rentalAgency = new RentalAgency(vehicleList);
        rentalAgency.remove(car);
        rentalAgency.printSelectedVehicles(null);
        rentalAgency.add(car);
        BrandCriterion brandCriterion = new BrandCriterion("Ford");
        rentalAgency.printSelectedVehicles(brandCriterion);
        MaxPriceCriterion maxPriceCriterion = new MaxPriceCriterion(135);
        rentalAgency.printSelectedVehicles(maxPriceCriterion);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(brandCriterion );
        predicates.add(maxPriceCriterion);
        IntersectionCriterion intersectionCriterion = new IntersectionCriterion(predicates);
        rentalAgency.printSelectedVehicles(intersectionCriterion);
        rentalAgency.contains(car);
        RentalAgency rentalAgency1 = new RentalAgency();
        Client mohamed = new Client("mohamed amine","kasmi",2002);
        Client lina = new Client("Lina", "Diani",2001);
        Map<Client, Vehicle> rentedVehicles = new HashMap<>();
        rentalAgency1.add(car);
        rentalAgency1.add(motorbike);
        rentedVehicles.put(mohamed,motorbike);
        rentedVehicles.put(lina,car);
        rentalAgency1.rentVehicle(lina,car);
        rentalAgency1.rentVehicle(mohamed,motorbike);
        rentalAgency1.returnVehicle(mohamed);
        System.out.println(rentalAgency1.rentedVehicles);







    }
}

