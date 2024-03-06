public class Kat extends Dier{

    public Kat (String naam) {
        super(naam);
    }

    public void geluidMaken(){
        System.out.println(naam + " purred : meow meow nigling");
    }

    public void bewegen(){
        System.out.println(naam + " land op 4 pootjes, in stijl natuurlijk");
    }
}
