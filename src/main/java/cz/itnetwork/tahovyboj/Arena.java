
package cz.itnetwork.tahovyboj;
import java.time.LocalDate;

public class Arena {
    private Bojovnik bojovnik1;
    private Bojovnik bojovnik2;
    private Kostka kostka;
    
public Arena(Bojovnik bojovnik1, Bojovnik bojovnik2, Kostka kostka) {
        this.bojovnik1 = bojovnik1;
        this.bojovnik2 = bojovnik2;
        this.kostka = kostka;
        }
    
private void vykresli() {
    System.out.println("-------------- Aréna -------------- \n");
    System.out.println("Bojovníci: \n");
    vypisBojovnika(bojovnik1);    
    vypisBojovnika(bojovnik2);
    }

private void vypisZpravu(String zprava) {
    System.out.println(zprava);
    try {
            Thread.sleep(500);
        } catch (InterruptedException ex) {
        System.err.println("Chyba, nepovedlo se uspat vlákno");
    }
    }
public void zapas() {
    // původní pořadí
    Bojovnik b1 = bojovnik1;
    Bojovnik b2 = bojovnik2;
    LocalDate datum = LocalDate.now();
    System.out.println("Vitejte v arene!");
    System.out.printf("Dnes dne %s se utka %s s %s! \n\n",datum, bojovnik1, bojovnik2);
    // prohození bojovníků
    boolean zacinaBojovnik2 = (kostka.hod() <= kostka.vratPocetSten() / 2);
    
        if (zacinaBojovnik2) {
        b1 = bojovnik2;
        b2 = bojovnik1;
        }
    System.out.printf("Zacinat bude bojovnik %s! \n\nZapas muze zacit...\n", b1);
    try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        System.err.println("Chyba, nepovedlo se uspat vlakno");
    }
    // cyklus s bojem
        while (b1.nazivu() && b2.nazivu()) {
            b1.utoc(b2);
            vykresli();
            vypisZpravu(b1.vratPosledniZpravu()); // zpráva o útoku
            vypisZpravu(b2.vratPosledniZpravu()); // zpráva o obraně
            if (b2.nazivu()) {
                b2.utoc(b1);
                vykresli();
                vypisZpravu(b2.vratPosledniZpravu()); // zpráva o útoku
                vypisZpravu(b1.vratPosledniZpravu()); // zpráva o obraně
            }   
        System.out.println();
        }
    }


private void vypisBojovnika(Bojovnik b) {
    System.out.println(b);
    System.out.print("Zivot: ");
    System.out.println(b.grafickyZivot());
     if (b instanceof Mag) {
        System.out.print("Mana:  ");
        System.out.println(((Mag)b).grafickaMana());
                 }  
     System.out.println();
}
}
