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
    private Patient patient;
    private SalleAttente salleAttente;

    @BeforeEach
    public void setUp() {
        patient = new Patient(1, "NomPatient", 12345, "PrenomPatient", "AdressePatient");
        salleAttente = new SalleAttente(1, "NomSalle", "LocalisationSalle", 10);
        refToSalleAttenteUrgence = new RefToSalleAttenteUrgence(patient, salleAttente);
    }

    @Test
    public void testGetSalleAttenteUrgence() {
        assertEquals(salleAttente, refToSalleAttenteUrgence.getSalleAttenteUrgence());
    }

    @Test
    public void testSetSalleAttenteUrgence() {
        SalleAttente nouvelleSalleAttente = new SalleAttente(2, "NouvelleSalle", "NouvelleLocalisation", 15);
        refToSalleAttenteUrgence.setSalleAttenteUrgence(nouvelleSalleAttente);
        assertEquals(nouvelleSalleAttente, refToSalleAttenteUrgence.getSalleAttenteUrgence());
    }

    @Test
    public void testUnset() {
        refToSalleAttenteUrgence.unset();
        assertNull(refToSalleAttenteUrgence.getSalleAttenteUrgence());
    }

    
}
