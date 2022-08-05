import javax.swing.*;
import java.awt.*;

class MyFrame extends JFrame {

	private static JCheckBox[] checkBoxes;

	MyFrame() {
		JComboBox gameCB = new JComboBox(Mod.games);
		JOptionPane.showMessageDialog(null, gameCB, "Choose the game:", JOptionPane.PLAIN_MESSAGE);
		int game = gameCB.getSelectedIndex();
		Mod.getMods(game);
		this.setTitle("My Paradox Mod Manager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(Mod.listOfMods.length + 2, 1));

		makeCheckBoxes();

		JLabel label = new JLabel("Choose the mods you want to use above");

		JButton buttonSave = new JButton("Save");
		buttonSave.addActionListener(e -> {
			Tool.write(game);
			label.setText("The mod config was saved :)");
		});

		this.add(label);
		this.add(buttonSave);
		this.pack();
		this.setVisible(true);
	}

	private void makeCheckBoxes() {
		checkBoxes = new JCheckBox[Mod.listOfMods.length];
		for (int i = 0; i < checkBoxes.length; i++) {
			checkBoxes[i] = new JCheckBox();
			checkBoxes[i].setText(Mod.listOfMods[i].getName());
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
