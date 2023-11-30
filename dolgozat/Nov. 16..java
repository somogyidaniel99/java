import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Virag sargaVirag = new Virag("sárga virág", 3);
        Virag kekVirag = new Virag("kék virág", 7);
        Fa loncFa = new Fa("lonc fa", 9);
        Fa narancsFa = new Fa("narancs fa", 12);

        ArrayList<Noveny> kertNovenyek = new ArrayList<>();
        kertNovenyek.add(sargaVirag);
        kertNovenyek.add(kekVirag);
        kertNovenyek.add(loncFa);
        kertNovenyek.add(narancsFa);

        Kert kert = new Kert(kertNovenyek);

        kert.kertAllapot();

        kert.ontoz(40);

        kert.ontoz(70);
    }
}
class Noveny {
    String nev;
    double vizmennyiseg;

    public Noveny(String nev, double vizmennyiseg) {
        this.nev = nev;
        this.vizmennyiseg = vizmennyiseg;
    }

    public void ontzes(double mennyiseg) {

    }

    @Override
    public String toString() {
        return "A " + nev + "nak " + (vizmennyiseg >= 0 ? "" : "nincs") + " szüksége vízre";
    }
}

class Virag extends Noveny {
    public Virag(String nev, double vizmennyiseg) {
        super(nev, vizmennyiseg);
    }

    @Override
    public void ontzes(double mennyiseg) {
        if (vizmennyiseg < 5) {
            vizmennyiseg += 0.75 * mennyiseg;
        }
    }
}

class Fa extends Noveny {
    public Fa(String nev, double vizmennyiseg) {
        super(nev, vizmennyiseg);
    }

    @Override
    public void ontzes(double mennyiseg) {
        if (vizmennyiseg < 10) {
            vizmennyiseg += 0.4 * mennyiseg;
        }
        else if (vizmennyiseg == 10) {
            vizmennyiseg += 0.04 * mennyiseg;
        }

    }
}

class Kert {
    ArrayList<Noveny> novenyek;

    public Kert(ArrayList<Noveny> novenyek) {
        this.novenyek = novenyek;
    }

    public void kertAllapot() {
        for (Noveny noveny : novenyek) {
            System.out.println(noveny);
        }
    }

    public void ontoz(double mennyiseg) {
        ArrayList<Noveny> aktivek = new ArrayList<>();
        for (Noveny noveny : novenyek) {
            if (noveny.vizmennyiseg < 10) {
                aktivek.add(noveny);
            }
        }

        double reszMennyiseg = aktivek.size() > 0 ? mennyiseg / aktivek.size() : 0;

        for (Noveny noveny : aktivek) {
            noveny.ontzes(reszMennyiseg);
        }

        kertAllapot();
    }
}


























