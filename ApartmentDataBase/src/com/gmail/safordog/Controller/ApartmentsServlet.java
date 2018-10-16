package com.gmail.safordog.Controller;

import com.gmail.safordog.Model.Apartment;
import com.gmail.safordog.Model.DataJDBC;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ApartmentsServlet", urlPatterns = "/apartmentsByParameters")
public class ApartmentsServlet extends HttpServlet {

    private String template = "<html><head><title>Apartment</title><link rel=\"stylesheet\" type=\"text/css\" " +
            "href=\"/styles/styles.css\"></head><body><fieldset><div id=\"logo\"><u>Apartment database</u></div>" +
            "<br><br><div id=\"content\">%s</div></fieldset></body></html>";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String area = "";
        if (!req.getParameter("area").equals(null)) {
            area = req.getParameter("area");
        } else {
            area = "";
        }
        String address = req.getParameter("address");
        double square;
        if (!req.getParameter("square").equals("")) {
            square = Double.parseDouble(req.getParameter("square"));
        } else {
            square = 0.0;
        }
        int roomNumbers;
        if (!req.getParameter("room").equals("")) {
            roomNumbers = Integer.parseInt(req.getParameter("room"));
        } else {
            roomNumbers = 0;
        }
        int price;
        if (!req.getParameter("price").equals("")) {
            price = Integer.parseInt(req.getParameter("price"));
        } else {
            price = 0;
        }
        Apartment apart = new Apartment(area, address, square, roomNumbers, price);
        DataJDBC d = new DataJDBC();
        String message = "";
        try {
            for (Apartment temp : d.getByParameters(d.getRequest(apart))) {
                message += temp.getAreaOfCity() + ": " + temp.getAddress() + ": " + temp.getSquare() + ": "
                        + temp.getRoomNumber() + ": " + temp.getPrice() + "<br>";
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().print(String.format(template, message));

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }


}
