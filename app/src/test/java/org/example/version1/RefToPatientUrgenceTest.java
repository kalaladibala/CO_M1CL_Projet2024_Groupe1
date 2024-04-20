package org.example.version1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.version1.Patient;
import org.example.version1.SalleAttente;
import org.example.version1.RefToSalleAttenteNormale;
import org.example.version1.RefToSalleAttenteUrgence;

public class RefToPatientUrgenceTest {
    private SalleAttente salleAttente;
    private Patient patient1;
    private Patient patient2;
    private RefToPatientUrgence refToPatientUrgence;

    @BeforeEach
    void setUp() {
        salleAttente = new SalleAttente(1, "Salle d'urgence", "Localisation", 10);
        patient1 = new Patient(1, "John", 12345, "Doe", "Adresse 1");
        patient2 = new Patient(2, "Jane", 67890, "Smith", "Adresse 2");
        refToPatientUrgence = new RefToPatientUrgence(salleAttente);
    }

    @Test
    void testLierPatient() {
        refToPatientUrgence.lierPatient(patient1);
        assertTrue(refToPatientUrgence.isSet());
        assertTrue(patient1.salleAttenteUrgence().isSet());
        assertEquals(1, refToPatientUrgence.get().size());
        assertTrue(refToPatientUrgence.get().contains(patient1));

        // Test d'ajout d'un patient déjà lié
        refToPatientUrgence.lierPatient(patient1);
        assertEquals(1, refToPatientUrgence.get().size()); // La taille ne doit pas changer

        // Test d'ajout d'un nouveau patient
        refToPatientUrgence.lierPatient(patient2);
        assertTrue(refToPatientUrgence.isSet());
        assertTrue(patient2.salleAttenteUrgence().isSet());
        assertEquals(2, refToPatientUrgence.get().size()); // ceci est la ligne 42
        assertTrue(refToPatientUrgence.get().contains(patient2));
    }

    @Test
    void testDelierPatient() {
        // Test de délier un patient non lié
        refToPatientUrgence.delierPatient();
        assertFalse(refToPatientUrgence.isSet());

        // Lier quelques patients
        refToPatientUrgence.lierPatient(patient1);
        refToPatientUrgence.lierPatient(patient2);
        assertTrue(refToPatientUrgence.isSet());
        assertEquals(2, refToPatientUrgence.get().size()); // ligne 56

        // Test de délier les patients
        refToPatientUrgence.delierPatient();
        assertFalse(refToPatientUrgence.isSet());
        assertFalse(patient1.salleAttenteUrgence().isSet());
        assertFalse(patient2.salleAttenteUrgence().isSet());
        assertTrue(refToPatientUrgence.get().isEmpty());
    }
}
