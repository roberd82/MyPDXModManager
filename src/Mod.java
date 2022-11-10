import javax.swing.*;
import java.io.File;
import java.util.ArrayList;

class Mod {


	static ArrayList<File> listOfMods = new ArrayList<>();
	static String[] checkedMods;

	static void getMods() {
		Tool.path = Tool.getPath();

		if (Main.os.equals(Main.oss[0])) {
			Tool.path = Tool.path + "\\mod";
		} else if (Main.os.equals(Main.oss[1]) ||Main.os.equals(Main.oss[2])) {
			Tool.path = Tool.path + "/mod";
		}

		assert Tool.path != null;
		File modFolder = new File(Tool.path);
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
