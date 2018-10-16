package com.gmail.safordog.Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Class.forName;

public class DataJDBC implements ApartmentInterface {

    private String host = "jdbc:postgresql://localhost/postgres";
    private String user = "postgres";
    private String password = "Destination6";

    public DataJDBC() {
    }

    @Override
    public List<Apartment> getByParameters(String request) throws ClassNotFoundException, SQLException {
        forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(host, user, password);
        PreparedStatement ps;
        List<Apartment> info = new ArrayList<>();
        if (!request.equals("SELECT * FROM apartments ")) {
            ps = con.prepareStatement(request);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Apartment temp = new Apartment();
                    temp.setAreaOfCity(rs.getString("areaOfCity"));
                    temp.setAddress(rs.getString("address"));
                    temp.setSquare(rs.getDouble("square"));
                    temp.setRoomNumber(rs.getInt("rooms"));
                    temp.setPrice(rs.getInt("price"));
                    info.add(temp);
                }
            }
            ps.close();
        }
        return info;
    }

    public String getRequest(Apartment apart) {
        String metaRequest = "";
        if (!apart.getAreaOfCity().equals("")) {
            metaRequest = "areaOfCity = " + apart.getAreaOfCity() + ";";
        }
        if (apart.getSquare() != 0.0) {
            metaRequest += "square = " + apart.getSquare() + ";";
        }
        if (apart.getRoomNumber() != 0) {
            metaRequest += "rooms = " + apart.getRoomNumber() + ";";
        }
        if (apart.getPrice() != 0) {
            metaRequest += "price = " + apart.getPrice() + ";";
        }
        String request = "SELECT * FROM apartments ";
        if (!metaRequest.equals("") ) {
            String[] array = metaRequest.split(";");
            for (int i = 0; i < array.length; i++) {
                if (i < 1) {
                    request += "WHERE " + array[i];
                } else {
                    request += " AND " + array[i];
                }
            }
        }
        return request;
    }

    @Override
    public List<Apartment> getAll() throws ClassNotFoundException, SQLException {
        List<Apartment> info = new ArrayList<>();
        forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection(host, user, password);
        try (PreparedStatement ps = con.prepareStatement("SELECT areaofcity, address, square, rooms, price FROM apartments")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Apartment temp = new Apartment();
                    temp.setAreaOfCity(rs.getString("areaOfCity"));
                    temp.setAddress(rs.getString("address"));
                    temp.setSquare(rs.getDouble("square"));
                    temp.setRoomNumber(rs.getInt("rooms"));
                    temp.setPrice(rs.getInt("price"));
                    info.add(temp);
                }
            }
        }
        return info;
    }

}
