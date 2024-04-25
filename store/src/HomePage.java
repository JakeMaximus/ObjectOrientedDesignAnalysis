
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HomePage extends JFrame {

    private JPanel panel;
    private JFrame frame;
    private JButton login;
    private JButton food;
    private JLabel dummyImage;
    private ImageIcon logo;

    public HomePage() {

        panel = new JPanel();

        frame = new JFrame("Mannoj's Grocery Store");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null);

        try {
            logo = new ImageIcon(getClass().getResource("Grocery.png"));
            dummyImage = new JLabel(logo);
            dummyImage.setBounds(200, 50, 350, 300); // Set the bounds for the image label
            panel.add(dummyImage);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Failed to load the image: " + e.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }

        login = new JButton("Login");
        login.setBounds(300, 400, 150, 25);
        login.addActionListener(new loginActionListener());
        panel.add(login);

        food = new JButton("View Available Food");
        food.setBounds(300, 440, 150, 25); // Corrected bounds for the food button
        food.addActionListener(new foodActionListener());
        panel.add(food);

        frame.setVisible(true);
    }

    public class loginActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Login();
            frame.dispose();
        }
    }

    public class foodActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new Food();
            frame.dispose();
        }
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
