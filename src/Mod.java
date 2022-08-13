import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

class Mod {

	static String[] games = {"Crusader Kings III", "Europa Universalis IV", "Hearts of Iron IV"};
	static ArrayList<File> listOfMods = new ArrayList<>();

	static void getMods(int os, int game) {
		String path = "";
		switch (os) {
			case 0:
				path = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Paradox Interactive\\" + Mod.games[game] + "\\mod";
				break;
			case 1:
				path = "/home/" + System.getProperty("user.name") + "/.paradoxinteractive/Crusader Kings II/mod/";
				break;
			case 2:
				path = "/Users/" + System.getProperty("user.name") + "/Documents/Paradox Interctive/Crusader Kings II/mod";	//probablly not good
			default:
				break;
		}		File modFolder = new File(path);
		File[] listOfFilesAndFolders = modFolder.listFiles();
		try {
			for (File file : listOfFilesAndFolders) {
				if (isMod(file)) {
					listOfMods.add(file);
				}
			}
			Tool.checkedMods = new String[listOfMods.size()];
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Your mod folder is empty :(");
			System.exit(0);
		}

	}

	private static boolean isMod(File file) {
		return !file.isDirectory() && file.getName().charAt(file.getName().length() - 3) == 'm' && file.getName().charAt(file.getName().length() - 2) == 'o' && file.getName().charAt(file.getName().length() - 1) == 'd';
	}
}
