package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
        assertEquals(salleAttente, refToSalleAttenteNormale.getSalleAttenteNormale());
    }

    @Test
    public void testSetSalleAttenteNormale() {
        SalleAttente nouvelleSalleAttente = new SalleAttente(2, "NouvelleSalle", "NouvelleLocalisation", 15);
        refToSalleAttenteNormale.setSalleAttenteNormale(nouvelleSalleAttente);
        assertEquals(nouvelleSalleAttente, refToSalleAttenteNormale.getSalleAttenteNormale());
    }

    @Test
    public void testUnset() {
        refToSalleAttenteNormale.unset();
        assertNull(refToSalleAttenteNormale.getSalleAttenteNormale());
    }

    
}