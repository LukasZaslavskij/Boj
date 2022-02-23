
package cz.itnetwork.tahovyboj;


public class TahovyBoj {
    
    
public static void main(String[] args) {
      
    Kostka kostka = new Kostka(10); // zvol kostku, bez parametru - default 6
    /**
     * Bojovník - jméno, zivot obrana kostka
     * u mága ještě mana a magický útok
    */
    Bojovnik zalgoren = new Bojovnik("Zalorgen", 100, 29, 15, kostka); 
    Bojovnik shadow = new Mag("Shadow", 100, 15, 20, kostka,30,45);
    
    Arena arena = new Arena(zalgoren, shadow, kostka); //vyber bojovniky do boje
        
    arena.zapas();
   
}
}
