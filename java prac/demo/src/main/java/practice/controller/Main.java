package practice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import practice.beans.Hotel;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class Main {
    @Autowired
    private Hotel hotel;
    @RequestMapping(value={"/"}, method=GET)
    public String showMain() {
        System.out.println("show main function has been called.");
//        Chef chef = new Chef();
//        Restaurant restaurant = new Restaurant(chef);
//        Hotel hotel = new Hotel(restaurant);
        hotel.reserveRestaurant();
        return "home";
    }
}
