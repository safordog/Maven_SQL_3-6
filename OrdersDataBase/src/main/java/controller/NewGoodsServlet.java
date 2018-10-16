package main.java.controller;

import main.java.model.TemplateResponce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "NewGoodsServlet", urlPatterns = "/new_goods")
public class NewGoodsServlet extends HttpServlet {

    private final String DATABASE = "jdbc:mysql://localhost:3306/ordersDB?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String LOGIN = "root";
    private final String PASSWORD = "Destination6";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String brand = req.getParameter("brand");
        String model = req.getParameter("model");
        Double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        try {
            saveNewGoods(brand, model, price, quantity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("addedGoodsMessage", "New goods added!!!");
        req.getRequestDispatcher("template_resp.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateResponce tr = new TemplateResponce();
        resp.getWriter().print(tr.getFormAddGoodsTemplate());
    }

    public void saveNewGoods(String brand, String model, double price, int quantity) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(DATABASE, LOGIN, PASSWORD);
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO ordersDB.goods VALUE (default, ?, ?, ?, ?)")) {
            ps.setString(1, brand);
            ps.setString(2, model);
            ps.setDouble(3, price);
            ps.setInt(4, quantity);
            ps.executeUpdate();
        }
    }
}
