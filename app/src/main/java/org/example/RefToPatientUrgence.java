package org.example;

import java.util.ArrayList;
import java.util.List;

public class RefToPatientUrgence {
    private SalleAttente salleAttente; // Relation 1..1 avec SalleAttente
    private List<Patient> patients; // Relation 0..* avec Patient
    private boolean isSet;

    public RefToPatientUrgence(SalleAttente salleAttente) {
        this.salleAttente = salleAttente;
        this.patients = new ArrayList<>();
        this.isSet = false;
    }

    public SalleAttente getSalleAttente() {
        return salleAttente;
    }

    public List<Patient> getPatients() {
        return patients;
    }

    

     public void basicSet(Patient patient) {
        this.patients.add(patient);
    }

     public void basicUnset(Patient patient) {
        this.patients.remove(patient);
    }

    
    public boolean isSet() {
        return isSet;
    }

    public void SetPatient(Patient newPatient) {
    if (newPatient != null && !patients.contains(newPatient)) {
        if (isSet()) {
            unset();
        }

        if (newPatient.getRefToSalleAttenteUrgence().isSet()) {
            newPatient.getRefToSalleAttenteUrgence().unset() ;
        }
        basicSet(newPatient);
        newPatient.getRefToSalleAttenteUrgence().basicSet(salleAttente);
        isSet = true;
    }
}


    public void unset() {
        for (Patient patient : patients) {
            patient.getRefToSalleAttenteUrgence().unset();
        }
        patients.clear();
        isSet = false;
    }
}
