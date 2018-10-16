package main.java.model;

import java.sql.*;

public class Order {

    private String goods;
    private String client;
    private int quantity;
    private Date date;

    public Order() {
    }

    public Order(String goods, String client, int quantity, Date date) {
        this.goods = goods;
        this.client = client;
        this.quantity = quantity;
        this.date = date;
    }

        public String getGoods() {
            return goods;
        }

        public void setGoods(String goods) {
            this.goods = goods;
        }

        public String getClient() {
            return client;
        }

        public void setClient(String client) {
            this.client = client;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public void doOrder(String DATABASE, String LOGIN, String PASSWORD, String goods, String client, int quentity) throws ClassNotFoundException, SQLException {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(DATABASE, LOGIN, PASSWORD);
            try (PreparedStatement ps = con.prepareStatement("INSERT INTO orders VALUES(default, " +
                    "(SELECT id FROM goods WHERE model = ?), (SELECT id FROM clients WHERE name = ?), ?, CURRENT_DATE )")) {
                ps.setString(1, goods);
                ps.setString(2, client);
                ps.setInt(3, quentity);
                ps.executeUpdate();
            }
            setQuentity(con, quentity, getQuentity(con, goods), goods);
        }

        public int getQuentity(Connection con, String good) throws SQLException {
            int quentityTable = 0;
            try (PreparedStatement ps = con.prepareStatement("SELECT quantity FROM goods WHERE model = ?")) {
                ps.setString(1, good);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        quentityTable = rs.getInt("quantity");
                    }
                }
            }
            return quentityTable;
        }

        public void setQuentity(Connection con, int quentity, int quentityTable, String good) throws SQLException {
            int setQuent = quentityTable - quentity;
            try (PreparedStatement ps = con.prepareStatement("UPDATE goods SET quantity = ? WHERE model = ?")) {
                ps.setInt(1, setQuent);
                ps.setString(2, good);
                ps.executeUpdate();
            }
        }

}
