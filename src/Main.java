import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        JComboBox<String> gameCB = new JComboBox<>(Mod.games);
        JOptionPane.showMessageDialog(null, gameCB, "Choose the game:", JOptionPane.PLAIN_MESSAGE);
        int game = gameCB.getSelectedIndex();

        new MyFrame(game);
    }
}
