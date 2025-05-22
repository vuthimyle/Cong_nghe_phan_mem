package view.contract;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import dao.BillDAO;
import model.Bill;
import model.Contract;
import dao.ContractDAO;

public class ContractInformationFrm extends JFrame {
    private JLabel lblCompany;
    private JLabel lblClient;
    private JLabel lblPartner;
    private JTable tblBill;
    private Contract contract;
    private BillDAO billDAO;

    public ContractInformationFrm(Contract contract) {
        this.contract = contract;
        billDAO = new BillDAO(); // Initialize DAO
        initComponents();
    }

    private void initComponents() {
        setTitle("Contract Information");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for labels
        JPanel labelPanel = new JPanel(new GridLayout(3, 1));
        lblCompany = new JLabel("Company: " + (contract != null ? contract.getCompany() : ""));
        lblClient = new JLabel("Client: " + (contract != null ? contract.getC().getName() : ""));
        lblPartner = new JLabel("Partner: " + (contract != null ? contract.getP().getName() : ""));
        labelPanel.add(lblCompany);
        labelPanel.add(lblClient);
        labelPanel.add(lblPartner);
        add(labelPanel, BorderLayout.NORTH);

        // Fetch bills from database (simplified, assuming bills are linked by contract ID)
        java.util.List<Bill> bills = billDAO.getBillsByContractId(contract.getId()); // Custom method
        String[] columnNames = {"ID", "Due Date", "Amount Due", "Status"};
        Object[][] data = new Object[bills.size()][4];
        for (int i = 0; i < bills.size(); i++) {
            Bill bill = bills.get(i);
            data[i][0] = bill.getId();
            data[i][1] = bill.getDueDate();
            data[i][2] = bill.getAmountDue();
            data[i][3] = bill.getStatus();
        }
        tblBill = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(tblBill);
        add(scrollPane, BorderLayout.CENTER);

        // Open BillInformationFrm on table row click
        tblBill.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int row = tblBill.rowAtPoint(evt.getPoint());
                if (row >= 0) {
                    String billId = (String) tblBill.getValueAt(row, 0);
                    Bill bill = billDAO.findBillById(billId); // Custom method
                    if (bill != null) {
                        dispose();
                        new BillInformationFrm(bill).setVisible(true);
                    }
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Contract contract = new ContractDAO().findContractID("C001"); // Example contract ID
            new ContractInformationFrm(contract).setVisible(true);
        });
    }
}