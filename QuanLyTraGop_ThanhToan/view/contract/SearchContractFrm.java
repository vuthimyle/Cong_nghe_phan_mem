package view.contract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.ContractDAO;
import model.Contract;

import view.contract.ContractInformationFrm;

public class SearchContractFrm extends JFrame {
    private JTextField txtSearch;
    private JButton btnSearch;
    private ContractDAO contractDAO;

    public SearchContractFrm() {
        contractDAO = new ContractDAO(); // Initialize DAO
        initComponents();
    }

    private void initComponents() {
        setTitle("Search Contract");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new FlowLayout());

        JLabel lblSearch = new JLabel("Search:");
        txtSearch = new JTextField(20);
        btnSearch = new JButton("Search");

        add(lblSearch);
        add(txtSearch);
        add(btnSearch);

        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnSearchClick();
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    private void btnSearchClick() {
        String contractId = txtSearch.getText().trim();
        if (!contractId.isEmpty()) {
            Contract contract = contractDAO.findContractID(contractId);
            if (contract != null) {
                dispose();
                new ContractInformationFrm(contract).setVisible(true); // Pass contract to next form
            } else {
                JOptionPane.showMessageDialog(this, "Contract not found.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a contract ID.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SearchContractFrm().setVisible(true);
        });
    }
}