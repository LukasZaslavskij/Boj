
package cz.itnetwork.tahovyboj;


class Mag extends Bojovnik {
    private int mana;
    private int maxMana;
    private int magickyUtok;
    
    /**
     * konstruktor pro maga
     * @param jmeno
     * @param zivot
     * @param utok
     * @param obrana
     * @param kostka
     * @param mana
     * @param magickyUtok 
     */
public Mag(String jmeno, int zivot, int utok, int obrana, Kostka kostka, int mana, int magickyUtok) {
    super(jmeno, zivot, utok, obrana, kostka);
    this.mana = mana;
    this.maxMana = mana;
    this.magickyUtok = magickyUtok;
    }
    
    @Override
public void utoc(Bojovnik souper) {
    int uder = 0;
    // Mana není naplněna
    if (mana < maxMana) {
        mana += 10;
        if (mana > maxMana) {
            mana = maxMana;
        }
        super.utoc(souper);
    } else { // Magický útok
        uder = magickyUtok + kostka.hod();
        nastavZpravu(String.format("%s pouzil magii za %s hp", jmeno, uder));
        mana = 0;
    }
    souper.branSe(uder);
}
    

public String grafickaMana() {
    return grafickyUkazatel(mana, maxMana);
}
   
}
