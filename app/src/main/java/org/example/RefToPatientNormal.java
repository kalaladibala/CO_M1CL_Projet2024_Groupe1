package org.example;

import java.util.ArrayList;
import java.util.List;

public class RefToPatientNormal {
    private SalleAttente salleAttente; // Relation 1..1 avec SalleAttente
    private List<Patient> patients; // Relation 0..* avec Patient
    private boolean isSet;

    public RefToPatientNormal(SalleAttente salleAttente) {
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

        if (newPatient.getRefToSalleAttenteNormale().isSet()) {
            newPatient.getRefToSalleAttenteNormale().unset() ;
        }
        basicSet(newPatient);
        newPatient.getRefToSalleAttenteNormale().basicSet(salleAttente);
        isSet = true;
    }
}


    public void unset() {
        for (Patient patient : patients) {
            patient.getRefToSalleAttenteNormale().unset();
        }
        patients.clear();
        isSet = false;
    }
}