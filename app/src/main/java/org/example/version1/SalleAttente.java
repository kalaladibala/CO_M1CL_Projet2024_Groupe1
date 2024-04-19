package org.example.version1;

public class SalleAttente {
    private int no_s;
    private String nom_s;
    private String localisation_s;
    private int nb_Places_s;
    //final RefToPatientUrgence refToPatientUrgence;
    //final RefToPatientNormal refToPatientNormal;
    final RefToPatientNormal patientNormal = new RefToPatientNormal(this);
    final RefToPatientUrgence patientUrgence = new RefToPatientUrgence(this);

    public RefToPatientNormal patientNormal() {
		return this.patientNormal;
	}

    public RefToPatientUrgence patientUrgence() {
		return this.patientUrgence;
	}

    public SalleAttente(int no_s, String nom_s, String localisation_s, int nb_Places_s) {
        this.no_s = no_s;
        this.nom_s = nom_s;
        this.localisation_s = localisation_s;
        this.nb_Places_s = nb_Places_s;
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

    public int getNb_Places_s() {
        return nb_Places_s;
    }

    public void setNb_Places_s(int nb_Places_s) {
        this.nb_Places_s = nb_Places_s;
    }
    /*

    public RefToPatientUrgence getRefToPatientUrgence() {
        return refToPatientUrgence;
    }

    public void setRefToPatientUrgence(RefToPatientUrgence refToPatientUrgence) {
        this.refToPatientUrgence = refToPatientUrgence;
    }

     public RefToPatientNormal getRefToPatientNormal() {
        return refToPatientNormal;
    }

    public void setRefToPatientNormal(RefToPatientNormal refToPatientNormal) {
        this.refToPatientNormal = refToPatientNormal;
    }*/

    
    

    
}
