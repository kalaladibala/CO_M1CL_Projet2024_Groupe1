package org.example.version1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.version1.Patient;
import org.example.version1.SalleAttente;
import org.example.version1.RefToSalleAttenteNormale;
import org.example.version1.RefToSalleAttenteUrgence;

public class RefToSalleAttenteUrgenceTest {
    private SalleAttente salleAttente;
    private Patient patient;
    private RefToSalleAttenteUrgence refToSalleAttenteUrgence;

    @BeforeEach
    void setUp() {
        salleAttente = new SalleAttente(1, "Salle urgence", "Localisation", 10);
        patient = new Patient(1, "John", 12345, "Doe", "Adresse 1");
        refToSalleAttenteUrgence = new RefToSalleAttenteUrgence(patient);
    }

    @Test
    void testSet() {
        refToSalleAttenteUrgence.set(salleAttente);
        assertTrue(refToSalleAttenteUrgence.isSet());
        assertEquals(salleAttente, refToSalleAttenteUrgence.get());
        assertTrue(salleAttente.patientUrgence().isSet());
        assertEquals(1, salleAttente.patientUrgence().get().size());
        assertTrue(salleAttente.patientUrgence().get().contains(patient));

        // Test de réaffectation à la même salle d'attente
        refToSalleAttenteUrgence.set(salleAttente);
        assertTrue(refToSalleAttenteUrgence.isSet());
        assertEquals(salleAttente, refToSalleAttenteUrgence.get());
        assertTrue(salleAttente.patientUrgence().isSet());
        assertEquals(1, salleAttente.patientUrgence().get().size());
        assertTrue(salleAttente.patientUrgence().get().contains(patient));

        // Test de désaffectation
        refToSalleAttenteUrgence.unset();
        assertFalse(refToSalleAttenteUrgence.isSet());
        assertNull(refToSalleAttenteUrgence.get());
        assertFalse(salleAttente.patientUrgence().isSet());
        assertTrue(salleAttente.patientUrgence().get().isEmpty());
    }

    @Test
    void testUnset() {
        // Test de unset quand non défini
        refToSalleAttenteUrgence.unset();
        assertFalse(refToSalleAttenteUrgence.isSet());

        // Liaison avec une salle d'attente urgence
        refToSalleAttenteUrgence.set(salleAttente);
        assertTrue(refToSalleAttenteUrgence.isSet());

        // Désaffectation
        refToSalleAttenteUrgence.unset();
        assertFalse(refToSalleAttenteUrgence.isSet());
        assertNull(refToSalleAttenteUrgence.get());
        assertFalse(salleAttente.patientUrgence().isSet());
        assertTrue(salleAttente.patientUrgence().get().isEmpty());
    }
}
