package dao;

import java.nio.charset.CharsetDecoder;
import java.nio.charset.StandardCharsets;
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

    public List<Integer> findID(){
        try {
            List<Integer> result = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement("select id " +
                                                                "from recipient_edition_delivery");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                result.add(id);
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
    
    public List<SelectObject> findAll(){
        try {
            List<SelectObject> result = new ArrayList<>();
            PreparedStatement ps = connection.prepareStatement("SELECT * " +
                                                                "FROM recipient_edition_delivery");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String recipient = rs.getString(2);
                String edition = rs.getString(3);
                String delivery = rs.getString(4);
                result.add(new SelectObject(id, recipient, edition, delivery));
            }
            return result;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void update(int id, String newRecipientName, String newEditionName, String newDeliveryName){

        if (newRecipientName != null) {
            updateTable(id, "recipient", newRecipientName);
        }
        if (newEditionName != null) {
            updateTable(id, "edition", newEditionName);
        }
        if (newDeliveryName != null) {
            updateTable(id, "delivery", newDeliveryName);
        }
    }

    private void updateTable(int id, String tableName, String newName){
        try {

                PreparedStatement ps = connection.prepareStatement("UPDATE recipient_edition_delivery " +
                                                                        "SET "+ tableName + " = ? " +
                                                                        "WHERE id = ?");
                ps.setString(1, newName);
                ps.setInt(2, id);
                ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public void add(String newRecipientName, String newEditionName, String newDeliveryName) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO recipient_edition_delivery (recipient, edition, delivery) " +
                                                                    "VALUES (?, ?, ?)");
            ps.setString(1, newRecipientName);
            ps.setString(2, newEditionName);
            ps.setString(3, newDeliveryName);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM recipient_edition_delivery " +
                                                                    "WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
