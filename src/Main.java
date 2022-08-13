import javax.swing.*;

public class Main {

    public static void main(String[] args) {
		String[] oss = {"Windows", "Linux", "Mac"};
		JComboBox<String> osCB = new JComboBox<>(oss);
        JOptionPane.showMessageDialog(null, osCB, "Choose the operating system:", JOptionPane.PLAIN_MESSAGE);
        int os = osCB.getSelectedIndex();

        JComboBox<String> gameCB = new JComboBox<>(Mod.games);
        JOptionPane.showMessageDialog(null, gameCB, "Choose the game", JOptionPane.PLAIN_MESSAGE);
        int game = gameCB.getSelectedIndex();

        new MyFrame(os, game);
    }
}
