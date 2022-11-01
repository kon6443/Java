package practice.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hotel {
    @Autowired
    private Restaurant restaurant;
//    public Hotel(Restaurant restaurant) {
//        System.out.println("Hotel has been built!");
//        this.restaurant = restaurant;
//    }
    public void reserveRestaurant() {
        System.out.println("Reserving a restaurant...");
        restaurant.orderMenu();
    }
}
