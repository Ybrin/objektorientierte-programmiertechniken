package eichhoernchen;

import versteck.*;

import java.lang.reflect.Type;

/**
 * Created by Sabrina on 04.12.2016.
 */
public class Eichhoernchen {

    /**
     * Fix festgelegter name, wird einmalig im konstruktor definiert
     */
    private final String name;

    /**
     * das erste Versteck des Eichhoernchens
     */
    private EichhoernchenKnoten erstes = null;

    /**
     * Erzeugt ein neues eichhoernchen mit dem gegebenen Namen
     *
     * @param name Der Name des Eichhoernchens
     */
    public Eichhoernchen(String name) {
        this.name = name;
    }

    /**
     * Fügt dem eichhoernchen ein Versteck am ende der Versteck instanzen ein
     * dieses darf nicht null sein
     * wenn eins==null dann wird das versteck an erste stelle gesetzt
     *
     * @param versteck Das Versteck welches hinzugefügt werden soll
     */
    public void versteckHinzufuegen(Versteck versteck) {
        if (versteck != null) {
            if (erstes == null) {
                erstes = new EichhoernchenKnoten(versteck);
            } else {
                EichhoernchenKnoten knotten = erstes;
                while (knotten.getNechstes() != null) {
                    knotten = knotten.getNechstes();
                }
                knotten.setNechstes(new EichhoernchenKnoten(versteck));
            }
        }
    }

    /**
     * Die methode entfernt das angegebene versteck
     * dies geschieht durch ueberspringen des angegebenen Verstecks
     * Versteck darf nicht null sein
     *
     * @param versteck zu loeschendes Versteck
     */
    public void versteckEntfernen(Versteck versteck) {
        if (versteck != null) {
            if (erstes != null) {
                if (erstes.getVersteck().nummer() == versteck.nummer()) {
                    erstes = null;
                } else {
                    EichhoernchenKnoten knotten = erstes;
                    EichhoernchenKnoten letzter = erstes;
                    while (knotten.getVersteck().nummer() != versteck.nummer() && knotten.getNechstes() != null) {
                        letzter = knotten;
                        knotten = knotten.getNechstes();
                    }
                    if (knotten != letzter) {
                        if (knotten.getNechstes() == null) {
                            if (knotten.getVersteck().nummer() == versteck.nummer()) {
                                letzter.setNechstes(null);
                            }
                        } else {
                            letzter.setNechstes(knotten.getNechstes());
                        }
                    }
                }
            }
        }
    }

    /**
     * Berechnet das Durchschnittlich zur verfuegung stehende Volumen aller
     * durch nahrungsmittel festgelegten Nahrungsmittel arten
     * wenn nahrungsmittel null ist, wird das gesamt verfügbare Volumen aus gegeben
     *
     * @param nahrungsmittel Die Art von Nahrungsmitteln welche miteinbezogen werden soll in die Berechnung.
     *                       Darf nicht null sein.
     * @return durchschnittliche Volumen
     */
    public double durchschnittlichesVolumenNahrungsmittel(Nahrungsmittel nahrungsmittel) {
        double durchschnitt = 0.0;
        double zaehler = 0.0;
        if (erstes != null) {
            EichhoernchenKnoten knoten = erstes;
            if (nahrungsmittel == null) {
                while (knoten != null) {
                    durchschnitt += knoten.getVersteck().volumen();
                    knoten = knoten.getNechstes();
                    zaehler++;
                }
                if (durchschnitt > 0) {
                    durchschnitt = durchschnitt / zaehler;
                }
            } else {
                while (knoten != null) {
                    if (knoten.getVersteck().futter().equals(nahrungsmittel)) {
                        durchschnitt += knoten.getVersteck().volumen();
                        zaehler++;
                    }
                    knoten = knoten.getNechstes();
                }
                if (durchschnitt > 0) {
                    durchschnitt = durchschnitt / zaehler;
                }
            }
        } else {
            return 0;
        }
        return durchschnitt;
    }

