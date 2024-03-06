import java.util.Scanner;

public class App3 {
    static Motor motor1 = new Motor("wenMotor", true, true);
    static Motor motor2 = new Motor("nimaiMotor", true, true);
    static Motor motor3 = new Motor("bigiMotor", false, true);
    static Motor motor4 = new Motor("daggoeMotor", false, true);

    static Quad quad1 = new Quad("wenQuad", true, true);
    static Quad quad2 = new Quad("nimaiQuad", false, true);
    static Quad quad3 = new Quad("bigiQuad", false, true);
    static Quad quad4 = new Quad("daggoeQuad", true, true);


    static Klant klant1 = new Klant("Reyna");
    static Klant klant2 = new Klant("Skye");
    static Klant klant3 = new Klant("Phoenix");
    static Klant klant4 = new Klant("Chamber");

    static Verhuurbaar[] verhuurbaars = {
            /* Hier alle verhuurbare opjecten */
            motor1,
            motor2,
            motor3,
            motor4,
            quad1,
            quad2,
            quad3,
            quad4
    };

    static Klant[] klanten = {
            /* Hier alle klanten */
            klant1,
            klant2,
            klant3,
            klant4
    };

    /**
     * Hier logica voor Verhuur en reserverin
     * @param s Scanner
     */
    static void RentAndReserve(Scanner input) {
        System.out.println("--- Gemakverhuur (Verhuren en Reserveren) ---");

        System.out.println("Beschikbare artikelen: naam | verhuurbaar  ");
        for (int i = 0; i < verhuurbaars.length; i++) {
            System.out.println("[" + i + "] " + verhuurbaars[i].getNaam() + " | [" + verhuurbaars[i].isVerhuurbaar() + "]");
        }
        System.out.println("Selecteer artikel (O-" + (verhuurbaars.length - 1) + "): ");
        int artikelIndex = input.nextInt();

        System.out.println("Wil je het artikel reserveren[R] of verhuren[V]? ");
        input.nextLine();
        String actieKeuze = input.nextLine().toUpperCase();

        System.out.println("-----Klantbestand-----");
        for (int i = 0; i < klanten.length; i++) {
            System.out.println("[" + i + "] " + klanten[i].getNaam());
        }

        System.out.println("Selecteer een klant: ");
        int klantIndex = input.nextInt();

        if (actieKeuze.equals("V")) {
            verhuurbaars[artikelIndex].verhuurAan(klanten[klantIndex]);
            App3(new Scanner(System.in));
        } else if (actieKeuze.equals("R")) {
            verhuurbaars[artikelIndex].reserveerVoor(klanten[klantIndex]);
            App3(new Scanner(System.in));
        } else {
            System.out.println("Ongeldige actie keuze.");
            App3(new Scanner(System.in));
        }
    }

    /**
     * Hier logica voor het Retourneren van een gehuurd artikel
     * @param s Scanner
     */
    static void Return(Scanner input) {
        System.out.println("-----GemakVerhuur (Retouren)-----");
        System.out.println("Verhuurde artikelen:");
        for (int i = 0; i < verhuurbaars.length; i++) {
            if (!verhuurbaars[i].isVerhuurbaar()) {
                Klant huurder = verhuurbaars[i].getHuurder();
                System.out.println("[" + i + "]" + verhuurbaars[i].getNaam() + " | Verhuurd door: " + (huurder != null ? huurder.getNaam() : "Onbekend"));
            }
        }

        System.out.print("Selecteer verhuurd artikel: ");
        if (input.hasNextInt()) {
            int artikelIndex = input.nextInt();
            if (artikelIndex >= 0 && artikelIndex < verhuurbaars.length) {
                verhuurbaars[artikelIndex].retourneer();
                App3(input); // Roep App3 opnieuw aan met dezelfde Scanner om terug te gaan naar het hoofdscherm
            }
        } else if (input.next().equals("b")) {
            App3(input); // Als 'b' wordt ingevoerd, ga terug naar het hoofdscherm
        }

    }

    /**
     * Hier de logica voor het CLI-interface voor de verhuur Applicatie
     * @param input
     */
    static void App3(Scanner input) {

        while (true) {
            System.out.println("-----GemakVerhuur-----");
            System.out.println("[1] Verhuren en reserveren");
            System.out.println("[2] Retour");
            System.out.println("[3] Afsluiten");
            System.out.println("----------------------");
            System.out.print("Keuze: ");

            int keuze;
            if (input.hasNextInt()) {
                keuze = input.nextInt();

                if (keuze == 1) {
                    RentAndReserve(new Scanner(System.in));
                    break; // Stop de lus nadat de juiste keuze is gemaakt
                } else if (keuze == 2) {
                    Return(new Scanner(System.in));
                    break; // Stop de lus nadat de juiste keuze is gemaakt
                } else if (keuze == 3) {
                    System.out.println("Bedankt dat je voor Gemak Verhuur hebt gekozen!");
                    return; // Stop de methode en dus het programma
                } else {
                    System.out.println("Onbekende input! Probeer opnieuw.");
                }
            } else {
                input.next(); // Verwijder de ongeldige invoer
                System.out.println("Onbekende input! Probeer opnieuw.");
            }
        }


    }


    public static void main(String[] args) {
        App3(new Scanner(System.in));
    }


}