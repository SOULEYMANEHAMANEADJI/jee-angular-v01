package sn.dev.examenjeeangularditi4s4.entity;

public class Categorie {
    private int id;
    private String libelle;

    public Categorie() {
    }

    public Categorie(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
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

    @Override
    public String toString() {
        return "Categorie{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
