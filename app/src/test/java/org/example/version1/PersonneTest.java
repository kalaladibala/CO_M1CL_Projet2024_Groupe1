package org.example.version1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.example.version1.Personne;



public class PersonneTest {

    @Test
    public void testConstructorAndGetters() {
        // Création d'une personne
        Personne personne = new Personne(123456789, "Doe");

        // Vérification des valeurs des attributs
        assertEquals(123456789, personne.getPers_id());
        assertEquals("Doe", personne.getNom());
    }

    @Test
    public void testSetters() {
        // Création d'une personne
        Personne personne = new Personne(0, "");

        // Modification des attributs
        personne.setPers_id(987654321);
        personne.setNom("Smith");

        // Vérification des nouvelles valeurs
        assertEquals(987654321, personne.getPers_id());
        assertEquals("Smith", personne.getNom());
    }
}
