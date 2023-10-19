package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestVide {
    private Conteneur C;
    private Object A1, A2, A3, A4, A5, B1, B2, B3, B4, B5;

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
    //Objectif de test : vérifie si le conteneur est vide apres ajout
    // Resultat attendu : Le conteneur ne doit pas etre vide
    
    @Test
    public void testConteneurNonVideApresAjout() {
    	
        // on ajoute les éléments dans le conteneurs et on vérifie s'il a pris en compte l'ajout
    	
    	A1 = new Object();
        A2 = new Object();
        B1 = new Object();
        B2 = new Object();
        
        assertDoesNotThrow(() -> C.ajouter(A1, B1));
        assertDoesNotThrow(() -> C.ajouter(A2, B2));

        // on verifie que le conteneur n'est pas vide
        assertFalse(C.estVide());
    }
    
    // Objectif : Teste le nombre de couples clé-valeur après l'ajout
    // Resultat attendu : La taille correspond au nombre d'élément ajouté
    @Test
    public void testNombreCouplesApresAjout() {
    	
        assertEquals(2,C.taille());
    }
    
}
