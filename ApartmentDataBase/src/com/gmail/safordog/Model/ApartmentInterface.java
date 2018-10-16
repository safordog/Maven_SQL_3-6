package com.gmail.safordog.Model;

import java.sql.SQLException;
import java.util.List;

public interface ApartmentInterface {

        public List<Apartment> getByParameters(String request) throws ClassNotFoundException, SQLException;
        public List<Apartment> getAll() throws ClassNotFoundException, SQLException;

}

