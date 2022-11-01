package practice.beans;

import org.springframework.stereotype.Component;

@Component
public class Chef {
    public Chef() {
        System.out.println("Chef has been hired!");
    }
    public void cook() {
        System.out.println("Chef is cooking now...");
    }
}
