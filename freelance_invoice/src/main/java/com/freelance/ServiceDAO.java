package com.freelance;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceDAO {

    public void addService(Service s) {
        String sql = "INSERT INTO service (client_id, description, hours_worked, rate_per_hour, date_of_service, total) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, s.getClientId());
            stmt.setString(2, s.getDescription());
            stmt.setInt(3, s.getHoursWorked());
            stmt.setDouble(4, s.getRatePerHour());
            stmt.setDate(5, Date.valueOf(s.getDateOfService()));
            stmt.setDouble(6, s.getTotal());

            stmt.executeUpdate();
            System.out.println(" Service added.");

        } catch (SQLException e) {
            System.err.println("Error adding service: " + e.getMessage());
        }
    }

    public List<Service> getAllServices() {
        List<Service> services = new ArrayList<>();
        String sql = "SELECT * FROM service";

        try (Connection conn = DBUtil.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Service s = new Service(
                    rs.getInt("id"),
                    rs.getInt("client_id"),
                    rs.getString("description"),
                    rs.getInt("hours_worked"),
                    rs.getDouble("rate_per_hour"),
                    rs.getDate("date_of_service").toLocalDate()
                );
                services.add(s);
            }

        } catch (SQLException e) {
            System.err.println("Error fetching services: " + e.getMessage());
        }

        return services;
    }
}
