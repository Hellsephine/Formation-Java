package grossiste;

public interface Saison {
    public Periode getSaison();
    public void setSaison(Periode saison);

    public int getRemise();
    public void setRemise(int remise);
    
    public int getPrix();
    public void setPrix(int prix); 
}
