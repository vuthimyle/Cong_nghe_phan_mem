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

        return contract;
    }
}

class contractTest {
    public static void main(String[] args) {
        ContractDAO contractDAO = new ContractDAO();
        Contract contract = contractDAO.findContractID("1");
        System.out.println(contract);
    }
}
