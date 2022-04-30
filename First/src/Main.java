import java.util.Arrays;

class Spell {
    private String name;
    protected void setName(String name) {
        this.name = name;
    }
    public void ignite() {
        System.out.println(this.name + " has used ignite.");
    }
    public void flash() {
        System.out.println(this.name + " has used flash.");
    }
}
class Champion extends Spell{   // Champion class inherited Spell class.
    private String name;
    private String q;
    private String w;
    private String e;
    private String r;

    // Constructor.
    Champion(String name, String q, String w, String e, String r) {
        this.name = name;
        this.q = q;
        this.w = w;
        this.e = e;
        this.r = r;
        setName(name);  // this method came from Spell class.
    }

    // method.
    public void usesCombo() {
        System.out.println(this.name + " using combo:: ");
        System.out.println("q: "+ this.q + ", w: "+ this.w + ", e: "+ this.e + ", r: "+ this.r);
    }
}

public class Main {
    // static keyword makes available to use method without generating an object.
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int [] num = {1,2,3,4,5};
        char [] word = {'a', 'p', 'p', 'l', 'e'};
        System.out.println(Arrays.toString(num));
        System.out.println(word); // char array does not need to use Arrays.toString() method to print out itself.
        System.out.print(word.length + "\n");

        Champion talon = new Champion("talon", "Noxian Diplomacy", "Rake", "Assasin's path", "Ult");
        talon.usesCombo();
        talon.ignite(); // Champion object is using inherited method that came from Spell class.
        talon.flash(); // Champion object is using inherited method that came from Spell class.

    }
}
