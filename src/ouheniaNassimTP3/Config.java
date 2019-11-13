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
import java.util.Properties;

public class Config {

	private final static String RESSOURCE = "ressources/config.properties";

	private final static String FILE1 = "FILE1";
	private final static String FILE2 = "FILE2";
	
	private final static String MAX_SIZE = "MAX_SIZE";

	private final String PATHFILE1 = "src/r.txt";
	private final String PATHFILE3 = "src/hash.txt";
	
	private final static int M = 11;
	
	private InputStream input;
	private OutputStream output;

	private Properties prop;

	private static Config instance = null;

	private Config() {
		try {
			input = new FileInputStream(RESSOURCE);
			output = new FileOutputStream(RESSOURCE);
			prop = new Properties();
			initPropreties(PATHFILE1, PATHFILE3,M);
			// load a properties file
			prop.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initPropreties(String pathFileR, String pathFileRS, int max_size) throws Exception {
		setMaxSize(max_size);
		setPathFileR(pathFileR);
		setPathFileHash(pathFileRS);
	}

	public static Config getConfig() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	public int getMaxSize() {
		return Integer.parseInt(prop.getProperty(MAX_SIZE));
	}

	public void setMaxSize(int new_size) throws IOException {
		prop.setProperty(MAX_SIZE, String.valueOf(new_size));
		prop.store(output, null);
	}

	public String getPathFileR() {
		return prop.getProperty(FILE1);
	}

	public void setPathFileR(String new_file) throws IOException {
		prop.setProperty(FILE1, new_file);
		prop.store(output, null);
	}


	public String getPathFileHash() {
		return prop.getProperty(FILE2);
	}

	public void setPathFileHash(String new_file) throws IOException {
		prop.setProperty(FILE2, new_file);
		prop.store(output, null);
	}
}
