package view.staff;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.contract.SearchContractFrm;

public class StaffHomeFrm extends JFrame {
    private JButton btnPay;
    private JButton btnCancel;

    public StaffHomeFrm() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Staff Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        btnPay = new JButton("Pay");
        btnCancel = new JButton("Cancel");

        add(btnPay);
        add(btnCancel);

        btnPay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnPayClick();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelClick();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void btnPayClick() {
        dispose();
        new SearchContractFrm().setVisible(true);
    }

    private void btnCancelClick() {
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new StaffHomeFrm().setVisible(true);
        });
    }
}