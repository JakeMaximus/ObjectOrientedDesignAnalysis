import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

    private JPanel panel;
    private JFrame frame;
    private JLabel userlabel;
    private JTextField userText;
    private JLabel passwordLabel;
    private JPasswordField passwordText;
    private JButton button;
    private JButton back;

    public Login() {
        panel = new JPanel();

        frame = new JFrame("Mannoj's Grocery Store");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null);

        userlabel = new JLabel("Username");
        userlabel.setBounds(250, 175, 80, 25);
        panel.add(userlabel);

        userText = new JTextField(20);
        userText.setBounds(350, 175, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(250, 215, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField();
        passwordText.setBounds(350, 215, 165, 25);
        panel.add(passwordText);

        button = new JButton("Login");
        button.setBounds(250, 255, 265, 25);
        button.addActionListener(new buttonActionListener());
        panel.add(button);

        back = new JButton("Main Menu");
        back.setBounds(250, 295, 265, 25); // Corrected bounds for the food button
        back.addActionListener(new backActionListener());
        panel.add(back);

        // success = new JLabel("ddd");
        // success.setBounds(10, 110, 300, 25);
        // panel.add(success);

        frame.setVisible(true);
    }

    public class backActionListener implements ActionListener {

        @Override
        public void actionPerformed(java.awt.event.ActionEvent e) {
            // TODO Auto-generated method stub
            new HomePage();
            frame.dispose();
        }
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    // // TODO Auto-generated method stub

    // String user = userText.getText();
    // String password = passwordText.getText();

    // if (user.equals("Admin") && password.equals("MannojAdmin")) {
    // success.setText("Login successful!");
    // }
    // }

    public class buttonActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            JFrame parent = new JFrame();
            String user = userText.getText();
            String password = passwordText.getText();

            if (user.equals("admin") && password.equals("admin123")) {

                JOptionPane.showMessageDialog(parent, "Login Successful");
                new MainFrame();
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(parent, "Incorrect username or password. Please try again");
                userText.setText("");
                passwordText.setText("");

            }

        }
    }

}
