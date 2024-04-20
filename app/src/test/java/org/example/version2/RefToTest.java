package org.example.version2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Function;
import org.junit.jupiter.api.Test;

import org.example.version2.Patient;
import org.example.version2.SalleAttente;
import org.example.version2.RefTo;

public class RefToTest {

    @Test
    public void testSetTargetAndGetTarget() {
        // Création d'un objet propriétaire et d'un objet cible
        SalleAttente salleAttente = new SalleAttente(1, "Salle A", "Bâtiment principal", 50);
        Patient patient = new Patient(123456789, "Doe", 123456, "John", "123 Main St");

        // Création d'une instance RefTo
        RefTo<Patient, SalleAttente> refTo = new RefTo<>(salleAttente, Patient::salleAttente);

        // Assignation de la cible
        refTo.setTarget(patient);

        // Vérification que la cible a été correctement assignée
        assertEquals(patient, refTo.getTarget());
    }

    @Test
    public void testUnset() {
        // Création d'un objet propriétaire et d'un objet cible
        SalleAttente salleAttente = new SalleAttente(1, "Salle A", "Bâtiment principal", 50);
        Patient patient = new Patient(123456789, "Doe", 123456, "John", "123 Main St");

        // Création d'une instance RefTo
        RefTo<Patient, SalleAttente> refTo = new RefTo<>(salleAttente, Patient::salleAttente);

        // Assignation de la cible
        refTo.setTarget(patient);

        // Unset de la cible
        refTo.unset();

        // Vérification que la cible a été correctement unset
        assertNull(refTo.getTarget());
        assertFalse(patient.salleAttente().isSet());
    }

    @Test
    public void testIsSet() {
        // Création d'un objet propriétaire
        SalleAttente salleAttente = new SalleAttente(1, "Salle A", "Bâtiment principal", 50);

        // Création d'une instance RefTo
        RefTo<Patient, SalleAttente> refTo = new RefTo<>(salleAttente, Patient::salleAttente);

        // Vérification qu'au départ la cible n'est pas set
        assertFalse(refTo.isSet());

        // Assignation de la cible
        refTo.setTarget(new Patient(123456789, "Doe", 123456, "John", "123 Main St"));

        // Vérification que la cible est set
        assertTrue(refTo.isSet());

        // Unset de la cible
        refTo.unset();

        // Vérification que la cible n'est plus set
        assertFalse(refTo.isSet());
    }
}
