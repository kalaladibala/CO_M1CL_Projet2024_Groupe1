public class SalleAttente {
    private int no_s;
    private String nom_s;
    private String localisation_s;
    private nb_Places_s;

    public SalleAttente(int no_s, String nom_s, String localisation_s) {
        this.no_s = no_s;
        this.nom_s = nom_s;
        this.localisation_s = localisation_s;
    }

    public int getNo_s() {
        return no_s;
    }

    public void setNo_s(int no_s) {
        this.no_s = no_s;
    }

    public String getNom_s() {
        return nom_s;
    }

    public void setNom_s(String nom_s) {
        this.nom_s = nom_s;
    }

    public String getLocalisation_s() {
        return localisation_s;
    }

    public void setLocalisation_s(String localisation_s) {
        this.localisation_s = localisation_s;
    }
}