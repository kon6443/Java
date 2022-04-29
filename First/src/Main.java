import java.util.Arrays;

class Spell {
    private String name;
    protected void setName(String name) {
        this.name = name;
    }
    public void ignite() {
        System.out.println(this.name + " has used ignite.");
    }
}
class Champion extends Spell{
    private String name;
    private String q;
    private String w;
    private String e;
    private String r;
    Champion(String name, String q, String w, String e, String r) {
        this.name = name;
        this.q = q;
        this.w = w;
        this.e = e;
        this.r = r;
        setName(name);
    }
    public void usesCombo() {
        System.out.println(this.name + " using combo:: ");
        System.out.println("q: "+ this.q + ", w: "+ this.w + ", e: "+ this.e + ", r: "+ this.r);
    }
}

class Animal {
    public void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    private String name;
    Dog(String name) {
        this.name = name;
    }
    public void sleep() {
        System.out.println(this.name + " is sleeping...");
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int [] num = {1,2,3,4,5};
        char [] word = {'a', 'p', 'p', 'l', 'e'};
        System.out.println(Arrays.toString(num));
        System.out.println(word); // char array does not need to use Arrays.toString() method to print out itself.
        System.out.print(word.length + "\n");

        Champion talon = new Champion("talon", "Noxian Diplomacy", "Rake", "Assasin's path", "Ult");
        talon.usesCombo();
        talon.ignite();

//        Animal dog = new Dog("dog");
//        dog.sleep();
    }
}
