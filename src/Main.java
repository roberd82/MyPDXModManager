import javax.swing.*;
import java.awt.*;

public class Main {
	static String[] oss = {"Windows", "Linux", "Mac"};
	static String os;
	static String[] games = {"Crusader Kings III", "Europa Universalis IV", "Victoria 3", "Hearts of Iron IV"};
	static String game;

    public static void main(String[] args) {
		JComboBox<String> osCB = new JComboBox<>(oss);
		JComboBox<String> gameCB = new JComboBox<>(games);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(osCB);
		panel.add(gameCB);

        JOptionPane.showMessageDialog(null, panel, "Choose the operating system and game:", JOptionPane.PLAIN_MESSAGE);
        os = oss[osCB.getSelectedIndex()];
		game = games[gameCB.getSelectedIndex()];

        new MyFrame();
    }
}
