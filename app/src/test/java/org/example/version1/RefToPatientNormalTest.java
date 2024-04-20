package org.example.version1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RefToPatientNormalTest {
    private SalleAttente salleAttente;
    private Patient patient1;
    private Patient patient2;
    private RefToPatientNormal refToPatientNormal;

    @BeforeEach
    void setUp() {
        salleAttente = new SalleAttente(1, "Salle normale", "Localisation", 10);
        patient1 = new Patient(1, "John", 12345, "Doe", "Adresse 1");
        patient2 = new Patient(2, "Jane", 67890, "Smith", "Adresse 2");
        refToPatientNormal = new RefToPatientNormal(salleAttente);
    }

    @Test
    void testLierPatient() {
        refToPatientNormal.lierPatient(patient1);
        assertTrue(refToPatientNormal.isSet());
        assertTrue(patient1.salleAttenteNormale().isSet());
        assertEquals(1, refToPatientNormal.get().size());
        assertTrue(refToPatientNormal.get().contains(patient1));

        // Test d'ajout d'un patient déjà lié
        refToPatientNormal.lierPatient(patient1);
        assertEquals(1, refToPatientNormal.get().size()); // La taille ne doit pas changer

        // Test d'ajout d'un nouveau patient
        refToPatientNormal.lierPatient(patient2);
        assertTrue(refToPatientNormal.isSet());
        assertTrue(patient2.salleAttenteNormale().isSet());
        assertEquals(2, refToPatientNormal.get().size());
        assertTrue(refToPatientNormal.get().contains(patient2));
    }

    @Test
    void testDelierPatient() {
        // Test de délier un patient non lié
        refToPatientNormal.delierPatient();
        assertFalse(refToPatientNormal.isSet());

        // Lier quelques patients
        refToPatientNormal.lierPatient(patient1);
        refToPatientNormal.lierPatient(patient2);
        assertTrue(refToPatientNormal.isSet());
        assertEquals(2, refToPatientNormal.get().size());

        // Test de délier les patients
        refToPatientNormal.delierPatient();
        assertFalse(refToPatientNormal.isSet());
        assertFalse(patient1.salleAttenteNormale().isSet());
        assertFalse(patient2.salleAttenteNormale().isSet());
        assertTrue(refToPatientNormal.get().isEmpty());
    }
}
