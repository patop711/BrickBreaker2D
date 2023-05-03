/**
 * Trieda lopta, ktorá vytvorí novú loptu s ktorou je možné pohybovať.
 * 
 * @author Patrik Pavlík 
 * @version 1.57.22
 */
public class Lopta {
    private Doska lopta;
    private byte smerX;
    private byte smerY;

    /**
     * Vytvorí novú loptu s preddefinovanou pozíciou, velkosťou a farbou.
     */
    public Lopta() {
        this.smerY = 1;
        this.smerX = 1;
        this.lopta = new Doska(425, 245, 10, 10);
    }

    /**
     * Nastavenie smeru pohybu lopty.
     */
    public void pohyb() {
        this.lopta.posun((this.smerX * 2) , (this.smerY * 2));

        if (this.lopta.getLavyHornyX() < 0) {
            this.smerX = 1;
        }

        if (this.lopta.getLavyHornyY() < 0) {
            this.smerY = 1;
        }

        if (this.lopta.getPravyDolnyX()  > 860) {
            this.smerX = -1;
        }
    }

    /**
     * Vratenie objektu triedy Doska.
     * 
     */
    public Doska vratLoptu() {
        return this.lopta;
    }

    /**
     * Nastavenie smeru Y pre loptu.
     * 
     */
    public void setSmerY() {
        if (this.smerY == 1) {
            this.smerY = -1;
        } else {
            this.smerY = 1;
        }
    }

    /**
     * Vráti pozíciu pravého dolného Y lopty.
     *
     */
    public int getPravyDolnyY() {
        return this.lopta.getPravyDolnyY();
    }
}