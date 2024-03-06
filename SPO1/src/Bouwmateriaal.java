public class Bouwmateriaal {
    private String naam;
    private String categorie;

    public Bouwmateriaal (String naam, String categorie) {
        this.naam = naam;
        this.categorie = categorie;
    }

    public String getNaam() {
        return naam;
    }

    public String getCategorie() {
        return categorie;
    }
    public void Bevestigen (Bevestigingsmateriaal bevestigingsmateriaal){
        System.out.println(naam + " word bevestigd met " + bevestigingsmateriaal );
    }
}
