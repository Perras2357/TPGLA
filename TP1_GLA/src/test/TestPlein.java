package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPlein {
    private Conteneur C;
    private Object A1, A2, A3, A4, A5, B1, B2, B3, B4, B5;

    // Creation d'un conteneur plein
    @BeforeEach
    public void creerConteneurPlein() {
        C = assertDoesNotThrow(() -> new Conteneur(5));

        A1 = new Object();
        A2 = new Object();
        A3 = new Object();
        A4 = new Object();
        A5 = new Object();
        B1 = new Object();
        B2 = new Object();
        B3 = new Object();
        B4 = new Object();
        B5 = new Object();

        assertDoesNotThrow(() -> C.ajouter(A1, B1));
        assertDoesNotThrow(() -> C.ajouter(A2, B2));
        assertDoesNotThrow(() -> C.ajouter(A3, B3));
        assertDoesNotThrow(() -> C.ajouter(A4, B4));
        assertDoesNotThrow(() -> C.ajouter(A5, B5));
    }

    // Objectif de test : Ajout d'un element dont la cle est deja presente dans un conteneur plein
    // Resultat attendu : Ajout possible et ancien couple de meme cle ecrase
    @Test
    public void ajouterPresentPlein() {
        Object B = new Object();

        // On force le test a echouer si une exception est levee
        assertDoesNotThrow(() -> C.ajouter(A2, B));

        assertTrue(C.present(A2));

        // On force le test a echouer si une exception est levee
        // Si aucune exception n'est levee, on verifie que B
        // est bien le nouveau couple de la cle A2
        assertEquals(B, assertDoesNotThrow(() -> C.valeur(A2)));

        // on verifie que le conteneur n'a pas ete modifie
        assertEquals(C.taille(), 5);
        assertEquals(C.capacite(), 5);
    }
}
