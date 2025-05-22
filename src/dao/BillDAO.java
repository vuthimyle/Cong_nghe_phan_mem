package dao;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Bill;
public class BillDAO extends DAO {
    public BillDAO() {
        super();
    }
    public Bill updateBillAfterPayment(Bill bill, int paymentAmount) {
        String sql = "UPDATE tblBill SET status = ?, paymentDate = ? WHERE id = ?";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // Validate paymentAmount
        if (paymentAmount <= 0 || paymentAmount > bill.getRemainingAmount()) {
            return null;
        }

        try {
            con.setAutoCommit(false);
            PreparedStatement ps = con.prepareStatement(sql);

            // Calculate updated values
            String newStatus = paymentAmount >= bill.getRemainingAmount() ? "PAID" : "PARTIALLY_PAID"; // Update status
            String newPaymentDate = sdf.format(new Date()); // Current date and time

            // Set parameters
            ps.setString(1, newStatus);
            ps.setString(2, newPaymentDate);
            ps.setString(3, bill.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                con.rollback();
                return null;
            }

            // Update the Bill object
            bill.setStatus(newStatus);
            bill.setPaymentDate(new java.sql.Date(new Date().getTime()));

            con.commit();
            return bill;
        } catch (Exception e) {
            try {
                con.rollback();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            return null;
        } finally {
            try {
                con.setAutoCommit(true);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    
}
