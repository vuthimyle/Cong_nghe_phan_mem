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

    public Contract findContractID(int id) {
        Contract contract = new Contract();

        String contract_sql = "SELECT * FROM tblcontract WHERE id = ?";
        try {
            PreparedStatement ps = con.prepareStatement(contract_sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                contract.setId(rs.getInt("id"));
                contract.setDate(rs.getDate("date"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return contract;
    }
}

class contractTest {
    public static void main(String[] args) {
        ContractDAO contractDAO = new ContractDAO();
        Contract contract = contractDAO.findContractID(1);
        System.out.println(contract.getId());
        System.out.println(contract.getDate());
    }
}