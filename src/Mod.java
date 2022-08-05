import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

class Mod {

	static String[] games = {"Crusader Kings II", "Crusader Kings III", "Europa Universalis IV", "Hearts of Iron IV"};
	static ArrayList<File> listOfMods = new ArrayList<>();

	static void getMods(int game) {

		String path = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Paradox Interactive\\" + games[game] + "\\mod";
		File modFolder = new File(path);
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
