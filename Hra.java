import javax.swing.JOptionPane;
/**
 * Trieda hra, ktorá vytvorí hru.
 * 
 * @author Patrik Pavlík 
 * @version 1.57.22
 */
public class Hra {
    private Doska[][] dosky;
    private Lopta lopta;
    private Hrac hrac;
    /**
     * Vygenerovanie dosky, lopty a kociek.
     * @param riadky určuje kolko riadkov dosiek sa má vytvoriť na plátne
     * @param stlpce určuje kolko stĺpcov dosiek sa má vytvoriť na plátne
     */
    public Hra(int riadky, int stlpce) {
        this.dosky = new Doska[riadky][stlpce];
        this.lopta = new Lopta();
        this.hrac = new Hrac();

        for (int i = 0; i < riadky; i++) {
            for (int j = 0; j < stlpce; j++) {
                this.dosky[i][j] = new Doska(((90 * j) + 5 * j) + 5 , (30 * i) + 5 * i, 90, 30);
            }
        }

    }

    /**
     * Vytvorenie cyklusu pre hru.
     * @param pocet urcuje pocet kociek na plátne
     */
    public void hlavnyLoop(int pocet) {
        int pocetKociek = pocet;
        this.lopta.pohyb();

        if (this.lopta.vratLoptu().prekrivajuSa(this.hrac.getDoska())) {
            this.lopta.setSmerY();
        } else if (this.lopta.getPravyDolnyY() > 500) {
            Object[] moznosti = {"Vzdávam sa"};
            JOptionPane.showOptionDialog(null, "PREHRAL SI 😟 \n", "Brick Breaker - PREHRA\n", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE, null, moznosti, moznosti[0]);
            System.exit(0);
        }

        for (int i = 0; i < this.dosky.length; i++) {
            for (int j = 0; j < this.dosky[i].length; j++) {
                if (this.dosky[i][j].isVyditelne() && this.lopta.vratLoptu().prekrivajuSa(this.dosky[i][j])) {
                    this.dosky[i][j].skry();
                    pocetKociek--;
                    this.lopta.setSmerY();
                }
            }
        }

        if (pocetKociek <= 0) {
            Object[] moznosti = {"Super"};
            JOptionPane.showOptionDialog(null, "VYHRAL SI 😃 \n", "Brick Breaker - VÝHRA\n", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, moznosti, moznosti[0]);
            System.exit(0);
        }

        this.hlavnyLoop(pocetKociek);
    }

    /**
     * Ovladanie smeru hraca(dosky).
     * @param smer určuje, či sa má doska pohybovať vľavo alebo vpravo na základe .
     */
    public void ovladanie(boolean smer) {
        this.hrac.pohyb(smer);
    }
}