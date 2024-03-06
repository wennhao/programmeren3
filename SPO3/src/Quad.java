public class Quad extends Motorvoertuig implements Verhuurbaar, Rijbaar {

    public int aantalwielen = 4;
    private String naam;
    private boolean verhuurbaar;
    private boolean rijbaar;
    private Klant huurder;
    private Klant gereserveerdDoor;

    public Quad(String naam, boolean verhuurbaar, boolean rijbaar) {
        this.naam = naam;
        this.verhuurbaar = verhuurbaar;
        this.rijbaar = rijbaar;
    }
    public void rijden(){
        System.out.println("Quad is aan het rijden.");
    }

    public boolean isVerhuurbaar(){
        return verhuurbaar;
    }

    public boolean isRijbaar(){
        return rijbaar;
    }

    public String getNaam() {
        return naam;
    }

    public Klant getHuurder() {
        return huurder;
    }
    @Override
    public void verhuurAan(Klant klant) {
        if (verhuurbaar) {
            huurder = klant;
            verhuurbaar = false;
            System.out.println(naam + " is verhuurd aan " + klant.getNaam());
        } else {
            System.out.println(naam + " kan niet worden verhuurd want het is niet beschikbaar.");
        }
    }

    @Override
    public void reserveerVoor(Klant klant) {
        if (!verhuurbaar) {
            gereserveerdDoor = klant;
            System.out.println(klant.getNaam() + " heeft " + naam + " gereserveerd.");
        } else {
            System.out.println(naam + " kan niet worden geresrveerd, want het is beschikbaar om te verhuren!");
        }
    }

    public void retourneer() {
        if (!verhuurbaar) {
            verhuurbaar = true;
            huurder = null;
            System.out.println(naam + " is succesvol geretourneerd.");
        } else {
            System.out.println(naam + " kan niet worden retourneerd, want het is beschikbaar om te verhuren!");
        }
    }
}
