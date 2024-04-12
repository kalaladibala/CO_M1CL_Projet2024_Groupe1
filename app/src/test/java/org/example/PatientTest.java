package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PatientTest {

    @Test
    public void testConstructorAndGetters() {
        // Création d'un patient
        Patient patient = new Patient(123456789, "Doe", 123456, "John", "123 Main St");

        // Vérification des valeurs des attributs
        assertEquals(123456789, patient.getPers_id());
        assertEquals("Doe", patient.getNom());
        assertEquals(123456, patient.getNo_SecSoc_p());
        assertEquals("John", patient.getPrenom_p());
        assertEquals("123 Main St", patient.getAdresse_p());
    }

    @Test
    public void testSetters() {
        // Création d'un patient
        Patient patient = new Patient(0, "", 0, "", "");

        // Modification des attributs
        patient.setPers_id(987654321);
        patient.setNom("Smith");
        patient.setNo_SecSoc_p(654321);
        patient.setPrenom_p("Jane");
        patient.setAdresse_p("456 Elm St");

        // Vérification des nouvelles valeurs
        assertEquals(987654321, patient.getPers_id());
        assertEquals("Smith", patient.getNom());
        assertEquals(654321, patient.getNo_SecSoc_p());
        assertEquals("Jane", patient.getPrenom_p());
        assertEquals("456 Elm St", patient.getAdresse_p());
    }
}
