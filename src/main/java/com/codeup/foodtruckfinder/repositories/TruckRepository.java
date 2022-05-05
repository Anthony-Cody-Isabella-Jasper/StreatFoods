package com.codeup.foodtruckfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codeup.foodtruckfinder.models.Truck;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TruckRepository extends JpaRepository<Truck, Long> {
    Truck getTruckById(long id);

    @Query(value = "SELECT * FROM trucks t JOIN trucks_cuisines tc on t.id = tc.truck_id JOIN cuisines c on c.id = tc.cuisine_id JOIN menu_items mi on t.id = mi.truck_id WHERE c.name = ?1 AND mi.vegetarian = ?2 AND mi.vegan = ?3", nativeQuery = true)
    List<Truck> filterTrucks(String cuisine, boolean vegetarian, boolean vegan);
    @Query(value = "SELECT * FROM trucks t JOIN menu_items mi on t.id = mi.truck_id WHERE mi.vegetarian = ?1 AND mi.vegan = ?2", nativeQuery = true)
    List<Truck> filterTrucks(boolean vegetarian, boolean vegan);
}
