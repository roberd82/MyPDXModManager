import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Tool {

	static String getPath(byte os, byte game) {
		String path = "";
		switch (os) {
			case 0:
				path = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Paradox Interactive\\" + Mod.games[game];
				break;
			case 1:
				path = "/home/" + System.getProperty("user.name") + "/.paradoxinteractive/" + Mod.games[game];
				break;
			case 2:
				path = "/Users/" + System.getProperty("user.name") + "/Documents/Paradox Interctive/" + Mod.games[game];	//probablly not good
			default:
				break;
		}
		return path;
	}

	static void write(byte os, byte game) {
		ArrayList<String> toBeWrittenMods = new ArrayList<>();
		for (String checkedMod : Mod.checkedMods) {
			if (checkedMod != null) {
				toBeWrittenMods.add(checkedMod);
			}
		}

		String path = getPath(os, game);
		switch (os) {
			case 0:
				path = path + "\\dlc_load.json";
				break;
			case 1:
				path = path + "/dlc_load.json";
				break;
			case 2:
				path = path + "/dlc_lod.json";	//probablly not good
			default:
				break;
		}
		
		try {
			BufferedWriter bfw = new BufferedWriter(new FileWriter(path));

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
