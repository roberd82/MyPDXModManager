import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Tool {

	static String[] checkedMods;

	static void write(int game) {
		ArrayList<String> toBeWrittenMods = new ArrayList<>();
		for (String checkedMod : checkedMods) {
			if (checkedMod != null) {
				toBeWrittenMods.add(checkedMod);
			}

		}

		try {
		String path = "C:\\Users\\" + System.getProperty("user.name") + "\\Documents\\Paradox Interactive\\" + Mod.games[game] + "\\dlc_load.json";
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
