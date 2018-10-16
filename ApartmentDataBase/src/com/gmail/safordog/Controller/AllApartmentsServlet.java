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

@WebServlet(name = "AllApartmentsServlet", urlPatterns = "/all")
public class AllApartmentsServlet extends HttpServlet {

    private String template = "<html><head><title>Apartment</title><link rel=\"stylesheet\" type=\"text/css\" " +
            "href=\"/styles/styles.css\"></head><body><fieldset><div id=\"logo\"><u>Apartment's database</u></div>" +
            "<br><br><div id=\"content\">%s</div></fieldset></body></html>";

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "";
        DataJDBC d = new DataJDBC();
        try {
            for (Apartment temp : d.getAll()) {
                message += temp.getAreaOfCity() + "; " + temp.getAddress()
                        + "; square: " + temp.getSquare()+ "; rooms: " + temp.getRoomNumber()
                        + "; price: " + temp.getPrice() + "<br>";
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.getWriter().print(String.format(template, message));
    }
}
