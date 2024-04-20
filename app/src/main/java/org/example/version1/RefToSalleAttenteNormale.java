package org.example.version1;

public class RefToSalleAttenteNormale {
     Patient patient;
     SalleAttente salleAttenteNormale;

    public RefToSalleAttenteNormale(Patient patient) {this.patient = patient; }

    public SalleAttente get() { return salleAttenteNormale; }

    public void set(SalleAttente salleAttenteNormale) {

        if (salleAttenteNormale == this.salleAttenteNormale)
            return ; 

        if (salleAttenteNormale == null || isSet()) 
            this.unset();
              
        if (salleAttenteNormale.patientNormal().isSet()) 
            salleAttenteNormale.patientNormal().delierPatient();
        
        this.basicSet(salleAttenteNormale);
        salleAttenteNormale.patientNormal().basicSet(patient);
    }

    public void basicSet(SalleAttente salle){ this.salleAttenteNormale = salle; }

    public void unset() {
        if (!isSet())
            return;
            salleAttenteNormale.patientNormal().basicUnset();
            this.basicUnset();
    }

    public void basicUnset() { this.salleAttenteNormale=null; }

    public boolean isSet() { return this.salleAttenteNormale != null; }
}
