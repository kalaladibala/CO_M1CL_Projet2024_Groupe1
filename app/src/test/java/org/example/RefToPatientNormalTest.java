import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    public void testSetPatient() {
        assertFalse(refToPatientNormal.isSet(), "L'association ne doit pas être initialisée");

        refToPatientNormal.SetPatient(patient);

        assertTrue(refToPatientNormal.isSet(), "L'association doit être initialisée");
        assertEquals(1, refToPatientNormal.getPatients().size(), "Le nombre de patients dans la liste doit être 1");
        assertTrue(refToPatientNormal.getPatients().contains(patient), "La liste doit contenir le patient ajouté");
    }

    @Test
    public void testUnset() {
        refToPatientNormal.SetPatient(patient);

        assertTrue(refToPatientNormal.isSet(), "L'association doit être initialisée");
        assertEquals(1, refToPatientNormal.getPatients().size(), "Le nombre de patients dans la liste doit être 1");

        refToPatientNormal.unset();

        assertFalse(refToPatientNormal.isSet(), "L'association doit être réinitialisée");
        assertTrue(refToPatientNormal.getPatients().isEmpty(), "La liste des patients doit être vide");
    }
}