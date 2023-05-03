/**
 * Trieda ovládanie, s ktorou môže použíateľ pohybovať s objektamy.
 * 
 * @author Patrik Pavlík 
 * @version 1.57.22
 */
public class Ovladanie {
    private Hra hra;
    private Manazer m;

    /**
     * Vytvorí novú inštanciu hry s danými riadkami a stĺpcami a novú inštanciu triedy Manazer.
     * Manazer bude spravovať tento objekt a spustí sa hlavný loop hry s počtom kociek v hre.
     * 
     * @param riadky vyjadruje počet riadkov
     * @param stlpce vyjadruje počet stĺpcov
     */
    public Ovladanie(int riadky, int stlpce) {
        this.hra = new Hra(riadky, stlpce);
        this.m = new Manazer();
        this.m.spravujObjekt(this);
        this.hra.hlavnyLoop(riadky * stlpce);
    }

    /**
     * Posunie objekt vľavo.
     * Volá metódu ovladanie triedy Hra s argumentom false a posunie dosku vlavo.
     */
    public void posunVlavo() {
        this.hra.ovladanie(false);
    }

    /**
     * Posunie objekt vpravo.
     * Volá metódu ovladanie triedy Hra s argumentom true a posunie dosku vpravo.
     */
    public void posunVpravo() {
        this.hra.ovladanie(true);
    }
}