    /**
     * Berechnet das Durchschnittlich zur verfuegung stehende Volumen aller
     * durch verstck festgelegten Versteck Typen
     * wenn versteck null ist, wird das gesamt verfügbare Volumen aus gegeben
     *
     * @param versteck Typ für den gesamt volumen berechnent werden soll
     * @return durchschnittliche Volumen
     */
    public double durchschnittlichesVolumenTyp(Type versteck) {
        double volumen = 0;
        double anzahl = 0;


        if (erstes != null) {
            EichhoernchenKnoten knoten = erstes;
            if (versteck == null) {

                while (knoten != null) {
                    volumen += knoten.getVersteck().volumen();
                    knoten = knoten.getNechstes();
                    anzahl++;
                }
                volumen = volumen / anzahl;

            }
            if (versteck == IBaumversteck.class) {
                while (knoten != null) {
                    if (knoten.getVersteck() instanceof IBaumversteck) {
                        volumen += knoten.getVersteck().volumen();
                        anzahl++;
                    }
                    knoten = knoten.getNechstes();
                }
            } else if (versteck == IErdversteck.class) {
                while (knoten != null) {
                    if (knoten.getVersteck() instanceof IErdversteck) {
                        volumen += knoten.getVersteck().volumen();
                        anzahl++;
                    }
                    knoten = knoten.getNechstes();
                }
            }
        } else {
            return 0;
        }
        return anzahl != 0 ? volumen / anzahl : 0;
    }

    /**
     * Berechnet die durchschnittshoehe aller Baumverstecke des eichhoernchens
     *
     * @return durchschnitts hoehe
     */
    public double durchschnittlicheHoehe() {
        double hohe = 0;
        double anzahl = 0;

        if (erstes != null) {
            EichhoernchenKnoten knoten = erstes;
            while (knoten != null) {
                if (knoten.getVersteck() instanceof IBaumversteck) {
                    IBaumversteck baumversteck = (Baumversteck) knoten.getVersteck();
                    hohe = baumversteck.getHoehe();
                    anzahl++;
                }
                knoten = knoten.getNechstes();
            }

        } else {
            return 0;
        }
        return anzahl != 0 ? hohe / anzahl : 0;
    }

    /**
     * Berschnet die durchschnittliche entferneung zwischen dem Nest
     * und allen erdverstecken mit dem angegebenen Nahrungsmittel
     * wenn das Nahrungsmittel null ist, wird die  Durchschnitts Entfernung aller Erdverstecke berechnet
     *
     * @param nahrungsmittel
     * @return durchschnitt entfernung
     */
    public double durchschnittlicheEntfernung(Nahrungsmittel nahrungsmittel) {
        double entfernung = 0;
        double anzahl = 0;
        if (erstes != null) {
            EichhoernchenKnoten knoten = erstes;
            if (nahrungsmittel == null) {
                while (knoten != null) {
                    if (knoten.getVersteck() instanceof IErdversteck) {
                        entfernung += ((IErdversteck) knoten.getVersteck()).entfernungNest();
                        anzahl++;
                    }
                    knoten = knoten.getNechstes();
                }
            } else {
                while (knoten != null) {
                    if (knoten.getVersteck() instanceof IErdversteck) {
                        if (knoten.getVersteck().futter().equals(nahrungsmittel)) {
                            entfernung += ((IErdversteck) knoten.getVersteck()).entfernungNest();
                            anzahl++;
                        }
                    }
                    knoten = knoten.getNechstes();
                }
            }
        } else {
            return 0;
        }
        return anzahl != 0 ? entfernung / anzahl : 0;
    }

