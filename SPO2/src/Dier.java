abstract class Dier {
    protected String naam; //protected naam eigenschap van String type

    //de constructor die de naam van het dier instelt
    public Dier(String naam){
        this.naam = naam;
    }
    public abstract void geluidMaken(); //abstract methode zonder implementatie

    public abstract void bewegen(); //abstract methode zonder implementatie

    //methode met implementatie
    public void sleep() {
        System.out.println(naam + " is aan het slapen Zzzzzzzz....");
    }

}
