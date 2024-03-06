import java.util.Random;

public class App {

    public static void main(String[] args) {
        Bouwmateriaal materiaal1 = new Bouwmateriaal("Materiaal","Hout");
        Bouwmateriaal materiaal2 = new Bouwmateriaal("Materiaal","Metaal");
        Bouwmateriaal materiaal3 = new Bouwmateriaal("Materiaal","Gipsplaat");
        Bouwmateriaal materiaal4 = new Bouwmateriaal("Materiaal","Celbetonblok");
        Bouwmateriaal materiaal5 = new Bouwmateriaal("Materiaal","Gipsplaat");

        Bevestigingsmateriaal spijker = new Spijker("Spijker nigga!");

        int lijstLengte = 5;
        Bouwmateriaal[] materialen1;
        Bouwmateriaal[] materialen2;
        materialen1 = new Bouwmateriaal[5];
        materialen2 = new Bouwmateriaal[5];


        materialen1[1] = new Bouwmateriaal("Materiaal","Hout");



    }
}
