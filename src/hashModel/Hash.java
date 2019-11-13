/**
 * TP n°: 3
 * 
 * Titre du TP:		HashLinearProbing
 * 
 * Date:			08 Novembre 2019
 * 
 * Nom:				Ouhenia
 * Prénom:			Nassim
 * N° d'étudiant :  21703313
 * 
 * email:			nassim.ouhenia@gmail.com
 * 
 * Remarques:	    *****************	
 */
package hashModel;

public interface Hash {
	
	public void put(char key, int value);
	
	public int get(char key);
	
	public int remove(char key);
	
}
