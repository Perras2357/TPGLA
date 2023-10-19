package test;

import testEtat.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestNonVide {
    private Conteneur C;
    private Object A1, A2, A3,A9, B1, B2 , B3;

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
    	
    	//On vérifie si le conteur n'est pas vide
    	assertFalse(C.estVide());
    	
    	//On vérifie si les éléments ajoutés figurent ddans le conteneur
    	assertEquals(2,C.taille());
    	
    }
    
    //Objectif : On vérifie si le nombre d'élément ajouté correspond à la taille
    //Resultat attendu : Taille du conteneur égale au nombre d'élément ajouté
    @Test
    public void testAjouterNouveauCouple(){
    	
    	A3 = new Object();;
        B3 = new Object();

        assertDoesNotThrow(() -> C.ajouter(A3, B3));
    	
    	//On vérifie si la taille est de 3
    	assertEquals(3,C.taille());
    }
    
    //Objectif : On test l'ajout d'un couple existant
    //Resultat attendu : L'ancien couple est écrasé
    @Test
    public void testAjouterCoupleExistante() throws ErreurConteneur{
    	
    	//On change la valeur du couple et on obtient (A1,B2)
        assertDoesNotThrow(() -> C.ajouter(A1, B2));
    	
        assertEquals(B2,C.valeur(A1));
    }
    
  //Objectif : On test l'ajout d'un couple existant
    //Resultat attendu : L'ancien couple est écrasé
    @Test
    public void testAjouterCoupleExistante1() throws ErreurConteneur{
    	
    	//On change la valeur du couple et on obtient (A1,B2)
        assertDoesNotThrow(() -> C.ajouter(A1, B2));
    	
        assertEquals(B2,C.valeur(A1));
    }
    
    // objectif : Teste la tentative de retrait d'un couple clé-valeur qui n'existe pas dans le conteneur
    // Resultat attendu : Rien ne se passe la taille reste inchangé
    @Test
    public void testRetirerCoupleNonExistant() {
    	
        //On retire un élément qui n'est pas dans le conteneur rien ne se passe
    	//A3 n'existe pas
    	C.retirer(A3);
    	assertEquals(2, C.taille());	
    }
    
    // objectif : Retrait d'un élément d'une liste
    // Resultat attendu : la taille diminue
    @Test
    public void testRetirerCoupleExistant() {
    	
        //On retire un élément qui n'est pas dans le conteneur rien ne se passe
    	//A3 n'existe pas
    	C.retirer(A1);
    	assertEquals(1, C.taille());	
    }
    
    // objectif : Teste si la clé existe
    // Resultat attendu : la clé existe
    @Test
    public void testContientCleExistante() {
    	
        // on vérifie si la clé A2 existe dans le conteneur C
    	assertTrue(C.present(A2));
    }
    
    // objectif : Teste si la clé n'existe pas
    // Resultat attendu : la clé n'existe pas
    @Test
    public void testContientCleInexistante() throws ErreurConteneur {
    	assertFalse(C.present(A3));
    }
    
    // objectif : Obtenir la valeur d'une cle existante
    // Resultat attendu : La clé existe
    @Test
    public void testObtenirValeurCleExistante(){
    	
    	assertEquals(B1, C.present(A1)); 
    }

    // objectif : Obtenir la valeur d'une cle non existante
    // Resultat attendu : on lève une exception
    @Test
    public void testObtenirValeurCleInexistante() {
 
    	//On vérifie que C.present(A3) lève l'exception  ErreurConteneur
    	assertThrows(ErreurConteneur.class ,() -> C.present(A3));
    }
}
