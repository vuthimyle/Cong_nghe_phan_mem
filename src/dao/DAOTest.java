package dao;

import java.sql.Connection;
import java.sql.SQLException;

// src/dao/DAOTest.java

public class DAOTest {
    public static void main(String[] args) {
        System.out.println("==== DAO Connection Test Start ====");
        setUp();
        testConnectionNotNull();
        testConnectionIsValid();
        tearDown();
        System.out.println("==== DAO Connection Test End ====");
    }

    public static void setUp() {
        // Khởi tạo DAO để thực hiện kết nối
        new DAO();
    }

    public static void testConnectionNotNull() {
        System.out.print("[testConnectionNotNull] ");
        if (DAO.con != null) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
        }
    }

    public static void testConnectionIsValid() {
        System.out.print("[testConnectionIsValid] ");
        try {
            if (DAO.con != null && !DAO.con.isClosed()) {
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
            }
        } catch (SQLException e) {
            System.out.println("FAIL (Exception: " + e.getMessage() + ")");
        }
    }

    public static void tearDown() {
        try {
            if (DAO.con != null && !DAO.con.isClosed()) {
                DAO.con.close();
            }
            System.out.println("[tearDown] PASS");
        } catch (SQLException e) {
            System.out.println("[tearDown] FAIL (Exception: " + e.getMessage() + ")");
        }
    }
}
