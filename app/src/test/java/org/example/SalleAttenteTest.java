package org.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SalleAttenteTest {

    @Test
    public void testConstructorAndGetters() {
        // Création d'une salle d'attente avec un certain nombre de places
        SalleAttente salle = new SalleAttente(1, "Salle A", "Bâtiment principal", 50);

        // Vérification des valeurs attribuées par le constructeur
        assertEquals(1, salle.getNo_s());
        assertEquals("Salle A", salle.getNom_s());
        assertEquals("Bâtiment principal", salle.getLocalisation_s());
        assertEquals(50, salle.getnb_Places_s());

        // Modification des valeurs avec les mutateurs
        salle.setNo_s(2);
        salle.setNom_s("Salle B");
        salle.setLocalisation_s("Aile nord");
        salle.setnb_Places_s(100);

        // Vérification que les valeurs ont été correctement modifiées
        assertEquals(2, salle.getNo_s());
        assertEquals("Salle B", salle.getNom_s());
        assertEquals("Aile nord", salle.getLocalisation_s());
        assertEquals(100, salle.getnb_Places_s());
    }
}
