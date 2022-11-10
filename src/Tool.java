import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Tool {

	static String path;

	static String getPath() {
		if (Main.os.equals(Main.oss[0])) {
			return  "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Paradox Interactive\\" + Main.game;
		} else if (Main.os.equals(Main.oss[1])) {
			return  "/home/" + System.getProperty("user.name") + "/.paradoxinteractive/" + Main.game;
		} else if (Main.os.equals(Main.oss[2])) {
			return  "/Users/" + System.getProperty("user.name") + "/Documents/Paradox Interctive/" + Main.game;	//probablly not good
		}

		return null;
	}

	static void write() {
		try {
			path = getPath();

			if (Main.os.equals(Main.oss[0])) {
				path = path + "\\dlc_load.json";
			} else if (Main.os.equals(Main.oss[1]) || Main.os.equals(Main.oss[2])) {
				path = path + "/dlc_load.json";
			}

			assert path != null;
			BufferedWriter bfw = new BufferedWriter(new FileWriter(path));

			ArrayList<String> toBeWrittenMods = new ArrayList<>();
			for (String checkedMod : Mod.checkedMods) {
				if (checkedMod != null) {
					toBeWrittenMods.add(checkedMod);
				}
			}

			StringBuilder string = new StringBuilder("{\"disabled_dlcs\":[],\"enabled_mods\":[");
			for (int i = 0; i < toBeWrittenMods.size(); i++) {
				string.append("\"mod/");
				string.append(toBeWrittenMods.get(i));
				if (i != toBeWrittenMods.size() - 1) {
					string.append("\",");
				} else {
					string.append("\"");
				}
			}
			string.append("]}");

			bfw.write(string.toString());
			bfw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
