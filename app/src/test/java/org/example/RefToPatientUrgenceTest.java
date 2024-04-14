import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.example.*;

public class RefToPatientUrgenceTest {

    @Test
    void testSetPatient() {
        SalleAttente salleAttente = new SalleAttente(1, "Salle d'attente", "Localisation", 10);
        Patient patient1 = new Patient(1, "John Doe", 123456789, "John", "Adresse");
        Patient patient2 = new Patient(2, "Jane Doe", 987654321, "Jane", "Adresse");

        RefToPatientUrgence ref = new RefToPatientUrgence(salleAttente);
        
        assertFalse(ref.isSet(), "L'association ne doit pas être initialisée");

        ref.SetPatient(patient1);
        
        assertTrue(ref.isSet(), "L'association doit être initialisée");
        assertEquals(1, ref.getPatients().size(), "Le nombre de patients dans la liste doit être 1");

        ref.SetPatient(patient2);
        
        assertTrue(ref.isSet(), "L'association doit être toujours initialisée");
        assertEquals(2, ref.getPatients().size(), "Le nombre de patients dans la liste doit être 2");
        assertTrue(ref.getPatients().contains(patient1), "La liste doit contenir le patient1");
        assertTrue(ref.getPatients().contains(patient2), "La liste doit contenir le patient2");
    }

    @Test
    void testUnset() {
        SalleAttente salleAttente = new SalleAttente(1, "Salle d'attente", "Localisation", 10);
        Patient patient1 = new Patient(1, "John Doe", 123456789, "John", "Adresse");
        Patient patient2 = new Patient(2, "Jane Doe", 987654321, "Jane", "Adresse");

        RefToPatientUrgence ref = new RefToPatientUrgence(salleAttente);

        ref.SetPatient(patient1);
        ref.SetPatient(patient2);

        assertTrue(ref.isSet(), "L'association doit être initialisée");
        assertEquals(2, ref.getPatients().size(), "Le nombre de patients dans la liste doit être 2");

        ref.unset();
        
        assertFalse(ref.isSet(), "L'association doit être réinitialisée");
        assertTrue(ref.getPatients().isEmpty(), "La liste des patients doit être vide");
    }
}
