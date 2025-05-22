package view.bill;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BillInformationFrm extends JFrame {
    private JLabel lblContract;
    private JLabel lblTotalOutstanding;
    private JLabel lblTotalPaid;
    private JLabel lblOutstandingDate;
    private JButton btnSave;
    private JButton btnCancel;

    public BillInformationFrm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Bill Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        lblContract = new JLabel("Contract: [Contract ID]");
        lblTotalOutstanding = new JLabel("Total Outstanding: 500");
        lblTotalPaid = new JLabel("Total Paid: 1500");
        lblOutstandingDate = new JLabel("Outstanding Date: 2025-05-19 14:51");
        btnSave = new JButton("Save");
        btnCancel = new JButton("Cancel");

        add(new JLabel("Contract:"));
        add(lblContract);
        add(new JLabel("Total Outstanding:"));
        add(lblTotalOutstanding);
        add(new JLabel("Total Paid:"));
        add(lblTotalPaid);
        add(new JLabel("Outstanding Date:"));
        add(lblOutstandingDate);
        add(btnSave);
        add(btnCancel);

        // Add action listeners
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSaveClick();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelClick();
            }
        });

        pack();
        setLocationRelativeTo(null); // Center the frame
    }

    private void btnSaveClick() {
        // Logic to save bill information (e.g., call BillDAO.updateBillAfterPayment)
        JOptionPane.showMessageDialog(this, "Bill saved successfully!");
        dispose();
    }

    private void btnCancelClick() {
        // Logic to cancel
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new BillInformationFrm().setVisible(true);
        });
    }
}