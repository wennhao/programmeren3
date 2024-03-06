public class Hond extends Dier {

    public Hond (String naam) {
        super(naam);
    }

    public void geluidMaken() {
        System.out.println(naam + " barks : woof woof!");
    }

    public void bewegen(){
        System.out.println(naam + " doet een zieke backflip");
    }
}
