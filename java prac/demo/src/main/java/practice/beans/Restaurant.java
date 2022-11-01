package practice.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Restaurant {
    @Autowired
    private Chef chef;
//    public Restaurant(Chef chef) {
//        System.out.println("Restaurant has been built!");
//        this.chef = chef;
//    }
    public void orderMenu() {
        System.out.println("Ordering a menu...");
        chef.cook();
    }
}
