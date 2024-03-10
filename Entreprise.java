package tp21s2;

import java.util.HashMap;
import java.util.Map;

public class Entreprise  implements Comparator{
    private String nomEntreprise;
    private HashMap<Integer, Departement> listeDeps;

    public Entreprise(String nomEntreprise) {
        this.nomEntreprise = nomEntreprise;
        this.listeDeps = new HashMap<>();
    }

    public void ajoutDep(Departement d) {
        if (d != null) {
            listeDeps.put(d.getIdDep(), d);
        }
    }

    public void retirerDep(Departement d) {
        if (d != null && listeDeps.containsKey(d.getIdDep())) {
            listeDeps.remove(d.getIdDep());
        }
    }

    public void afficheE() {
        System.out.println("Entreprise: " + nomEntreprise);
        for (Map.Entry<Integer, Departement> entry : listeDeps.entrySet()) {
            System.out.println("Département ID: " + entry.getKey());
            entry.getValue().afficheDep();
        }
    }

    public void updateDep(Employe e, int idDep) {
        if (e != null && listeDeps.containsKey(idDep)) {
            Departement nouveauDep = listeDeps.get(idDep);
            if (e.getDepartement() != null) {
                e.getDepartement().retirerEmploye(e);
            }
            nouveauDep.ajoutEmploye(e);
        }
    }

    public boolean existeD(Departement d) {
        return d != null && listeDeps.containsKey(d.getIdDep());
    }

    public void depMinCapacity() {
        Departement minDep = listeDeps.values().stream()
                                .min(Comparator.comparingInt(Departement::getEmployeCount))
                                .orElse(null);

        if (minDep != null) {
            System.out.println("Département avec le moins d'employés: ID " + minDep.getIdDep());
            minDep.afficheDep();
        }
    }

}

