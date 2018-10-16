package main.java.controller;

import main.java.model.Order;
import main.java.model.TemplateResponce;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "NewOrderServlet", urlPatterns = "/new_order")
public class NewOrderServlet extends HttpServlet {

    private final String DATABASE = "jdbc:mysql://localhost:3306/ordersDB?useUnicode=true" +
            "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final String LOGIN = "root";
    private final String PASSWORD = "Destination6";


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = new Order();
        String goods = req.getParameter("goods");
        String client = req.getParameter("client");
        int quentity = Integer.parseInt(req.getParameter("quentity"));
        try {
            order.doOrder(DATABASE, LOGIN, PASSWORD, goods, client, quentity);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("orderCompleteMessage", "Order complete.");
        req.getRequestDispatcher("template_resp.jsp").forward(req, resp);


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TemplateResponce tr = new TemplateResponce();
        resp.getWriter().print(tr.getFormNewOrderTemplate());
    }

}
