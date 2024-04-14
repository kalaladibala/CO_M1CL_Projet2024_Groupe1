package org.example;

public class Patient extends Personne {
    private int no_SecSoc_p;
    private String prenom_p;
    private String adresse_p;
    private RefToSalleAttenteNormale refToSalleAttenteNormale;

    public Patient(int pers_id, String nom, int no_SecSoc_p, String prenom_p, String adresse_p) {
        super(pers_id, nom);
        this.no_SecSoc_p = no_SecSoc_p;
        this.prenom_p = prenom_p;
        this.adresse_p = adresse_p;
    }

    public int getNo_SecSoc_p() {
        return no_SecSoc_p;
    }

    public void setNo_SecSoc_p(int no_SecSoc_p) {
        this.no_SecSoc_p = no_SecSoc_p;
    }

    public String getPrenom_p() {
        return prenom_p;
    }

    public void setPrenom_p(String prenom_p) {
        this.prenom_p = prenom_p;
    }

    public String getAdresse_p() {
        return adresse_p;
    }

    public void setAdresse_p(String adresse_p) {
        this.adresse_p = adresse_p;
    }

    public RefToSalleAttenteNormale getRefToSalleAttenteNormale() {
        return refToSalleAttenteNormale;
    }

    public void setRefToSalleAttenteNormale(RefToSalleAttenteNormale refToSalleAttenteNormale) {
        this.refToSalleAttenteNormale = refToSalleAttenteNormale;
    }

}
