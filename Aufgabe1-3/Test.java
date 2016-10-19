import simulation.Group;
import simulation.Population;

import java.util.ArrayList;
import java.util.List;

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
        Group group1 = new Group(1000, 30, 10, 0.8, 0.1, 0.13);
        Group group2 = new Group(1000, 15, 8, 0.8, 0.4, 0.16);
        Group group3 = new Group(1000, 30, 9, 0.8, 0.2, 0.14);
        Group group4 = new Group(1000, 25, 20, 0.8, 0.2, 0.12);
        Group group5 = new Group(1000, 10, 5, 0.74, 0.1, 0.15);
        Group group6 = new Group(1000, 10, 20, 0.85, 0.15, 0.15);

        List<Group> groups = new ArrayList<>();

        groups.add(group1);
        groups.add(group2);
        groups.add(group3);
        groups.add(group4);
        groups.add(group5);
        groups.add(group6);

        Population population = new Population(groups);

        /*
        Test gui = null;
        try {
            gui = new Test();
            gui.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            gui.setSize(800, 600);
            gui.setVisible(true);
            gui.setTitle("Squirrel Statistics");
        } catch (java.awt.HeadlessException e) {
            System.err.println("GUI not available, skipping that...");
        }*/

        // DefaultTableModel model = (gui != null) ? (DefaultTableModel) gui.table.getModel() : null;


        List<Group> groupList = population.getGroups();

        for (int j = 0; j < groupList.size(); j++) {
            Group group = groupList.get(j);
            // if (model != null) model.addRow(new Object[]{"Group" + (j + 1)});

            System.out.println();
            System.out.println("Group " + (j + 1) + " uses " + group.getStrategy() + "!");

            int oldSize = group.getGroupsize();
            System.out.format("%20s%20s%20s%20s%20s%20s%20s", "Year", "Collected_Food", "Avalable_food", "Recovered_own_food", "Found_Foreign_Food", "Deaths", "Groupsize");
            for (int i = 1; i <= 10; i++) {
                group.simulateYearPass();
                /*if (model != null)
                    model.addRow(new Object[]{i, group.getCollectedFoodPerIndividual(), group.getHuntableFoodPerIndiviual(), (int) (group.getRecoveredOwnFood() * 100) + "%",
                            (int) (group.getFoundForeignFood() * 100) + "%", (int) (group.getDeathRate() * 100) + "%", group.getGroupsize()});*/

                System.out.println();
                System.out.format("%20s%20s%20s%20s%20s%20s%20s", i, group.getCollectedFoodPerIndividual(), group.getHuntableFoodPerIndiviual(), (int) (group.getRecoveredOwnFood() * 100) + "%",
                        (int) (group.getFoundForeignFood() * 100) + "%", (int) (group.getDeathRate() * 100) + "%", group.getGroupsize());

            }
            // Reset group size to have a unique simulation for the other groups
            group.setGroupsize(oldSize);
        }
        System.out.println();
        System.out.println("Different Strategies: " + population.getDifferentStrategies());
    }
}
