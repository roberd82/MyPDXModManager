import javax.swing.*;

public class Main {

	static String[] oss = {"Windows", "Linux", "Mac"};
	static String os;
	static String[] games = {"Crusader Kings III", "Europa Universalis IV", "Victoria 3", "Hearts of Iron IV"};
	static String game;

    public static void main(String[] args) {

		JComboBox<String> osCB = new JComboBox<>(oss);
        JOptionPane.showMessageDialog(null, osCB, "Choose the operating system:", JOptionPane.PLAIN_MESSAGE);
        os = oss[osCB.getSelectedIndex()];

        JComboBox<String> gameCB = new JComboBox<>(games);
        JOptionPane.showMessageDialog(null, gameCB, "Choose the game", JOptionPane.PLAIN_MESSAGE);
        game = games[gameCB.getSelectedIndex()];

        new MyFrame();
    }
}
