import simulation.Simulation;

/**
 * work dedivision:
 * Koray:
 * konzeptentwicklung
 * Grundgerüsst der klassen (mit getter und setter)
 * Calcuate Klasse Überarbeitet
 * TestKlasse den Test implementiert
 * enum Strategie implementiert
 * <p>
 * Sabrina:
 * konzeptentwicklung
 * Grundgerüst der klassen(mit getter und setter)
 * Strategie verteilung
 * Test klasse ausgabe (gui)
 * <p>
 * Aniela:
 * konzeptentwicklung
 * erstimplementierung Methoden der Calulate Klasse
 * Test klasse ausgabe(console)
 */
public class Test /*extends JFrame*/ {

    /*
    * ABGABE 31.10.2016
    *
    * -) Code ist noch nicht ausführbar, Testklassen fehlen.
    * -) Calculation Klasse wird noch implementiert, die anderen überarbeitet.
    * -) Unnötige Methoden und Funktionen werden gelöscht
    * -) Einiges was in die Calculation Klasse kommen sollte wird jetzt in die einzelnen zugehörigen Klassen verschoben
    *
    *
     */

    /*
    * ******* AUFGABE 2 *******
    * Kern des Programms:
    *  *) Simulation
    *    -) Simuliert den Verlauf und die Entwicklung des Ökosystems mit verschiedenen Tieren (genauer bei Eichhörnchen)
    *    -) Hält die Struktur des Ökosystems und der Tiere
    *  *) Ecosystem
    *    -) Hält Informationen zum Ökosystem (Liste von Eichhörnchen, Fressfeiden und Futterfeinden, Anzahl von neuen Futterplätzen
    *       jedes Jahr, Anzahl von neuen Bäumen, Größe des Lebensraumes.
    *    -) Hat Informationen zu Anzahl an Futter, mögliche unterschiedliche Lebensräume mit verschiedenen Lebensbedinungen
    *  *) Calculation
    *    -) Berechnet kleinere Simulationsverläufe (Bsp: Berechnung von Fortpflanzung von Eichhörnchen, Anzahl an toten Eichhörnchen
    *       durch Umweltbedinungen oder Alter, Anzahl an neu gewachsenen Bäumen pro Jahr,...)
    *  *) Animals (Squirrels, Fressfeinde, Futterfeinde,...)
    *    -) Struktur und Variablen, die Eichhörnchen und andere Tiere ausmachen. Strategie um zu überleben, sich fortzupflanzen und
    *       sich vor Fressfeinden zu schützen, Ziele im Leben, Geschlecht, Alter,...
    * Testklasse:
    *   *) Eine Testklasse pro Teil des Kerns, die überprüft ob sich die Klasse so verhält wie sie soll und alle Methoden das machen,
    *      was sie sollen.
    *   *) Eine globale 'Test' Klasse, die die Simulation steuert und alle Werte ausgibt (und richtig darstellt)
    * Arbeitsaufteilung:
    *   *) Sabrina: Kern des Programms: Animals + Testklasse zu Animals
    *   *) Aniela: Kern des Programms: Ecosystem + Testklasse zum Ecosystem
    *   *) Koray: Kern des Programms: Calculation + Testklasse zu Calculation
    *
    *   *) Simulation Klasse, die alles verbindet und die Testklasse, die die Simulation steuert: Gemeinsam wenn der Rest fertig ist
    *  ******* AUFGABE 2 *******
     */

    // JTable table;

    /*
    public Test() {
        setLayout(new FlowLayout());

        String[] columns = {"Year", "Collected amout of food/S", "Available food/S",
                "Recoverd own food", "Found foreign food", "Death rate/S", "Groupsize"};

        Object[][] data = {};

        table = new JTable(new DefaultTableModel(data, columns));
        table.setPreferredScrollableViewportSize(new Dimension(600, 500));
        table.setFillsViewportHeight(true);

        JScrollPane scrollpane = new JScrollPane(table);
        add(scrollpane);
    }*/

    public static void main(String[] args) {
        Simulation simulation = new Simulation(10000, 50, 5000, 100000);

        for (int i = 0; i < 10; i++) {
            simulation.calculateNewYear();

            System.out.println("******* NEW YEAR: YEAR " + i + " *******");

            System.out.println("Amount of Squirrels: " + simulation.getAmountSquirrels());
            System.out.println("Amount of Predators: " + simulation.getAmountPredators());
            System.out.println("Amount of Trees: " + simulation.getAmountTrees());
            System.out.println("Starved squirrels: " + simulation.getDeadSquirrelsByStarved());
            System.out.println("Eaten squirrels: " + simulation.getDeadSquirrelsByEaten());
            System.out.println("Dead by senility squirrels: " + simulation.getDeadSquirrelsBySenility());
            System.out.println("Newly born squirrels: " + simulation.getAmountNewlyBornSquirrels());
        }
    }
}
