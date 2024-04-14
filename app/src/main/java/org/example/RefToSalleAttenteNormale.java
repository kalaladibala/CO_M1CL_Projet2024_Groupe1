package org.example;

public class RefToSalleAttenteNormale {
    private Patient patient;
    private SalleAttente salleAttenteNormale;
    private boolean isSet;

    public RefToSalleAttenteNormale(Patient patient, SalleAttente salleAttenteNormale) {
        this.patient = patient;
        this.salleAttenteNormale = salleAttenteNormale;
        this.isSet = true;
    }

    public SalleAttente getSalleAttenteNormale() {
        return salleAttenteNormale;
    }

    public void basicUnset()
    {
        this.salleAttenteNormale=null;
    }

    public void setSalleAttenteNormale(SalleAttente salleAttenteNormale) {
        if (isSet()) {
            unset();
        }
        
        if (salleAttenteNormale.getRefToPatientNormal().isSet()) {
            salleAttenteNormale.getRefToPatientNormal().unset();
        }


        basicSet(salleAttenteNormale);
        //this.salleAttenteNormale = salleAttenteNormale;
        salleAttenteNormale.getRefToPatientNormal().basicSet(patient);
        isSet = true;
    }

    public boolean isSet() {
        return isSet;
    }

    public void unset() {
        if (salleAttenteNormale != null) {
            salleAttenteNormale.getRefToPatientNormal().unset();
            this.basicUnset();
        }
        isSet = false;
    }

    public void basicSet(SalleAttente salle)
    {
        this.salleAttenteNormale = salle;
    }
}
