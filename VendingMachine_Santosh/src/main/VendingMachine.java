package main;

import java.util.Scanner;

public class VendingMachine {

    public void StartVendingMachine(String start) {
        try {
            VendingMachineUser vendingMachineUser = new VendingMachineUser();
            if (!(start.equalsIgnoreCase("Y") || start.equalsIgnoreCase("N"))) {
                resetMachine();
            }
            while (start.equalsIgnoreCase("Y")) {
                vendingMachineUser.welcomeMessage();
                vendingMachineUser.processCustomerRequest();
                System.out.println("Type Y and press Enterkey to continue or N to exit");
                Scanner scan = new Scanner(System.in);
                start = scan.next();
            }
            if (start.equalsIgnoreCase("N")) {
                System.out.println("Good Bye!!!");
            } else if (!(start.equalsIgnoreCase("N") || start.equalsIgnoreCase("Y"))) {
                resetMachine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//end of StartVendingMachine class

    public void resetMachine() {
        try {
            System.out.println("Type Y and press Enterkey to start the vending machine or N and Enterkey to exit");
            Scanner scan = new Scanner(System.in);
            String start = scan.next();
            if(start.equalsIgnoreCase("")) {
                StartVendingMachine(start);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("Type Y and press Enterkey to start the vending machine or N to exit");
            Scanner scan = new Scanner(System.in);
            String start = scan.next();
            VendingMachine vendingmachine = new VendingMachine();
            if (start.equalsIgnoreCase("N")) {
                System.out.println("Good Bye!!!");

            } else if (start.equalsIgnoreCase("y")) {
                vendingmachine.StartVendingMachine(start);
            } else {
                vendingmachine.resetMachine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }//end of main

}
