package grossiste;

public class ProduitFugace extends ProduitPerissable implements Saison {

    protected int remise;
    protected Periode saison = Periode.aucune;


    public ProduitFugace(String code){
        super(code);
    }

    @Override
    public Periode getSaison() {
        return saison;
    }

    @Override
    public void setSaison(Periode saison) {
        this.saison = saison;
    }

    @Override
    public int getRemise() {  
        return 0;
    }

    @Override
    public void setRemise(int remise) {
        this.remise = remise;  
    }
    
}
