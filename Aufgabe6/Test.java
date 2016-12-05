import versteck.*;

/**
 * Created by Sabrina on 04.12.2016.
 */
public class Test {

    public static void main(String[] args) {

        Versteck versteck1 = new Baumversteck(1, 8.4, Nahrungsmittel.NUESSE, "Buche", 14);
        Versteck versteck2 = new Erdversteck(2, 17.4, Nahrungsmittel.SAMEN, 32.7, 19.0);

        System.out.println(versteck1.nummer());
        System.out.println(versteck1.volumen());
        System.out.println(versteck1.futter());
        versteck1.nahrungsmittelartAendern(Nahrungsmittel.SAMEN);
        versteck1.futterErhoehehn(78);
        System.out.println(versteck1.nahrungsmittelMenge());

        if (versteck1 instanceof IBaumversteck) {
            IBaumversteck baumversteck = (IBaumversteck) versteck1;
            System.out.println(baumversteck.getBaumart());
            System.out.println(baumversteck.getHoehe());
        }

        System.out.println(versteck2.nummer());
        System.out.println(versteck2.volumen());
        System.out.println(versteck2.futter());
        versteck2.nahrungsmittelartAendern(Nahrungsmittel.NUESSE);
        versteck2.futterErhoehehn(66);
        System.out.println(versteck2.nahrungsmittelMenge());

        if (versteck2 instanceof IErdversteck) {
            IErdversteck erdversteck = (IErdversteck) versteck2;
            System.out.println(erdversteck.entfernungNest());
        }
    }
}
