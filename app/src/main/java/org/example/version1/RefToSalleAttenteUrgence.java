package org.example.version1;

public class RefToSalleAttenteUrgence {
    private Patient patient;
    private SalleAttente salleAttenteUrgence;

    public RefToSalleAttenteUrgence(Patient patient) {
        this.patient = patient;
    }

    public SalleAttente get() {
        return salleAttenteUrgence;
    }

    public void set(SalleAttente salleAttenteUrgence) {

        if (salleAttenteUrgence == this.salleAttenteUrgence)
            return ; 

        if (salleAttenteUrgence == null || isSet()) 
            this.unset();
              
        if (salleAttenteUrgence.patientUrgence().isSet()) 
            salleAttenteUrgence.patientUrgence().delierPatient();
        
        this.basicSet(salleAttenteUrgence);
        salleAttenteUrgence.patientUrgence().basicSet(patient);
    }

    public void basicSet(SalleAttente salle){this.salleAttenteUrgence = salle;}

    public void unset() {
        if (!isSet())
            return;
        salleAttenteUrgence.patientUrgence().basicUnset();
        this.basicUnset();
    }

    public void basicUnset() {this.salleAttenteUrgence=null;}

    public boolean isSet() {return this.salleAttenteUrgence != null; }
}