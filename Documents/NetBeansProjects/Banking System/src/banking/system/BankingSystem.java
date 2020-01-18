/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banking.system;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Pc
 */
public class BankingSystem {

    Scanner in = new Scanner(System.in);
    ArrayList<Client> clients = new ArrayList<>();

    public void displayMenu() {

        System.out.println("Welcome to ALU Banking system");
        System.out.println("Please select your option by writing down its corresponsing number");
        System.out.println("\n\t 1)Add a client \n\t 2)Display a clients\n\t 3)Display basic Clients\n\t 4)Display premium clients\n\t 5)Withdraw Money \n\t 6)Send Money \n\t 7)delete a client\n\t 8)Find a client");
        System.out.println("Selection:");

    }

    public void withdraw() {
        int counter = 0;
        Scanner w = new Scanner(System.in);
        System.out.println("What's your name?");
        String nam = w.nextLine();
        String name = nam.toUpperCase();
        double amount = -22;
        while (amount < 0) {
            System.out.println("How much do you want to withdraw");
            amount = w.nextDouble();
            if (amount < 0) {
                System.out.println("Make sure your amount is not negative");
            }

        }

        for (Client client : clients) {
            if (client.getName().equals(name)) {
                counter = 1;
                if (client.getInitialDeposit() > amount) {
                    double s = client.getInitialDeposit();
                    double a = s - amount;
                    client.setInitialDeposit(a);
                    System.out.println("This is the money that is left on your account after withdrawing" + client.getInitialDeposit());
                } else {
                    System.err.println("You have insufficient balance");
                }
            }

        }
        if (counter == 0) {
            System.err.println("There is no client with that name");
        }
    }

    public void find() {
        Scanner w = new Scanner(System.in);
        System.out.println("what's the name?");
        String nam1 = w.nextLine();
        String name = nam1.toUpperCase();
        int count = 0;
        for (Client client : clients) {
           
            if (client.getName().equals(name)) {
                 count = 1;
                System.out.println(client);
            }

        }
        if (count == 0) {
            System.out.println("That name is not found in the database");
        }
    }

    public void send() {
        Scanner w = new Scanner(System.in);
        System.out.println("what's your name?");
        String nam1 = w.nextLine();
        String name1 = nam1.toUpperCase();
        System.out.println("Who do you want to send the money?");
        String nam2 = w.nextLine();
        String name2 = nam2.toUpperCase();
        double amount = -22;
        while (amount < 0) {
            System.out.println("how much do you want to send");
            amount = w.nextDouble();
            if (amount < 0) {
                System.out.println("Make sure your amount is not negative");
            }
        }
        Client client1 = new Client();
        Client client2 = new Client();

        for (Client client : clients) {

            if (client.getName().equals(name2)) {
                client2 = client;
            }
            if (client.getName().equals(name1)) {
                client1 = client;
            }

        }

        if (clients.contains(client1) && clients.contains(client2)) {
            if (client1.getInitialDeposit() > amount) {
                //double s = client1.getInitialDeposit();
                double a = client1.getInitialDeposit() - amount;
                client1.setInitialDeposit(a);

                double q = client2.getInitialDeposit() + amount;
                client2.setInitialDeposit(q);
                System.out.println("Money sent");

            } else {
                System.out.println("Insuficient amount");
            }
            //System.out.println("Both clients are in the list");
        } else {
            System.out.println("Sender or receiver not found");
        }

    }

    public void delete() {
        Scanner out = new Scanner(System.in);
        System.out.println("What's the name of the client to be removed?");
        String nam = out.nextLine();
        String name = nam.toUpperCase();
        Client client1 = new Client();
        int counter = 0;
        for (Client client : clients) {
            if (client.getName().equals(name)) {
                counter = 1;
                client1 = client;

            }

        }
        clients.remove(client1);
        System.out.println("Success!" + name + " has been removed from the system");
        if (counter == 0) {
            System.out.println("oops, I didn't see any name like that");
        }
    }

    public void question() {
        System.out.println("Enter 9 to proceed or 0 quit");

        Scanner q = new Scanner(System.in);
        switch (q.nextInt()) {

            case 0:
                System.out.println("Thank you and goodbyee");
                break;
            case 9:
                System.out.println("Please proceed.");
                inputMenu();
                break;
            default:
                System.err.println("Unrecognized option");
                break;
        }

    }

    public void inputMenu() {
        displayMenu();

        switch (in.nextInt()) {

            case 1:
                Scanner in = new Scanner(System.in);

                System.out.println("What's your name");
                String nam = in.nextLine();
                String name = nam.toUpperCase();
                System.out.println("What's your age");
                int age = in.nextInt();
                //System.out.println("what's your initial Deposit");

                double initialDeposit = -22;
                while (initialDeposit < 0) {

                    System.out.println("what's your initial Deposit");
                    initialDeposit = in.nextDouble();
                    if (initialDeposit < 0) {
                        System.out.println("Make sure your amount is not negative");
                    }
                }

                if (initialDeposit >= 1000) {
                    clients.add(new PremiumClients(name, age, initialDeposit));
                } else {
                    if (new Client(name, age, initialDeposit) != null) {
                        clients.add(new Client(name, age, initialDeposit));
                    }

                }
                question();
                break;
            case 2:
                System.out.println("These are the clients that we currently have in the database");
                for (Client client : clients) {

                    System.out.println("Name: " + client.getName());
                    System.out.println("Age: " + client.getAge());
                    System.out.println("InitialDeposit: " + client.getInitialDeposit());
                    System.out.println();
                }
                question();
                break;

            case 3:
                System.out.println("Basic client details: \n");
                int count = 0;
                for (Client client : clients) {
                    if (client.getInitialDeposit() < 1000) {
                        count = 1;
                        System.out.println(client);
                    }
                }

                if (count == 0) {
                    System.out.println("No basic clients yet");
                }

                question();
                break;
            case 4:
                System.out.println("Premium client details: \n");
                int counter = 0;
                for (Client client : clients) {

                    if (client.getInitialDeposit() >= 1000) {
                        counter = 1;
                        System.out.println(client);
                    }

                }
                if (counter == 0) {
                    System.err.println("No premium Clients");
                }

                question();
                break;
            case 5:
                withdraw();
                question();
                break;
            case 6:
                send();
                question();
                break;
            case 7:
                delete();
                question();
            case 8:
                find();
                question();
            default:
                System.out.println("Unrecognized option");
                break;
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here
        Client a = new Client("John", 10, 300.0);
        BankingSystem bankingSystem = new BankingSystem();
        bankingSystem.inputMenu();

    }

}
