package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestNonVide {
    private Conteneur C;
    private Object A1, A2, B1, B2;

    // Creation d'un conteneur partiellement rempli
    @BeforeEach
    public void creerConteneurNonVide() {
        C = assertDoesNotThrow(() -> new Conteneur(5));

        A1 = new Object();
        A2 = new Object();
        B1 = new Object();
        B2 = new Object();

        assertDoesNotThrow(() -> C.ajouter(A1, B1));
        assertDoesNotThrow(() -> C.ajouter(A2, B2));
    }
    
    //Objectif : Vérifie si le conteneur n'est pas vide après l'ajout
    //Resultat attendu : Conteneur non vide (cotient les éléments ajoutés)
    @Test
    public void verifieContenu(){
    	
    	//On vérifie si le conteur est n'est pas vide
    	assertFalse(C.estVide());
    	
    	//On vérifie si les éléments ajoutés figurent ddans le conteneur
    	assertEquals(2,C.taille());
    	
    }
}
