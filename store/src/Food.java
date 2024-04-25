import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Food extends JFrame {
    private JPanel panel;
    private JFrame frame;
    private JButton fish;
    private JButton lamb;
    private JButton brocolli;
    private JButton taugeh;
    private JButton cucumber;
    private JButton back;

    public Food() {
        panel = new JPanel();

        frame = new JFrame("Mannoj's Grocery Store");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);

        panel.setLayout(null);

        fish = new JButton("Fish - RM 20");
        fish.setBounds(350, 100, 150, 25);
        panel.add(fish);

        lamb = new JButton("Lamb - RM10");
        lamb.setBounds(350, 140, 150, 25); // Corrected bounds for the lamb button
        panel.add(lamb);

        brocolli = new JButton("Brocolli - RM25");
        brocolli.setBounds(350, 180, 150, 25); // Corrected bounds for the brocolli button
        panel.add(brocolli);

        taugeh = new JButton("Taugeh - RM6");
        taugeh.setBounds(350, 220, 150, 25); // Corrected bounds for the taugeh button
        panel.add(taugeh);

        cucumber = new JButton("Cucumber - RM9");
        cucumber.setBounds(350, 260, 150, 25); // Corrected bounds for the cucumber button
        panel.add(cucumber);

        back = new JButton("Main Menu");
        back.setBounds(350, 300, 150, 25); // Corrected bounds for the food button
        back.addActionListener(new backActionListener());
        panel.add(back);

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

}
