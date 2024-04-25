import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JCheckBox checkRoyaltyCard;
    private JButton buttonAddItem;
    private JTextArea textBill;

    private double totalBill;
    private double discountAmount;

    private JLabel labelItem, labelPrice;
    private JTextField txtItem;
    private JButton menu;
    private JButton reset;

    public MainFrame() {
        super("Mannoj's Grogery Store");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setVisible(true);

        labelItem = new JLabel("Grocery Item:");
        txtItem = new JTextField(20);
        labelPrice = new JLabel(" |");

        checkRoyaltyCard = new JCheckBox("Royalty Card");
        buttonAddItem = new JButton("Add Item");
        textBill = new JTextArea(20, 30);

        menu = new JButton("Main menu");
        menu.setBounds(10, 10, 265, 25);
        add(menu);

        reset = new JButton("Reset");
        reset.setBounds(250, 255, 265, 25);
        add(reset);

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textBill.setText("");
                totalBill = 0.0;
                discountAmount = 0.0;
            }
        });

        menu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HomePage();
                MainFrame.this.dispose();
            }
        });

        totalBill = 0.0;
        discountAmount = 0.0;

        JScrollPane scrollPane = new JScrollPane(textBill);
        setLayout(new FlowLayout());

        add(labelItem);
        add(txtItem);
        add(labelPrice);
        add(checkRoyaltyCard);
        add(buttonAddItem);
        add(scrollPane);

        textBill.setEditable(false);

        buttonAddItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sumBill();

            }
        });

    }

    private String getItemPrice(String item) {
        if (item.equals("fish")) {
            return "20";
        }

        if (item.equals("lamb")) {
            return "10";
        }
        if (item.equals("brocolli")) {
            return "25";
        }
        if (item.equals("taugeh")) {
            return "6";
        }
        if (item.equals("cucumber")) {
            return "9";
        }

        return null;
    }

    private void sumBill() {
        String item = txtItem.getText();

        if (item.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in item field.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (getItemPrice(item) == null) {
            JOptionPane.showMessageDialog(this, "Please choose available options.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price;
        try {
            price = Double.parseDouble(getItemPrice(item));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid price. Please enter a valid number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean hasRoyaltyCard = checkRoyaltyCard.isSelected();
        if (hasRoyaltyCard) {
            String cardNumber = JOptionPane.showInputDialog(this, "Enter your royalty card number:");
            if (cardNumber == null || cardNumber.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Invalid royalty card number. Please try again.", "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        String quantityText = JOptionPane.showInputDialog(this, "Enter the quantity of " + item + ":");

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid quantity. Please enter a valid number.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        double totalPrice = price * quantity;

        totalBill += totalPrice;

        discountAmount = hasRoyaltyCard ? totalBill * 0.05 : 0.0;

        double netPayable = totalBill - discountAmount;

        textBill.append("-------------------------------------\n");
        textBill.append(item + " - RM" + price + "\n");
        textBill.append("Quantity: " + quantity + "\n");
        textBill.append("Total Bill: RM" + totalBill + "\n");
        textBill.append("Discount: RM" + discountAmount + "\n");
        textBill.append("Net Payable: RM" + netPayable + "\n");
        textBill.append("-------------------------------------\n");

        txtItem.setText("");
    }

    // public static void main(String[] args) {
    // SwingUtilities.invokeLater(new Runnable() {
    // public void run() {
    // MainFrame app = new MainFrame();
    // app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // app.setSize(800, 600);
    // app.setVisible(true);
    // }
    // });
    // }
}
