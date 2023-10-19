package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestPlein {
    private Conteneur C;
    private Object A1, A2, A3, A4, A5, B1, B2, B3, B4, B5, AX, BX;

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
    
    // Objectif de test : on vérifie que les valeurs sont correctes pour les clés existantes
    // Resultat attendu : Toutes les valeurs correspondent aux clés ajoutées
    @Test
    public void testObtenirValeur() throws ErreurConteneur {
    	//On verifie si les couples sont correctement agencés
    	assertEquals(B1, C.valeur(A1));
    	assertEquals(B2, C.valeur(A2));
    	assertEquals(B3, C.valeur(A3));
    	assertEquals(B4, C.valeur(A4));
    	assertEquals(B5, C.valeur(A5));
    }
    
    // Objectif de test : on vérifie que les clés existantes sont présentes
    // Resultat attendu : Toutes les clés existantes sont présentent 
    @Test
    public void testEstPresent(){
    	//On verifie si les couples sont correctement agencés
    	assertTrue(C.present(A1));
    	assertTrue(C.present(A2));
    	assertTrue(C.present(A3));
    	assertTrue(C.present(A4));
    	assertTrue(C.present(A4));
    }
    
    // Objectif de test : on vérifie que les clés retirées ne sont plus présentes
    // Resultat attendu : Toutes les clés retirées ne sont plus présentent 
    @Test
    public void testRetirer(){
    	
    	//on retire deux couples clés valeurs
    	C.retirer(A1);
    	C.retirer(A2);
    	
    	//On verifie la présence des couples retirés
    	assertFalse(C.present(A1));
    	assertFalse(C.present(A2));
    }
    
    // Objectif de test : on vérifie que le conteneur est vide après vidage.
    // Resultat attendu : conteneur vide et Capacité inchangé 
    @Test
    public void testVider(){
    	
    	//on vide le conteneur
    	C.retirer(A1);
    	C.retirer(A2);
    	C.retirer(A3);
    	C.retirer(A4);
    	C.retirer(A5);
    	
    	//on vérifie si le conteneur est vide 
    	assertTrue(C.estVide());
    	
    	//On vérifie que la capacité n'a pas changé
    	assertEquals(C.capacite(), 5);
    }
    
    // Objectif : Teste le nombre de couples clé-valeur après le retrait
    // Resultat attendu : les éléments supprimés n'apparaissent plus dans le conteneur
    @Test
    public void testNombreCouplesApresRetrait() {
    	
    	// on vérifie que le nombre de couples est correct
    	assertEquals(C.taille(), 5);
    	
    	//on retire deux éléments
    	C.retirer(A1);
    	C.retirer(A2);
    	
    	// on vérifie à nouveau que le nombre de couples est correct.
    	assertEquals(C.taille(), 3);
    	
        //l'élément retiré n'est plus présent dans le conteneur
        assertFalse(C.present(A1));
    }
    
    // Objectif : Ajout d'un couple clé-valeur à un conteneur plein
    // Resultat attendu : on lève une exception
    @Test
    public void testAjoutSurConteneurPlein() {
    	
    	AX = new Object();
        BX = new Object();
        
        // on tente d'ajouter un couple clé-valeur
        assertThrows(DebordementConteneur.class,() -> C.ajouter(AX, BX));
    	
    }
}
