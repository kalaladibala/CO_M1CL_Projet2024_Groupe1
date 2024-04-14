package org.example;

public class RefToSalleAttenteUrgence {
    private Patient patient;
    private SalleAttente salleAttenteUrgence;
    private boolean isSet;

    public RefToSalleAttenteUrgence(Patient patient, SalleAttente salleAttenteUrgence) {
        this.patient = patient;
        this.salleAttenteUrgence = salleAttenteUrgence;
        this.isSet = true;
    }

    public SalleAttente getSalleAttenteUrgence() {
        return salleAttenteUrgence;
    }

    public void basicUnset()
    {
        this.salleAttenteUrgence=null;
    }

    public void setSalleAttenteUrgence(SalleAttente salleAttenteUrgence) {
        if (isSet()) {
            unset();
        }
        
        if (salleAttenteUrgence.getRefToPatientUrgence().isSet()) {
            salleAttenteUrgence.getRefToPatientUrgence().unset();
        }


        basicSet(salleAttenteUrgence);
        salleAttenteUrgence.getRefToPatientUrgence().basicSet(patient);
        isSet = true;
    }

    public boolean isSet() {
        return isSet;
    }

    public void unset() {
        if (salleAttenteUrgence != null) {
            salleAttenteUrgence.getRefToPatientUrgence().unset();
            this.basicUnset();
        }
        isSet = false;
    }

    public void basicSet(SalleAttente salle)
    {
        this.salleAttenteUrgence = salle;
    }
}