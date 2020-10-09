package dao;

import model.Edition;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EditionDAO {
    private Connection connection;

    public EditionDAO(Connection connection) {
        this.connection = connection;
    }

}
