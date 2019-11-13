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

package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ouheniaNassimTP3.HashLinearProbing;

class HashTest {

	final static int M = 11;
	
	private char[] TabKey = { 'B', 'O', 'E', 'P', 'V', 'L', 'X', 'N', 'K', 'M' };
	private int[] TabValues = { 0, 6, 1, 2, 3, 7, 8, 9, 0, 4, 5 };

	private char[] TabKeyRemove = { 'B', 'X', 'O', 'E', 'P', 'K', 'M', '\0', '\0', 'V', 'L' };
	private int[] TabValuesRemove = { 0, 6, 1, 2, 3, 8, 9, 0, 0, 4, 5 };

	HashLinearProbing hs;

	@BeforeEach
	void setUp() {
		hs = new HashLinearProbing();
		for (int i = 0; i < TabKey.length; i++) {
			hs.put(TabKey[i], i);
		}
	}

	@Test
	public void testPut() {
		assertArrayEquals(hs.getValues(), TabValues);
	}

	@Test
	public void testGet() {

		assertEquals(hs.get('B'), 0);
		assertEquals(hs.get('Y'), -1);

	}

	@Test
	public void testRemove() {

		assertEquals(hs.remove('N'), 1);
		assertEquals(hs.get('Y'), -1);
		
		assertArrayEquals(hs.getValues(), TabValuesRemove);
		
		assertArrayEquals(hs.getKeys(), TabKeyRemove);

	}

}
