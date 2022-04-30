import java.util.Arrays;

class Champion {
    // protected variables can be accessed in the same packages or inherited classes.
    protected String name;
    protected String q;
    protected String w;
    protected String e;
    protected String r;

    // Constructor.
    Champion(String name, String q, String w, String e, String r) {
        this.name = name;
        this.q = q;
        this.w = w;
        this.e = e;
        this.r = r;
    }
    public void ignite() {
        System.out.println(this.name + " has used ignite.");
    }
    public void flash() {
        System.out.println(this.name + " has used flash.");
    }
}

class AD extends Champion implements Champ {   // AD class inherited Champion class, Champ interface can ues declared methods.
    // Constructor.
    AD(String name, String q, String w, String e, String r) {
        // super() method calls Champion constructor in Champion class.
        super(name, q, w, e, r);
    }

    // methods.
    public void primaryDMG() {
        System.out.println(this.name + " primarily uses attack damage(AD).");
    }
    public void usesCombo() {
        System.out.println(this.name + " using combo:: ");
        System.out.println("q: "+ this.q + ", w: "+ this.w + ", e: "+ this.e + ", r: "+ this.r);
    }
}

class AP extends Champion implements Champ {   // AP class inherited Champion class, Champ interface can ues declared methods.
    // Constructor.
    AP(String name, String q, String w, String e, String r) {
        // super() method calls Champion constructor in Champion class.
        super(name, q, w, e, r);
    }
    // methods.
    public void primaryDMG() {
        System.out.println(this.name + " primarily uses ability point(AP).");
    }
    public void usesCombo() {
        System.out.println(this.name + " using combo:: ");
        System.out.println("q: "+ this.q + ", w: "+ this.w + ", e: "+ this.e + ", r: "+ this.r);
    }
}

// Displaying which champ primarily uses either AD or AP.
class PrimaryDamage {
    public void attack(Champ champ) {
        champ.primaryDMG();
    }
}

// Interface.
interface Champ {
    // This method is defined in AD or AP class.
    void primaryDMG();
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
        System.out.println();

        AD talon = new AD("Talon", "Noxian Diplomacy", "Rake", "Assasin's path", "Ult");
        AP leblanc = new AP("LeBlanc", "Sigil of Malice", "Distortion", "Ethereal Chains", "Ult");
        PrimaryDamage dmgCheck = new PrimaryDamage(); // Displaying which champ primarily uses either AD or AP.

        talon.usesCombo();
        talon.ignite(); // AD object is using inherited method that came from Spell class.
        talon.flash(); // AD object is using inherited method that came from Spell class.
        dmgCheck.attack(talon); // AD

        System.out.println();

        leblanc.usesCombo();
        leblanc.ignite(); // AP object is using inherited method that came from Spell class.
        leblanc.flash(); // AP object is using inherited method that came from Spell class.
        dmgCheck.attack(leblanc); // AP
    }
}