    /**
     * Berschnet die Durchschnittliche anzahl aller nuesse in abhängigkeit von
     * ihrem Versteck
     * bei versteck ==null werden alle Versteck arten mit ein bezogen
     *
     * @param versteck
     * @return durchschnitt nuesse
     */
    public double durchschnittlicheAnzahlNuesse(Type versteck) {
        double nuesse = 0;
        double anzahl = 0;

        if (erstes != null) {
            EichhoernchenKnoten knoten = erstes;
            if (versteck == null) {
                while (knoten != null) {
                    if (knoten.getVersteck().futter().equals(Nahrungsmittel.NUESSE)) {
                        nuesse += knoten.getVersteck().nahrungsmittelMenge();
                        anzahl++;
                    }
                    knoten = knoten.getNechstes();
                }
            } else {
                if (versteck == IErdversteck.class) {
                    while (knoten != null) {
                        if (knoten.getVersteck() instanceof IErdversteck) {
                            if (knoten.getVersteck().futter().equals(Nahrungsmittel.NUESSE)) {
                                nuesse += knoten.getVersteck().nahrungsmittelMenge();
                                anzahl++;
                            }
                        }
                        knoten = knoten.getNechstes();
                    }
                }
                if (versteck == IBaumversteck.class) {
                    while (knoten != null) {
                        if (knoten.getVersteck() instanceof IBaumversteck) {
                            if (knoten.getVersteck().futter().equals(Nahrungsmittel.NUESSE)) {
                                nuesse += knoten.getVersteck().nahrungsmittelMenge();
                                anzahl++;
                            }
                        }
                        knoten = knoten.getNechstes();
                    }
                }
            }
        } else {
            return 0;
        }
        return anzahl != 0 ? nuesse / anzahl : 0;
    }

    /**
     * Berschnet die Durchschnittliche anzahl aller Samen in abhängigkeit von
     * ihrem Versteck
     * bei versteck ==null werden alle Versteck arten mit ein bezogen
     *
     * @param versteck
     * @return durchschnitt Samen
     */
    public double durchschnittlicheAnzahlSamen(Type versteck) {
        double samen = 0;
        double anzahl = 0;

        if (erstes != null) {
            EichhoernchenKnoten knoten = erstes;
            if (versteck == null) {
                while (knoten != null) {
                    if (knoten.getVersteck().futter().equals(Nahrungsmittel.SAMEN)) {
                        samen += knoten.getVersteck().nahrungsmittelMenge();
                        anzahl++;
                    }
                    knoten = knoten.getNechstes();
                }
            } else {
                if (versteck == IErdversteck.class) {
                    while (knoten != null) {
                        if (knoten.getVersteck() instanceof IErdversteck) {
                            if (knoten.getVersteck().futter().equals(Nahrungsmittel.SAMEN)) {
                                samen += knoten.getVersteck().nahrungsmittelMenge();
                                anzahl++;
                            }
                        }
                        knoten = knoten.getNechstes();
                    }
                }
                if (versteck == IBaumversteck.class) {
                    while (knoten != null) {
                        if (knoten.getVersteck() instanceof IBaumversteck) {
                            if (knoten.getVersteck().futter().equals(Nahrungsmittel.SAMEN)) {
                                samen += knoten.getVersteck().nahrungsmittelMenge();
                                anzahl++;
                            }
                        }
                        knoten = knoten.getNechstes();
                    }
                }
            }
        } else {
            return 0;
        }
        return samen / anzahl;
    }


    /**
     * berechnet die gesamt anzahl aller nuesse in abhängigkeit des Versteck Typs
     * bei versteck ==null werden alle Verstecks Typen berücksichtigt
     *
     * Unterstuetzt die typen IErdversteck und IBaumversteck und null. Ist "versteck" keines davon,
     * returnt diese methode 0
     *
     * @param versteck
     * @return gesamt anzahl aller Nuesse
     */
    public double maximalAnzahlNuesse(Type versteck) {
        double nuesse = 0;
        if (erstes != null) {
            EichhoernchenKnoten knoten = erstes;

            if (versteck == null) {
                while (knoten != null) {
                    if (knoten.getVersteck().futter().equals(Nahrungsmittel.NUESSE)) {
                        nuesse += knoten.getVersteck().nahrungsmittelMenge();
                    }
                    knoten = knoten.getNechstes();
                }
            } else {
                if (versteck == IErdversteck.class) {
                    while (knoten != null) {
                        if (knoten.getVersteck() instanceof IErdversteck) {
                            if (knoten.getVersteck().futter().equals(Nahrungsmittel.NUESSE)) {
                                nuesse += knoten.getVersteck().nahrungsmittelMenge();
                            }
                        }
                        knoten = knoten.getNechstes();
                    }
                }
                if (versteck == IBaumversteck.class) {
                    while (knoten != null) {
                        if (knoten.getVersteck() instanceof IBaumversteck) {
                            if (knoten.getVersteck().futter().equals(Nahrungsmittel.NUESSE)) {
                                nuesse += knoten.getVersteck().nahrungsmittelMenge();
                            }
                        }
                        knoten = knoten.getNechstes();
                    }
                }
            }
        } else {
            return 0;
        }
        return nuesse;
    }

