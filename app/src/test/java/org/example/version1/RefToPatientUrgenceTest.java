package org.example.version1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.version1.Patient;
import org.example.version1.SalleAttente;
import org.example.version1.RefToSalleAttenteNormale;
import org.example.version1.RefToSalleAttenteUrgence;


public class RefToSalleAttenteUrgenceTest {
    private RefToSalleAttenteUrgence refToSalleAttenteUrgence;
    private SalleAttente salleAttente;
    private Patient patient;

    @BeforeEach
    public void setUp() {
        salleAttente = new SalleAttente(1, "Salle d'attente", "Localisation", 10);
        patient = new Patient(1, "John Doe", 123456789, "John", "Adresse");
        refToSalleAttenteUrgence = new RefToSalleAttenteUrgence(patient);
    }

    @Test
    public void testSetSalleAttente() {
        assertNull(refToSalleAttenteUrgence.get(), "L'association doit être initialisée à null");

        refToSalleAttenteUrgence.set(salleAttente);

        assertNotNull(refToSalleAttenteUrgence.get(), "L'association doit être initialisée");
        assertEquals(salleAttente, refToSalleAttenteUrgence.get(), "L'association doit être la salle d'attente spécifiée");
    }

    @Test
    public void testUnsetSalleAttente() {
        refToSalleAttenteUrgence.set(salleAttente);

        assertNotNull(refToSalleAttenteUrgence.get(), "L'association doit être initialisée");

        refToSalleAttenteUrgence.unset();

        assertNull(refToSalleAttenteUrgence.get(), "L'association doit être réinitialisée à null");
    }
}
