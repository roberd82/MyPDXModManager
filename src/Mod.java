import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

class Mod {

	static String[] games = {"Crusader Kings III", "Europa Universalis IV", "Hearts of Iron IV"};
	static ArrayList<File> listOfMods = new ArrayList<>();
	static String[] checkedMods;

	static void getMods(byte os, byte game) {
		String path = Tool.getPath(os, game);
		switch (os) {
			case 0:
				path = path + "\\mod";
				break;
			case 1:
				path = path + "/mod/";
				break;
			case 2:
				path = path + "/mod";	//probablly not good
			default:
				break;
		}
		File modFolder = new File(path);
		File[] listOfFilesAndFolders = modFolder.listFiles();
		try {
			for (File file : listOfFilesAndFolders) {
				if (isMod(file)) {
					listOfMods.add(file);
				}
			}
			checkedMods = new String[listOfMods.size()];
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Your mod folder is empty :(");
			System.exit(0);
		}

	}

	private static boolean isMod(File file) {
		return !file.isDirectory() && file.getName().charAt(file.getName().length() - 3) == 'm' && file.getName().charAt(file.getName().length() - 2) == 'o' && file.getName().charAt(file.getName().length() - 1) == 'd';
	}
}
