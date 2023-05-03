import java.util.Random;
/**
 * Trieda doska, ktorá vytvorí novú dosku s ktorou je možné pohybovať.
 * 
 * @author Patrik Pavlík 
 * @version 1.57.22
 */
public class Doska {
    private Obdlznik obdlznik;
    private int lavyHornyX;
    private int lavyHornyY;
    private int pravyDolnyX;
    private int pravyDolnyY;
    private boolean vyditelne;

    /**
     * Vytvorí novú dosku kde používateľ zadá pozíciu a veľkosť dosky.
     * 
     * @param lavyHornyX - pozicia laveho horneho X na platne
     * @param lavyHornyY - pozicia laveho horneho Y na platne
     * @param strana A - velkost strany A
     * @param strana A - velkost strany B
     */
    public Doska(int lavyHornyX, int lavyHornyY, int stranaA, int stranaB) {
        this.vyditelne = true;
        this.lavyHornyX = lavyHornyX;
        this.lavyHornyY = lavyHornyY;
        this.pravyDolnyX = lavyHornyX + stranaA;
        this.pravyDolnyY = lavyHornyY + stranaB;
        this.obdlznik = new Obdlznik();
        this.obdlznik.zmenPolohu(this.lavyHornyX, this.lavyHornyY);
        this.obdlznik.zmenStrany(stranaA, stranaB);
        this.randomFarba();
        this.obdlznik.zobraz();
    }

    /**
     * Boolean metóda na overenie či sa doska prekrýva.
     * @param d určuje ďalšiu dosku
     */
    public boolean prekrivajuSa(Doska d) {
        if (this.lavyHornyX == this.pravyDolnyX || this.lavyHornyY == this.pravyDolnyY || d.getLavyHornyX() == d.getPravyDolnyX()  || d.getLavyHornyY() == d.getPravyDolnyY()) {
            return false;
        }
        
        if (this.lavyHornyX > d.getPravyDolnyX() || d.getLavyHornyX() > this.pravyDolnyX) {
            return false;
        }
        
        if (this.pravyDolnyY > d.getLavyHornyY() && d.getPravyDolnyY() > this.lavyHornyY) {
            return true;
        }

        return false;
    }

    /**
     * Vrati poziciu dosky lavej hornej X pozície.
     * 
     */
    public int getLavyHornyX() {
        return this.lavyHornyX;
    }

    /**
     * Vrati poziciu dosky lavej hornej Y pozície.
     * 
     */
    public int getLavyHornyY() {
        return this.lavyHornyY;
    }

    /**
     * Vrati poziciu dosky pravej dolnej X pozície.
     * 
     */
    public int getPravyDolnyX() {
        return this.pravyDolnyX;
    }

    /**
     * Vrati poziciu dosky pravej dolnej Y pozície.
     * 
     */
    public int getPravyDolnyY() {
        return this.pravyDolnyY;
    }

    /**
     * Posunie dosku o požadovanú X a Y pozíciu.
     * @param kolkoX - o kolko X sa ma posunut doska
     * @param kolkoY - o kolko Y sa ma posunut doska
     */
    public void posun(int kolkoX, int kolkoY) {
        this.obdlznik.zmenPolohu(this.lavyHornyX + kolkoX, this.lavyHornyY + kolkoY);
        this.lavyHornyX += kolkoX;
        this.lavyHornyY += kolkoY;
        this.pravyDolnyX += kolkoX;
        this.pravyDolnyY += kolkoY;
    }

    /**
     * Zmena farby dosky
     *
     * @param farba zmena farby dosky na zaklade retazca
     */
    public void zmenFarbu(String farba) {
        this.obdlznik.zmenFarbu(farba);
    }
    
    /**
     * Náhodná farba dosky
     *
     */
    public void randomFarba() {
        String[] poleFarieb = {"red", "yellow", "blue", "green", "magenta", "black", "brown"};
        Random random = new Random();
        int i = random.nextInt(poleFarieb.length);
        this.obdlznik.zmenFarbu(poleFarieb[i]);
    }

    /**
     *  Skryje dosku
     */
    public void skry() {
        this.obdlznik.skry();
        this.vyditelne = false;
    }

    /**
     * Boolean na overenie či je doska viditeľná.
     */
    public boolean isVyditelne() {
        return this.vyditelne;
    }
}