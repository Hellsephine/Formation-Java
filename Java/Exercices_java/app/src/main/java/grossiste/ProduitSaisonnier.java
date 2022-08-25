package grossiste;

public class ProduitSaisonnier extends Produit {
    protected Periode saison;
    protected int remise;

    public ProduitSaisonnier(String code){
        super(code);
        this.saison = Periode.aucune;
        this.remise = 0;
    }
    
    public Periode getSaison() {
        return saison;
    }

    public void setSaison(Periode saison) {
        this.saison = saison;
    }

    public int getRemise() {
        return remise;
    }

    public void setRemise(int remise) {
        this.remise = remise;
    }

    @Override
    public int getPrix(){
        return super.getPrix()-remise;
    }
}
