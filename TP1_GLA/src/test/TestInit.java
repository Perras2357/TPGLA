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
    
    // Objectif de test :Augmentation de la capacité si le conteneur est plein
    // Resultat attendu : Conteneur avec une capacité plus grande
    @Test
    public void capacitéConteneurPlein() throws ErreurConteneur {
        
    	//on vérifie si le conteneur est plein en comparant la capacité avec la taille du conteneur
    	assertEquals(C.taille(),C.capacite());
    	
    	//on redimension le conteneur
    	C.redimensionner(6);
    	
    }
    
    
}
