package test;

import testEtat.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestInit {
    private Conteneur C;

    // Objectif de test : Creation d'un conteneur de capacite > 1
    // Resultat attendu : Conteneur vide cree de la capacite passee en argument
    @Test
    public void capaciteSup1() {
        // On force le test a echouer si une exception est levee
        // On recupere le conteneur si tout se passe correctement
        C = assertDoesNotThrow(() -> new Conteneur(5));

        assertNotNull(C);

        assertTrue(C.estVide());
        assertEquals(C.taille(), 0);
        assertEquals(C.capacite(), 5);
    }
}
