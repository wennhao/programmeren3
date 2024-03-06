public class Bevestigingsmateriaal {
    private String naam;

    public Bevestigingsmateriaal (String naam) {
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void Gebruiken (Bevestigingsmateriaal bevestigingsmateriaal) {
        System.out.println(naam + " gebruikt de " + bevestigingsmateriaal);
    }
}
