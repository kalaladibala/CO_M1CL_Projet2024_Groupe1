package org.example.version1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import org.example.version1.Docteur;



public class DocteurTest {
    @Test
    public void testConstructor() {
        // Création d'un docteur
        Docteur docteur = new Docteur(123456789, "Doe");

        // Vérification des valeurs des attributs hérités
        assertEquals(123456789, docteur.getPers_id());
        assertEquals("Doe", docteur.getNom());
    }

    @Test
    public void testSoigner() {
        // Création d'un docteur
        Docteur docteur = new Docteur(0, "");

        // Appel de la méthode soigner
        docteur.soigner();

        // Il n'y a pas de vérification spécifique pour cette méthode, car elle ne retourne pas de valeur.
        // Mais le test permet de s'assurer qu'il n'y a pas d'erreur lors de l'appel de la méthode.
    }
    
}
