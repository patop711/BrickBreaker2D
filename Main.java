import javax.swing.JOptionPane;
/**
 * 
 * Trieda Main, spustí hru.
 * 
 * @author Patrik Pavlík
 * @version 1.57.22
 */

public class Main {
    public static void main(String[] args) {
        //Lokálna premenná pre pocet riadkov
        int riadky;
        //Lokálna premenná pre pocet stĺpcov
        int stlpce;
        //Vstup vo forme |stlpce + medzera + riadky| napr. |3 9|
        String cele = JOptionPane.showInputDialog(null, "Zadaj počet stĺpcov + medzera + počet riadkov", "Brick Breaker", JOptionPane.INFORMATION_MESSAGE);
        //Ak sa zruší vstup, tak sa program sa ukončí.
        if (cele == null) {
            System.exit(0);
        }
        if (!cele.equals("")) {
            //Rozdelenie vstupu na dva reťazce --> " "
            String[] rozdelene = cele.split(" ");
            //Prvý reťazec t.j. stĺpce sa prevedie na číslo a uloží sa do lok. premennej stĺpce
            stlpce = Integer.parseInt(rozdelene[0]);
            //Ak je počet stĺpcov menší ako 1 alebo väčší ako 9, nastaví sa na 9
            if (stlpce < 1) {
                stlpce = 9;
            } else if (stlpce > 9) {
                stlpce = 9;
            }
            //Ak nie je zadaný druhy reťazec t.j. riadky, nastaví sa počet riadkov na 3
            if (rozdelene.length < 2) {
                riadky = 3;
            } else {
                //Druhý reťazec t.j.riadky sa prevedie na číslo a uloží sa do lok. premennej riadky
                riadky = Integer.parseInt(rozdelene[1]);
                //Ak je počet riadkov menší ako 1 nastaví sa na 3,alebo väčší ako 6 nastaví sa na 4
                if (riadky < 1) {
                    riadky = 3;
                } else if (riadky > 6) {
                    riadky = 4;
                }
            }
        } else {
            //Ak používateľ zadal prázdny reťazec, tak sa automaticky nastaví počet riadkov na 3 a počet stĺpcov na 9
            riadky = 3;
            stlpce = 9;
        }
        //Vytvorí sa inštancia triedy Ovladanie so zadaním počtom riadkov a stĺpcov
        new Ovladanie(riadky, stlpce);
    }
}