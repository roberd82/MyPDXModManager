import javax.swing.*;
import java.io.File;

class Mod {

	static String[] games = {"Crusader Kings II", "Crusader Kings III", "Europa Universalis IV", "Hearts of Iron IV"};
	static File[] listOfMods;

	static void getMods(int game) {

		String path = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Paradox Interactive\\" + games[game] + "\\mod";
		File modFolder = new File(path);
		File[] listOfFilesAndFolders = modFolder.listFiles();
		try {
			listOfMods = new File[listOfFilesAndFolders.length / 2];
			byte j = 0;
			for (File file : listOfFilesAndFolders) {
				if (isMod(file)) {
					listOfMods[j] = file;
					j++;
				}
			}
			Tool.checkedMods = new String[listOfMods.length];
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Your mod folder is empty :(");
			System.exit(0);
		}

	}

	private static boolean isMod(File file) {
		return !file.isDirectory() && file.getName().charAt(file.getName().length() - 3) == 'm' && file.getName().charAt(file.getName().length() - 2) == 'o' && file.getName().charAt(file.getName().length() - 1) == 'd';
	}
}
