/**
 * Trieda hráč, ktorá vytvorí novú dosku pre hráča.
 * 
 * @author Patrik Pavlík 
 * @version 1.57.22
 */
public class Hrac {
    private Doska doska;

    /**
     * Vytvorí novú dosku pre hráča s preddefinovanou pozíciou a farbou.
     */
    public Hrac() {
        this.doska = new Doska(370, 490, 120, 5);
    }

    /**
     * Nastavenie smeru pohybu dosky hráča vľavo a vpravo.
     * @param smer určuje, či sa má doska pohybovať vľavo alebo vpravo.
     */
    public void pohyb(boolean smer) {
        if (smer && this.doska.getLavyHornyX() < 740) {
            this.doska.posun(10, 0);
        } else if (!smer && this.doska.getLavyHornyX() > 1) {
            this.doska.posun(-10, 0);
        }
    }

    /**
     * Vráti objekt triedy Doska.
     *
     */
    public Doska getDoska() {
        return this.doska;
    }
}