package sn.dev.examenjeeangularditi4s4.entity;

public class Marque {
    private int id;
    private String libelle;

    public Marque() {
    }

    public Marque(String libelle) {
        this.libelle = libelle;
    }
    public Marque(int id, String libelle) {
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
        return "Marque{" +
                "id=" + id +
                ", libelle='" + libelle + '\'' +
                '}';
    }
}
