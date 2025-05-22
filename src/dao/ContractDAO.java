package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;


import model.Client;
import model.Contract;
import model.Partner;

public class ContractDAO extends DAO {
    public ContractDAO() {
        super();
    }

    public Contract findContractID(String id) {
        Contract contract = null;
        String sql = "SELECT c.*, cl.*, p.* FROM tblContract c " +
                    "LEFT JOIN tblClient cl ON c.client_id = cl.id " +
                    "LEFT JOIN tblPartner p ON c.partner_id = p.id " +
                    "WHERE c.id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // Create Client object
                Client client = new Client();
                client.setId(rs.getString("cl.id"));
                client.setName(rs.getString("cl.name"));
                client.setIdCard(rs.getString("cl.idCard"));
                client.setTel(rs.getString("cl.tel"));
                client.setAddress(rs.getString("cl.address"));
                client.setEmail(rs.getString("cl.email"));
                client.setNote(rs.getString("cl.note"));
                // Add other Client fields as needed (e.g., idcard, tel if available)

                // Create Partner object
                Partner partner = new Partner();
                partner.setId(rs.getString("p.id"));
                partner.setName(rs.getString("p.name"));
                partner.setAddress(rs.getString("p.address"));
                partner.setTel(rs.getString("p.tel"));
                // Add other Partner fields as needed (e.g., contact)

                // Create Contract object
                contract = new Contract(
                    rs.getString("id"),
                    rs.getDate("date"),
                    rs.getString("company"),
                    rs.getInt("loanAmount"),
                    rs.getFloat("interestRate"),
                    rs.getInt("totalAmount"),
                    rs.getString("terms"),
                    rs.getInt("totalAmountPaid"),
                    rs.getInt("remainingDebt"),
                    client,
                    partner
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
            contract = null; // Ensure contract is null in case of error
        }
        return contract;
    }
}
