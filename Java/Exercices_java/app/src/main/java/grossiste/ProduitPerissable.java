package grossiste;

import java.time.LocalDate;

public class ProduitPerissable extends Produit {
    protected int conservation;
    protected LocalDate fabrication;

    public ProduitPerissable(String code){
        super(code);
        this.conservation = 0;
        this.fabrication = LocalDate.now();
    }

    public int getConservation() {
        return conservation;
    }

    public void setConservation(int conservation) {
        this.conservation = conservation;
    }

    public LocalDate getFabrication() {
        return fabrication;
    }

    public void setFabrication(LocalDate fabrication) {
        this.fabrication = fabrication;
    }

}
