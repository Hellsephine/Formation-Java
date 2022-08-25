package grossiste;

public class Produit {

    // attribut
    protected String code;
    protected Denomination denomination;
    protected int prix;

    // Constructeur
    public Produit(String code){
        this.code = code;
        denomination = new Denomination(); // initialisation de la variable d'instace de type Denomination
    }
    // affiche le libelle avec les variable de la class denomination
    public String afficheLibelle(){
        return denomination.getLibelleCourt()+" "+denomination.getLibelleLong();
    }
    // modification de la variable libelle de la class denomination
    public void modifLibelle(String libelleCourt,String libelleLong){
        denomination.setLibelleCourt(libelleCourt);
        denomination.setLibelleLong(libelleLong);
    }

    //Getter & Setter
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public void setDenomination(Denomination denomination) {
        this.denomination = denomination;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
