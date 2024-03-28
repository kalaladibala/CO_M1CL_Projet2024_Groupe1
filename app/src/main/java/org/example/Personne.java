public  class Personne {
    private int pers_id;
    private String nom;

    public Personne(int pers_id, String nom) {
        this.pers_id = pers_id;
        this.nom = nom;
    }

    public int getPers_id() {
        return pers_id;
    }

    public void setPers_id(int pers_id) {
        this.pers_id = pers_id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}