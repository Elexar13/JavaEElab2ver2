package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrintedEditionDAO {

    Connection connection;

    public PrintedEditionDAO() {
        String URL = "jdbc:postgresql://localhost:5432/printed_edition";
        String user = "max";
        String password = "123";
        try {
            connection = DriverManager.getConnection(URL, user, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<SelectObject> findAll(){
        try {
            List<SelectObject> result = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement("select r.name, e.name, d.name from delivery d " +
                    "inner join edition_recipient_delivery erd on d.id = erd.id_delivery " +
                    "inner join recipient r on erd.id_recipient = r.id " +
                    "inner join edition e on erd.id_edition = e.id");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String recipient = rs.getString(1);
                String edition = rs.getString(2);
                String delivery = rs.getString(3);
                result.add(new SelectObject(recipient, edition, delivery));
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}
