package org.example.version1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.version1.Patient;
import org.example.version1.SalleAttente;
import org.example.version1.RefToSalleAttenteNormale;
import org.example.version1.RefToSalleAttenteUrgence;


public class RefToPatientNormalTest {
    private RefToPatientNormal refToPatientNormal;
    private SalleAttente salleAttente;
    private Patient patient;

    @BeforeEach
    public void setUp() {
        salleAttente = new SalleAttente(1, "Salle d'attente", "Localisation", 10);
        patient = new Patient(1, "John Doe", 123456789, "John", "Adresse");
        refToPatientNormal = new RefToPatientNormal(salleAttente);
    }

    @Test
    public void testLierPatient() {
        assertFalse(refToPatientNormal.isSet(), "L'association ne doit pas être initialisée");

        refToPatientNormal.lierPatient(patient);

        assertTrue(refToPatientNormal.isSet(), "L'association doit être initialisée");
        assertEquals(1, refToPatientNormal.get().size(), "Le nombre de patients dans la liste doit être 1");
        assertTrue(refToPatientNormal.get().contains(patient), "La liste doit contenir le patient ajouté");
    }

    @Test
    public void testLierPatient() {
        assertFalse(refToPatientNormal.isSet(), "L'association ne doit pas être initialisée");

        refToPatientNormal.lierPatient(patient);

        assertTrue(refToPatientNormal.isSet(), "L'association doit être initialisée");
        assertEquals(1, refToPatientNormal.get().size(), "Le nombre de patients dans la liste doit être 1");
        assertTrue(refToPatientNormal.get().contains(patient), "La liste doit contenir le patient ajouté");
    }
}