    /**
     * berechnet die gesamt anzahl aller Samen in abhängigkeit des Versteck Typs
     * bei versteck ==null werden alle Verstecks Typen berücksichtigt
     *
     * Unterstuetzt die typen IErdversteck und IBaumversteck und null. Ist "versteck" keines davon,
     * returnt diese methode 0
     *
     * @param versteck Der typ
     * @return gesamt anzahl aller Samen
     */
    public double maximalAnzahlSamen(Type versteck) {
        double samen = 0;

        if (erstes != null) {
            EichhoernchenKnoten knoten = erstes;
            if (versteck == null) {
                while (knoten != null) {
                    if (knoten.getVersteck().futter().equals(Nahrungsmittel.SAMEN)) {
                        samen += knoten.getVersteck().nahrungsmittelMenge();
                    }
                    knoten = knoten.getNechstes();
                }
            } else {
                if (versteck == IErdversteck.class) {
                    while (knoten != null) {
                        if (knoten.getVersteck() instanceof IErdversteck) {
                            if (knoten.getVersteck().futter().equals(Nahrungsmittel.SAMEN)) {
                                samen += knoten.getVersteck().nahrungsmittelMenge();
                            }
                        }
                        knoten = knoten.getNechstes();
                    }
                }
                if (versteck == IBaumversteck.class) {
                    while (knoten != null) {
                        if (knoten.getVersteck() instanceof IBaumversteck) {
                            if (knoten.getVersteck().futter().equals(Nahrungsmittel.SAMEN)) {
                                samen += knoten.getVersteck().nahrungsmittelMenge();
                            }
                        }
                        knoten = knoten.getNechstes();
                    }
                }
            }
        } else {
            return 0;
        }
        return samen;
    }


    /**
     * aendert den inhalt des angegebenen Verstecks auf nahrungsmittel
     * nahrungsmittel darf nicht null sein, versteck darf nicht null sein
     *
     * @param versteck
     * @param nahrungsmittel
     */
    public void neuerInhalt(Versteck versteck, Nahrungsmittel nahrungsmittel) {
        int number = versteck.nummer();
        if (nahrungsmittel != null) {
            if (erstes != null) {
                EichhoernchenKnoten knoten = erstes;
                while (knoten != null) {
                    if (number == knoten.getVersteck().nummer()) {
                        knoten.getVersteck().nahrungsmittelartAendern(nahrungsmittel);
                    }
                    knoten = knoten.getNechstes();
                }
            }
        }
    }

    /**
     * verringet die menge des angegeben Verstecks um die angegebene Menge
     * das Verstack darf nicht null  sein
     * wenn die angegebene Menge groeßer als die verfuegbare menge ist wird die menge des verstecks auf 0 gesetzt
     *
     * @param menge
     * @param versteck
     */
    public void verringereMenge(double menge, Versteck versteck) {
        int number = versteck.nummer();
        if (versteck != null) {
            if (erstes != null) {
                EichhoernchenKnoten knoten = erstes;
                while (knoten != null) {
                    if (number == knoten.getVersteck().nummer()) {
                        if (menge > versteck.nahrungsmittelMenge()) {
                            knoten.getVersteck().futterVerringern(versteck.nahrungsmittelMenge());
                        } else {
                            knoten.getVersteck().futterVerringern(menge);
                        }

                    }
                    knoten = knoten.getNechstes();
                }
            }
        }
    }

