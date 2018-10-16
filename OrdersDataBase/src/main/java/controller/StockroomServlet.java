package main.java.controller;

import main.java.model.TemplateResponce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "StockroomServlet", urlPatterns = "/stockroom")
public class StockroomServlet extends HttpServlet {

    private final String DATABASE = "jdbc:mysql://localhost:3306/ordersDB?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String LOGIN = "root";
    private final String PASSWORD = "Destination6";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            req.setAttribute("stockRoomMessage", getAvailableGoods(DATABASE, LOGIN, PASSWORD));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("template_resp.jsp").forward(req, resp);
    }

    public String getAvailableGoods(String name, String address, String phone) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(DATABASE, LOGIN, PASSWORD);
        String result = "<div id=\"logo\">stockroom</div>";
        try (PreparedStatement ps = con.prepareStatement("SELECT * FROM goods")) {
            try (ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    result += rs.getInt("id") + ". ";
                    result += rs.getString("brand") + " model:";
                    result += rs.getString("model") + "; price: ";
                    result += rs.getDouble("price") + "; quantity: ";
                    result += rs.getInt("quantity") + ". <br>";
                }
            }

        }
        return result;
    }
}
