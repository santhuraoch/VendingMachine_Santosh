package main;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static main.Validations.IsValid_code;

public class Vendor {
    ItemDetails itemDetails = new ItemDetails();
    ItemsMap pmap = new ItemsMap();
    Scanner scan = new Scanner(System.in);
    Map<String, List<Integer>> mp = pmap.myMap();

    public boolean passCode(String passcode) {
        String password = "9999";
        return password.equals(passcode);
    }

    public void displayInventoryItems() {
        System.out.println("Item Code\tItem Name\tAvailble Quanity");
        System.out.println(mp.get("Coke").get(0) + "\t\tCoke\t\t" + itemDetails.getAvailQuantity(String.valueOf(mp.get("Coke").get(0))));
        System.out.println(mp.get("Pepsi").get(0) + "\t\tPepsi\t\t" + itemDetails.getAvailQuantity(String.valueOf(mp.get("Pepsi").get(0))));
        System.out.println(mp.get("Soda").get(0) + "\t\tSoda\t\t" + itemDetails.getAvailQuantity(String.valueOf(mp.get("Soda").get(0))));

    }

    public void resetVendingMachine() {
        String cont = "Y";
        while (cont.equals("Y")) {
            System.out.println("Enter the code to reset item");
            String code = scan.next();
            if (!(IsValid_code(Integer.parseInt(code)))) {
                System.out.println("Invalid code.Please enter from the above list!!!");
                System.out.println("Enter Y to continue");
                cont = scan.next();
            } else {
                itemDetails.updateQuantity(code, 125);
                System.out.println("Updated Inventory for code " + code + "successfully");
                System.out.println("Type Y and press Enterkey to continue");
                cont = scan.next();
            }
        }


        System.out.println("Machine Reset Succesfully!! all the inventory updated");
    }

}
