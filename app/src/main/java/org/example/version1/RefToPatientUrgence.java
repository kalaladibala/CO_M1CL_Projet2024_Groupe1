package org.example.version1;

import java.util.ArrayList;
import java.util.List;

public class RefToPatientUrgence {
    SalleAttente salleAttente; // Relation 1..1 avec SalleAttente
    List<Patient> patients; // Relation 0..* avec Patient

    public RefToPatientUrgence(SalleAttente salleAttente) {
        this.salleAttente = salleAttente;
        this.patients = new ArrayList<>();
    }

    public List<Patient> get() { return patients; }

    public void lierPatient(Patient newPatient) {
        if (patients.contains(newPatient))
            return;

        if (newPatient == null && isSet())
            this.delierPatient();

        if (newPatient.salleAttenteUrgence().isSet())
            newPatient.salleAttenteUrgence().unset();

        this.basicSet(newPatient);
        newPatient.salleAttenteUrgence().basicSet(salleAttente);
    }

    public void basicSet(Patient patient) {
        this.patients.add(patient);
    }

    public void basicUnset() {
        this.patients.clear();
    }

    public boolean isSet() {
        return !this.patients.isEmpty();
    }

    public void  delierPatient() {
        if (!isSet())
            return;

        for (Patient patient : patients) {
            patient.salleAttenteUrgence().unset();
        }
        this.basicUnset();
    }
}
