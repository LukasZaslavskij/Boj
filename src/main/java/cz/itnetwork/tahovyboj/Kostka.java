
package cz.itnetwork.tahovyboj;
import java.util.Random;

public class Kostka {
    //Generator nahodnych cisel     
    private Random random;    
    //pocet sten kostky     
    private int pocetSten; 
        
    
    
public Kostka(){  //konstruktor kostky
    pocetSten=6;
    random=new Random();
    }
    /**
     * konstruktor kostky s paramterem
     * @param pocetSten sten kostky
     */
public Kostka(int pocetSten){
    this.pocetSten=pocetSten;
    random=new Random();
     }
     
public int vratPocetSten(){  //vrati pocet sten
    return pocetSten;
    }
    
    
    /**
     * definice metody hod
     * @return cislo od 1 do poctu sten
     */
public int hod(){
    return random.nextInt(pocetSten) + 1;
    }
    
    
    
@Override
public String toString() {
    return String.format("Kostka s %s stěnami", pocetSten);
    }
        }