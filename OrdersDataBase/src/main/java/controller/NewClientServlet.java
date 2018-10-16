package main.java.controller;

import main.java.model.TemplateResponce;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="NewClientServlet", urlPatterns="/new_client")
public class NewClientServlet extends HttpServlet {

    private final String DATABASE = "jdbc:mysql://localhost:3306/ordersDB?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String LOGIN = "root";
    private final String PASSWORD = "Destination6";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        try {
            saveNewClient(name, address, phone);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("addedClientMessage", "New client added!!!");
        req.getRequestDispatcher("template_resp.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateResponce tr = new TemplateResponce();
        resp.getWriter().print(tr.getFormAddClientTemplate());
    }

    public void saveNewClient(String name, String address, String phone) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(DATABASE, LOGIN, PASSWORD);
        try (PreparedStatement ps = con.prepareStatement("INSERT INTO ordersDB.clients VALUE (default, ?, ?, ?)")) {
            ps.setString(1, name);
            ps.setString(2, address);
            ps.setString(3, phone);
            ps.executeUpdate();
        }
    }
}
