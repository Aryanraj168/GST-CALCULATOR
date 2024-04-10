package GST_CALCULATOR;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridLayout;

public class GstCalculator {
    public static void main(String[] args) {
        JFrame MyFeame = new JFrame("GST Calculator");
        MyFeame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyFeame.setSize(300, 250);

        JPanel mypanel = new JPanel(new GridLayout(0, 2));

        JLabel itemLabel = new JLabel("RATE OF ITEMS    ");
        JTextField itemRateField = new JTextField(100);

        JLabel quantityLabel = new JLabel("QUANTITY    ");
        JTextField quantityField = new JTextField(100);

        JLabel gstRateLabel = new JLabel("GST PERCENT    ");
        JTextField gstRateField = new JTextField(100);

        JButton calculateButton = new JButton("COST WITH GST    ");
        JButton resetButton = new JButton("RESET");

        JLabel resultLabel = new JLabel();

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double itemRate = Double.parseDouble(itemRateField.getText());
                    double quantity = Double.parseDouble(quantityField.getText());
                    double gstRate = Double.parseDouble(gstRateField.getText());

                    double subtotal = itemRate * quantity;
                    double gstAmount = (subtotal * gstRate) / 100;
                    double totalAmount = subtotal + gstAmount;

                    resultLabel.setText( "  Total Amount (including GST): " + totalAmount);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Please enter valid numbers for item rate, quantity, and GST rate.");
                }
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemRateField.setText("");
                quantityField.setText("");
                gstRateField.setText("");
                resultLabel.setText("");
            }
        });

        mypanel.add(itemLabel);
        mypanel.add(itemRateField);
        mypanel.add(quantityLabel);
        mypanel.add(quantityField);
        mypanel.add(gstRateLabel);
        mypanel.add(gstRateField);
        mypanel.add(calculateButton);
        mypanel.add(resetButton);
        mypanel.add(resultLabel);

        MyFeame.add(mypanel);
        MyFeame.setVisible(true);
    }
}