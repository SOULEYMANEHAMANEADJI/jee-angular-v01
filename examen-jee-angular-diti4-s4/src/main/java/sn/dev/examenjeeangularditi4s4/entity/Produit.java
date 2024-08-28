package sn.dev.examenjeeangularditi4s4.entity;

public class Produit {
    private int id;
    private String libelle;
    private int quantite;
    private Categorie categorie;
    private Marque marque;

    public Produit() {
    }

    public Produit(String libelle, int quantite, Categorie categorie, Marque marque) {
        this.libelle = libelle;
        this.quantite = quantite;
        this.categorie = categorie;
        this.marque = marque;
    }
    public Produit(int id, String libelle, int quantite, Categorie categorie, Marque marque) {
        this.id = id;
        this.libelle = libelle;
        this.quantite = quantite;
        this.categorie = categorie;
        this.marque = marque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                ", quantite=" + quantite +
                ", categorie=" + categorie +
                ", marque=" + marque +
                '}';
    }
}
