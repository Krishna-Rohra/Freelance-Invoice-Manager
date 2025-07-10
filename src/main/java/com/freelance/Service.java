package com.freelance;

import java.time.LocalDate;

public class Service {
    private int id;
    private int clientId;
    private String description;
    private int hoursWorked;
    private double ratePerHour;
    private LocalDate dateOfService;
    private double total;

    public Service() {}

    public Service(int clientId, String description, int hoursWorked, double ratePerHour, LocalDate dateOfService) {
        this.clientId = clientId;
        this.description = description;
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
        this.dateOfService = dateOfService;
        this.total = hoursWorked * ratePerHour;
    }

    public Service(int id, int clientId, String description, int hoursWorked, double ratePerHour, LocalDate dateOfService) {
        this(clientId, description, hoursWorked, ratePerHour, dateOfService);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getClientId() {
        return clientId;
    }

    public String getDescription() {
        return description;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public LocalDate getDateOfService() {
        return dateOfService;
    }

    public double getTotal() {
        return total;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "🛠️ Service [id=" + id + ", clientId=" + clientId + ", description=" + description +
                ", hours=" + hoursWorked + ", rate=" + ratePerHour + ", date=" + dateOfService + ", total=" + total + "]";
    }
}
