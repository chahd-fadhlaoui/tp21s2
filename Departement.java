package tp21s2;

import java.util.HashSet;
import java.util.Set;
import java.util.Comparator;

public class Departement {
    private int idDep;
    private Set<Employe> lEmployes;

    public Departement(int idDep) {
        this.idDep = idDep;
        this.lEmployes = new HashSet<>();
    }

    public int getIdDep() {
        return idDep;
    }
    public int getEmployeCount() {
        return lEmployes.size();
    }

    public void setIdDep(int idDep) {
        this.idDep = idDep;
    }

    public void ajoutEmploye(Employe e) {
        if (e != null && e.getCin() > 0) {
            lEmployes.add(e);
            e.setDepartement(this);
        }
    }

    public void retirerEmploye(Employe e) {
        if (lEmployes.contains(e)) {
            lEmployes.remove(e);
            e.setDepartement(null);
        }
    }

    public void afficheDep() {
        System.out.println("Département ID: " + idDep);
        for (Employe e : lEmployes) {
            System.out.println("CIN: " + e.getCin() + ", Nom: " + e.getNom() + ", Salaire: " + e.getSalaire());
        }
    }

    public boolean existeE(int cin) {
        for (Employe e : lEmployes) {
            if (e.getCin() == cin) {
                return true;
            }
        }
        return false;
    }

    public Employe getEmpSalMax() {
        return lEmployes.stream().max(Comparator.comparingDouble(Employe::getSalaire)).orElse(null);
    }
}
