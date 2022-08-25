package projetproduits;

public class ProduitSaisonnier extends Produit {
    protected String saison = "";
    protected int remise = 0;
    
    public ProduitSaisonnier(String code) {
        super(code);
    }

    public String getSaison() {
        return saison;
    }

    public void setSaison(String saison) {
        this.saison = saison;
    }

    public int getRemise() {
        return remise;
    }

    public void setRemise(int remise) {
        this.remise = remise;
    }
    
}
