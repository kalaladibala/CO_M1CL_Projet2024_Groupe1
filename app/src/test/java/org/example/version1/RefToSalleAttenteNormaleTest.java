package org.example.version1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.example.version1.Patient;
import org.example.version1.SalleAttente;
import org.example.version1.RefToSalleAttenteNormale;
import org.example.version1.RefToSalleAttenteUrgence;


public class RefToSalleAttenteNormaleTest {
    private RefToSalleAttenteNormale refToSalleAttenteNormale;
    private Patient patient;
    private SalleAttente salleAttente;

    @BeforeEach
    public void setUp() {
        patient = new Patient(1, "NomPatient", 12345, "PrenomPatient", "AdressePatient");
        salleAttente = new SalleAttente(1, "NomSalle", "LocalisationSalle", 10);
        refToSalleAttenteNormale = new RefToSalleAttenteNormale(patient, salleAttente);
    }

    @Test
    public void testGetSalleAttenteNormale() {
        assertEquals(salleAttente, refToSalleAttenteNormale.get());
    }

     @Test
    public void testSetSalleAttente() {
        assertNull(refToSalleAttenteNormale.get(), "L'association doit être initialisée à null");

        refToSalleAttenteNormale.set(salleAttente);

        assertNotNull(refToSalleAttenteNormale.get(), "L'association doit être initialisée");
        assertEquals(salleAttente, refToSalleAttenteNormale.get(), "L'association doit être la salle d'attente spécifiée");
    }

    @Test
    public void testUnsetSalleAttente() {
        refToSalleAttenteNormale.set(salleAttente);

        assertNotNull(refToSalleAttenteNormale.get(), "L'association doit être initialisée");

        refToSalleAttenteNormale.unset();

        assertNull(refToSalleAttenteNormale.get(), "L'association doit être réinitialisée à null");
    }
}
