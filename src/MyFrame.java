import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {

	private static JCheckBox[] checkBoxes;

	MyFrame(int os, int game) {
		Mod.getMods(os, game);
		this.setTitle("My Paradox Mod Manager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(Mod.listOfMods.size() + 2, 1));

		makeCheckBoxes();

		JLabel label = new JLabel("Choose the mods you want to use above");

		JButton buttonSave = new JButton("Save");
		buttonSave.addActionListener(e -> {
			Tool.write(os, game);
			label.setText("The mod config was saved :)");
		});

		this.add(label);
		this.add(buttonSave);
		this.pack();
		this.setVisible(true);
	}

	private void makeCheckBoxes() {
		checkBoxes = new JCheckBox[Mod.listOfMods.size()];
		for (int i = 0; i < checkBoxes.length; i++) {
			checkBoxes[i] = new JCheckBox();
			checkBoxes[i].setText(Mod.listOfMods.get(i).getName());
			System.out.println(checkBoxes[i].getText());
			int finalI = i;
			checkBoxes[i].addActionListener(e -> {
				if (Tool.checkedMods[finalI] == null) {
					Tool.checkedMods[finalI] = checkBoxes[finalI].getText();
				} else {
					Tool.checkedMods[finalI] = null;
				}
			});
			this.add(checkBoxes[i]);
		}
	}
}
