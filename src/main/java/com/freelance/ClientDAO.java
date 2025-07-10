package com.freelance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {

    public void addClient(Client client) {
        String sql = "INSERT INTO client(name, email) VALUES (?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, client.getName());
            stmt.setString(2, client.getEmail());
            stmt.executeUpdate();

            System.out.println("✅ Client added.");

        } catch (SQLException e) {
            System.err.println("Error adding client: " + e.getMessage());
        }
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM client";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Client c = new Client(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email")
                );
                clients.add(c);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching clients: " + e.getMessage());
        }

        return clients;
    }

    public Client getClientById(int id) {
        String sql = "SELECT * FROM client WHERE id = ?";
        Client client = null;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                client = new Client(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("email")
                );
            }

        } catch (SQLException e) {
            System.err.println("Error finding client: " + e.getMessage());
        }

        return client;
    }
}
