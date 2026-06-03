import javax.swing.*;
import java.awt.event.*;

public class FraudFrame extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel amountLabel;
    JLabel transactionLabel;
    JLabel foreignLabel;
    JLabel resultLabel;

    JTextField amountField;
    JTextField transactionField;

    JCheckBox foreignCheckBox;

    JButton checkButton;

    public FraudFrame() {

        setTitle("Credit Card Fraud Detection");
        setSize(500, 400);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("CREDIT CARD FRAUD DETECTION");
        titleLabel.setBounds(130, 20, 250, 30);
        add(titleLabel);

        amountLabel = new JLabel("Amount:");
        amountLabel.setBounds(50, 80, 100, 25);
        add(amountLabel);

        amountField = new JTextField();
        amountField.setBounds(180, 80, 200, 25);
        add(amountField);

        transactionLabel = new JLabel("Transactions Today:");
        transactionLabel.setBounds(50, 130, 120, 25);
        add(transactionLabel);

        transactionField = new JTextField();
        transactionField.setBounds(180, 130, 200, 25);
        add(transactionField);

        foreignLabel = new JLabel("Foreign Transaction:");
        foreignLabel.setBounds(50, 180, 130, 25);
        add(foreignLabel);

        foreignCheckBox = new JCheckBox();
        foreignCheckBox.setBounds(180, 180, 50, 25);
        add(foreignCheckBox);

        checkButton = new JButton("Check Fraud");
        checkButton.setBounds(170, 240, 140, 35);
        checkButton.addActionListener(this);
        add(checkButton);

        resultLabel = new JLabel("");
        resultLabel.setBounds(120, 300, 300, 30);
        add(resultLabel);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            double amount =
                    Double.parseDouble(amountField.getText());

            int transactions =
                    Integer.parseInt(transactionField.getText());

            boolean foreign =
                    foreignCheckBox.isSelected();

            boolean fraud =
                    FraudDetector.isFraud(
                            amount,
                            transactions,
                            foreign);

            if (fraud) {
                resultLabel.setText("⚠ Fraudulent Transaction Detected");
            } else {
                resultLabel.setText("✓ Transaction is Safe");
            }

        } catch (Exception ex) {

            resultLabel.setText("Enter Valid Inputs");
        }
    }

    public static void main(String[] args) {

        new FraudFrame();
    }
}