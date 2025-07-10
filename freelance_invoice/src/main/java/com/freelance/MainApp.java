package com.freelance;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ClientDAO clientDAO = new ClientDAO();
        ServiceDAO serviceDAO = new ServiceDAO();

        System.out.println(" Welcome to Freelance Invoice Manager");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1️.  Add a client");
            System.out.println("2️.  Show all clients");
            System.out.println("3️.  Add a service");
            System.out.println("4️.  Show all services");
            System.out.println("5️.  Exit");
            System.out.print(" Option: ");
            int choice = sc.nextInt();
            sc.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Client name: ");
                    String name = sc.nextLine();
                    System.out.print("Client email: ");
                    String email = sc.nextLine();
                    clientDAO.addClient(new Client(name, email));
                    break;

                case 2:
                    List<Client> clients = clientDAO.getAllClients();
                    clients.forEach(System.out::println);
                    break;

                case 3:
                    System.out.print("Client ID: ");
                    int cid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Work description: ");
                    String desc = sc.nextLine();
                    System.out.print("Hours worked: ");
                    int hours = sc.nextInt();
                    System.out.print("Rate per hour: ");
                    double rate = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Date (yyyy-mm-dd): ");
                    String date = sc.nextLine();
                    LocalDate parsedDate = LocalDate.parse(date);

                    serviceDAO.addService(new Service(cid, desc, hours, rate, parsedDate));
                    break;

                case 4:
                    List<Service> services = serviceDAO.getAllServices();
                    services.forEach(System.out::println);
                    break;

                case 5:
                    System.out.println("Bye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
// This is the main application class for the Freelance Invoice Manager.
