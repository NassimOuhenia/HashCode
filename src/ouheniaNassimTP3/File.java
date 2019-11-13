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

import java.io.*;

public class File {

	private BufferedReader buFileR;

	private BufferedWriter bwFileHash;
	private Config config;

	public File() throws IOException {
		config = Config.getConfig();
		buFileR = new BufferedReader(new FileReader(config.getPathFileR()));

		bwFileHash = new BufferedWriter(new FileWriter(config.getPathFileHash()));
	}

	public File(String fileR, String fileRS) throws IOException {
		buFileR = new BufferedReader(new FileReader(fileR));

		bwFileHash = new BufferedWriter(new FileWriter(fileRS));
	}

	public void writeHash(char[] keys, int[] values) throws Exception {
		int taille = config.getMaxSize();
		for (int i = 0; i < taille; i++) {
			bwFileHash.write(keys[i]+" : "+values[i]);
			bwFileHash.write('\n');
			
		}
		closeBuffers();
	}

	public char[] getArray(BufferedReader br) throws Exception {
		int max_size = config.getMaxSize();
		char[] result = new char[max_size];

		String line;
		int i = 0;
		while ((line = br.readLine()) != null) {
			result[i] = line.charAt(0);
			i++;
			if (max_size == i)
				break;
		}

		return result;
	}

	public void closeBuffers() throws IOException {
		buFileR.close();
		bwFileHash.close();
	}

	public BufferedReader getBuFileR() {
		return buFileR;
	}

	public BufferedWriter getBwFileHash() {
		return bwFileHash;
	}
	

}
