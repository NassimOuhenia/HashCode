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
 * Nom:				Ghouas 
 * Prénom:			Abdelhak
 * N° d'étudiant :  21707514
 * 
 * email:			ghouas.abdelhak@gmail.com
 * 
 * Remarques:	    *****************	
 */
package ouheniaNassimTP3;

public class MainHash {

	public static void main(String[] args) throws Exception {

		HashLinearProbing probing = new HashLinearProbing();
		File file = new File();
		
		char[] r = file.getArray(file.getBuFileR());
		
		for (int i = 0; i < r.length; i++) {
			probing.put(r[i], i);
		}
		
		System.out.println(probing);
		
		file.writeHash(probing.getKeys(), probing.getValues());
	}

}
