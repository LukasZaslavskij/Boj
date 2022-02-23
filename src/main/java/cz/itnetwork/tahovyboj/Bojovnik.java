
package cz.itnetwork.tahovyboj;


public class Bojovnik {
    /**
     * atributy tridy
     */
   protected String jmeno;
   protected int zivot;
   protected int maxZivot;
   protected int utok;
   protected int obrana;
   protected Kostka kostka;
   private String zprava;
    
    /**
     *zvoleni atribut bojovnika
     * @param jmeno 
     * @param zivot
     * @param utok
     * @param obrana
     * @param kostka
     */
public Bojovnik(String jmeno, int zivot, int utok, int obrana, Kostka kostka) {
    this.jmeno = jmeno;
    this.zivot = zivot;
    this.maxZivot = zivot;
    this.utok = utok;
    this.obrana = obrana;
    this.kostka = kostka;
}
    @Override
public String toString() {
    return jmeno;
}

public boolean nazivu() { //je bojovnik zivy
    return (zivot > 0);
}

protected String grafickyUkazatel(int aktualni, int maximalni) { //pro zivoty nebo manu
    String s = "[";
    int celkem = 20;
    double pocet = Math.round(((double)aktualni / maximalni) * celkem);
        if ((pocet == 0) && (nazivu())) {
        pocet = 1;
        }
    
        for (int i = 0; i < pocet; i++) {
        s += "#";
        }
    
    s = String.format("%1$-" + (celkem + 1) + "s", s);
    s += "]";
    return s;
}


public void branSe(int uder) { //obrana bojovnika
    int zraneni = uder - (obrana + kostka.hod());
        if (zraneni > 0) {
        zivot -= zraneni;
        zprava = String.format("%s utrpel poskozeni %s hp", jmeno, zraneni);
            if (zivot <= 0) {
            zivot = 0;
            zprava += " a zemrel";
        }
    }
        else
        zprava = String.format("%s odrazil utok", jmeno);
        nastavZpravu(zprava);
}


public String grafickyZivot() {
    return grafickyUkazatel(zivot, maxZivot);
            }

public void utoc(Bojovnik souper) { //utok bojovnika
    int uder = utok + kostka.hod();
    nastavZpravu(String.format("%s utoci s uderem za %s hp", jmeno, uder));
    souper.branSe(uder);
            }

protected void nastavZpravu(String zprava) {
    this.zprava = zprava;
            }

public String vratPosledniZpravu() {
    return zprava;
            }
}
