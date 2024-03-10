package tp21s2;

public class Employe {
    private int cin;
    private String nom;
    private double salaire;
    private Departement departement;

    public Employe(int cin, String nom, double salaire) {
        this.cin = cin;
        this.nom = nom;
        this.salaire = salaire;
    }

    public int getCin() {
        return cin;
    }

    public String getNom() {
        return nom;
    }

    public double getSalaire() {
        return salaire;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
}

