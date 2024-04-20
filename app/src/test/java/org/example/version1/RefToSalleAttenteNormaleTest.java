package org.example.version1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.version1.Patient;
import org.example.version1.SalleAttente;
import org.example.version1.RefToSalleAttenteNormale;
import org.example.version1.RefToSalleAttenteUrgence;

public class RefToSalleAttenteNormaleTest {
    private SalleAttente salleAttente;
    private Patient patient;
    private RefToSalleAttenteNormale refToSalleAttenteNormale;

    @BeforeEach
    void setUp() {
        salleAttente = new SalleAttente(1, "Salle normale", "Localisation", 10);
        patient = new Patient(1, "John", 12345, "Doe", "Adresse 1");
        refToSalleAttenteNormale = new RefToSalleAttenteNormale(patient);
    }

    @Test
    void testSet() {
        refToSalleAttenteNormale.set(salleAttente);
        assertTrue(refToSalleAttenteNormale.isSet());
        assertEquals(salleAttente, refToSalleAttenteNormale.get());
        assertTrue(salleAttente.patientNormal().isSet());
        assertEquals(1, salleAttente.patientNormal().get().size());
        assertTrue(salleAttente.patientNormal().get().contains(patient));

        // Test de réaffectation à la même salle d'attente
        refToSalleAttenteNormale.set(salleAttente);
        assertTrue(refToSalleAttenteNormale.isSet());
        assertEquals(salleAttente, refToSalleAttenteNormale.get());
        assertTrue(salleAttente.patientNormal().isSet());
        assertEquals(1, salleAttente.patientNormal().get().size());
        assertTrue(salleAttente.patientNormal().get().contains(patient));

        // Test de désaffectation
        refToSalleAttenteNormale.unset();
        assertFalse(refToSalleAttenteNormale.isSet());
        assertNull(refToSalleAttenteNormale.get());
        assertFalse(salleAttente.patientNormal().isSet());
        assertTrue(salleAttente.patientNormal().get().isEmpty());
    }

    @Test
    void testUnset() {
        // Test de unset quand non défini
        refToSalleAttenteNormale.unset();
        assertFalse(refToSalleAttenteNormale.isSet());

        // Liaison avec une salle d'attente normale
        refToSalleAttenteNormale.set(salleAttente);
        assertTrue(refToSalleAttenteNormale.isSet());

        // Désaffectation
        refToSalleAttenteNormale.unset();
        assertFalse(refToSalleAttenteNormale.isSet());
        assertNull(refToSalleAttenteNormale.get());
        assertFalse(salleAttente.patientNormal().isSet());
        assertTrue(salleAttente.patientNormal().get().isEmpty());
    }
}