    /**
     * erhoeht die menge von Versteck um die angegebene menge
     * Versteck darf nicht null sein
     *
     * @param menge
     * @param versteck
     */
    public void erhoeheMenge(double menge, Versteck versteck) {
        int number = versteck.nummer();
        if (versteck != null) {
            if (erstes != null) {
                EichhoernchenKnoten knoten = erstes;
                while (knoten != null) {
                    if (number == knoten.getVersteck().nummer()) {
                        knoten.getVersteck().futterErhoehehn(menge);
                    }
                    knoten = knoten.getNechstes();
                }
            }
        }
    }

    /**
     * gibt die gesamte menge an lebensmitteln in einem Spezifizieren Versteck an
     * das versteck darf nicht null sein
     *
     * @param versteck
     * @return gesamte menge
     */
    public double menge(Versteck versteck) {
        int number = versteck.nummer();
        double menge = 0.0;
        if (versteck != null) {
            if (erstes != null) {
                EichhoernchenKnoten knoten = erstes;
                while (knoten != null) {
                    if (number == knoten.getVersteck().nummer()) {
                        menge = knoten.getVersteck().nahrungsmittelMenge();
                    }
                    knoten = knoten.getNechstes();
                }
            } else {
                return 0;
            }
        }
        return menge;
    }

    /**
     * Gibt den Namen dieses Eichhoernchens zurueck
     *
     * @return Der Name dieses Eichhoernchens
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("******* ").append(name).append(" *******");
        builder.append("\n");
        builder.append("Durchschnittliches Volumen gesamt: ").append(durchschnittlichesVolumenTyp(null));
        builder.append("\n");
        builder.append("Durchschnittliche Anzahl Nüsse gesamt: ").append(durchschnittlicheAnzahlNuesse(null));
        builder.append("\n");
        builder.append("Durchschnittliche Anzahl Samen gesamt: ").append(durchschnittlicheAnzahlSamen(null));
        builder.append("\n");
        builder.append("Durchschnittliche Entfernung Nüsse: ").append(durchschnittlicheEntfernung(Nahrungsmittel.NUESSE));
        builder.append("\n");
        builder.append("Durchschnittliche Entfernung Samen: ").append(durchschnittlicheEntfernung(Nahrungsmittel.SAMEN));
        builder.append("\n");
        builder.append("Durchschnittliche Höhe: ").append(durchschnittlicheHoehe());
        builder.append("\n");
        builder.append("Durchschnittliches Volumen Nüsse gesamt: ").append(durchschnittlichesVolumenNahrungsmittel(Nahrungsmittel.NUESSE));
        builder.append("\n");
        builder.append("Durchschnittliches Volumen Samen gesamt: ").append(durchschnittlichesVolumenNahrungsmittel(Nahrungsmittel.SAMEN));
        builder.append("\n");
        builder.append("Maximale Anzahl Nüsse gesamt: ").append(maximalAnzahlNuesse(null));
        builder.append("\n");
        builder.append("Maximale Anzahl Samen gesamt: ").append(maximalAnzahlSamen(null));
        builder.append("\n");
        builder.append("\n");

        builder.append("--- Verstecke ---");
        builder.append("\n");

        EichhoernchenKnoten current = erstes;
        while (current != null) {
            Versteck v = current.getVersteck();

            builder.append("-- Versteck Nummer: ").append(v.nummer());
            builder.append("\n");
            builder.append("Volumen: ").append(v.volumen());
            builder.append("\n");
            builder.append("Futterart: ").append(v.futter().toString());
            builder.append("\n");
            builder.append("Nahrungsmittelmenge: ").append(v.nahrungsmittelMenge());
            builder.append("\n");
            builder.append("Entfernung vom Nest aus: ").append(v.entfernungNest());
            builder.append("\n");

            current = current.getNechstes();
        }

        return builder.toString();
    }
}

