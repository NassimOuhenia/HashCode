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

import hashModel.Hash;

public class HashLinearProbing implements Hash {
	
	final static int M = Config.getConfig().getMaxSize();

	private char keys[];
	private int values[];
	
	public HashLinearProbing() {
		keys = new char[M];
		values = new int[M];
	}
	
	private int hash(int key) {
		return key % M;
	}

	@Override
	public void put(char key, int value) {

		int index = hash(key);
		while (keys[index] != '\0') {
			index = (index + 1) % M;
		}

		keys[index] = key;
		values[index] = value;
	}

	@Override
	public int get(char key) {
		int index = hash(key);
		int valueToReturn = -1; // value to return if the key is not in the map

		while (keys[index] != key && keys[index] != '\0') {
			index = (index + 1) % M;
		}

		if (keys[index] == key)
			valueToReturn = values[index];

		return valueToReturn;

	}

	@Override
	public int remove(char key) {

		int index = hash(key);

		while (keys[index] != key && keys[index] != '\0') {
			index = (index + 1) % M;
		}

		if (keys[index] == '\0') {
			return -1;
		}

		keys[index] = '\0';
		values[index] = 0;
		// rehash
		index = (index + 1) % M;
		while (keys[index] != '\0') {
			char savedKey = keys[index];
			int savedValue = values[index];
			keys[index] = 0;
			values[index] = 0;
			put(savedKey, savedValue);
			index = (index + 1) % M;
		}

		return 1;
	}
	
	
	
	public char[] getKeys() {
		return keys;
	}

	public int[] getValues() {
		return values;
	}

	public String toString() {
		String print = "";
		for (int i = 0; i < M-1; i++) {
			print += keys[i]+" : "+values[i]+"\n";
		}
		print += keys[M-1]+" : "+values[M-1];
		return print;
	}

}
