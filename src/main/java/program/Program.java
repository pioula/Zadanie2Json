package program;

import Wyjatki.BladWykonania;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Program {
    private Wyrazenie kod;
    private Map<String, Double> zmienne;
    private Set<String> zadeklarowaneZmienne;

    public Program(Wyrazenie kod) {
        this.kod = kod;
        zmienne = new HashMap<>();
        zadeklarowaneZmienne = new TreeSet<>();
    }

    public double wykonaj() throws BladWykonania {
       return kod.wykonaj(this);
    }

    public void zaktualizujZmienna(String nazwa, double wartosc) {
        zmienne.put(nazwa, wartosc);
    }

    public double wartoscZmiennej(String nazwa) {
        if (zmienne.containsKey(nazwa)) {
            return zmienne.get(nazwa);
        }
       else {// wszystkie zmienne są globalne, początkowo zadeklarowane na 0
            zmienne.put(nazwa, 0.0);
            return 0;
        }
    }

    public boolean czyZadeklarowana(String nazwa) {
        return zadeklarowaneZmienne.contains(nazwa);
    }

    public void usunDeklaracje(String nazwa) {
        zadeklarowaneZmienne.remove(nazwa);
    }

    public void zadeklarujZmienna(String nazwa) {
        zadeklarowaneZmienne.add(nazwa);
    }

    /*public void toJava(File f) {
        FileWriter writer;
        try {
            writer = new FileWriter(f);
            writer.write(kod.toJava(this));
            writer.close();
            System.out.println();
        }
        catch(Exception ex) {
            System.out.println("Blad");
        }
    }*/
}
