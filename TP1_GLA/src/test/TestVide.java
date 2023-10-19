package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVide {
    private Conteneur C;

    // Creation d'un conteneur vide
    @BeforeEach
    public void creerConteneurVide() {
        C = assertDoesNotThrow(() -> new Conteneur(10));
    }

    // Objectif de test : Remise a zero d'un conteneur vide
    // Resultat attendu : Remise a zero impossible, levee de l'exception ErreurConteneur
    @Test
    public void razVide() {
        // on force le test a echouer si aucune exception n'est levee
        // si une exception de type ErreurConteneur est levee, le test reussit
        assertThrows(ErreurConteneur.class, () -> C.raz());

        // on verifie que le conteneur n'a pas ete modifie
        assertTrue(C.estVide());
        assertEquals(C.taille(), 0);
        assertEquals(C.capacite(), 10);
    }
}
