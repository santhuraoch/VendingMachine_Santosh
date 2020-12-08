package main;

import java.util.List;

import java.util.Scanner;

import static main.Validations.IsValid_code;
import static main.Validations.Isvalid_amount;

public class VendingMachineUser {
    private ItemDetails details = new ItemDetails();

    public void welcomeMessage() {
        try {
            System.out.println("\t  VENDING MACHINE\n");
            System.out.println("Item \t Code \t cost \nCoke \t 25 \t 25\nPepsi \t 35 \t 10\nSoda \t 45 \t 20\nVendor \t 99 \t NA\n***Only 1,5,10,25 Coins accepted***\n");
            System.out.println("Please enter the Product code:");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void processCustomerRequest() {
        try {
            Scanner scan = new Scanner(System.in);
            ItemDetails details = new ItemDetails();
            int code, amt, itemCost, itemcode;
            code = amt = 0;
            String code1 = "";
            VendingMachineUser vendingMachineUser = new VendingMachineUser();
            try {
                code = Integer.parseInt(scan.next());
                if (!(IsValid_code(code))) {
                    System.out.println("Invalid code.Please enter valid Item code from the available list");
                    code = 0;
                }
            } catch (Exception e) {
                System.out.println("Error, please try again with valid input !");
                VendingMachine machine = new VendingMachine();
                machine.resetMachine();
            }
            if (!code1.equals("")) {
                VendingMachine machine = new VendingMachine();
                machine.resetMachine();
            }
            if (code == 99) {
                Vendor vendor = new Vendor();
                System.out.println("Please enter passcode to reset");
                String passcode = scan.next();
                if (!vendor.passCode(passcode)) {
                    System.out.println("Invalid passcode!! Please try Again");
                    passcode = "";
                } else {
                    System.out.println("Updating inventory.. Please Wait! \n");
                    System.out.println("Available Inventory\n");
                    vendor.displayInventoryItems();
                    vendor.resetVendingMachine();
                }
            } else if (code == 25 || code == 45 || code == 35) {
                List<Integer> itemDetails = details.GetDetails(code);
                itemcode = itemDetails.get(0);
                itemCost = itemDetails.get(1);
                System.out.println("Please insert/enter coins to purchase the item from the above list");
                amt = amt + Integer.parseInt(scan.next());
                if (!(Isvalid_amount(amt))) {
                    System.out.println("only 1,5,10,25 coins are acceptable.Please insert correct coin");
                    amt = 0;
                }

                if (itemCost - amt == 0) {
                    ifAmountIsZero(scan, code, itemCost);

                } else if (itemCost - amt < 0) {
                    ifAmountLessThanValue(scan, itemCost, itemcode, amt);
                }
                while (itemCost - amt > 0) {
                    int amountDue = itemCost - amt;
                    System.out.println("Please enter remaining denomination of " + amountDue);
                    int amt1 = Integer.parseInt(scan.next());
                    if (Isvalid_amount(amt1)) {
                        amt = amt + amt1;
                    } else {
                        System.out.println("only 1,5,10,25 coins are acceptable.Please insert correct coin");
                    }
                    amountDue = vendingMachineUser.calculateChange(amt, code);
                    if (amountDue == 0) {
                        ifAmountIsZero(scan, code, itemCost);
                    } else if (amountDue < 0) {
                        ifAmountLessThanValue(scan, amountDue, code, amt);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void ifAmountIsZero(Scanner scan, int code, int itemcost) {
        System.out.println("Type Y(YES) to confirm purchase or X(Cancel) to cancel and Enter key ");
        String confirm = scan.next();
        if (confirm.equalsIgnoreCase("Y")) {
            int avail_qty = details.getAvailQuantity(String.valueOf(code));
            details.updateQuantity(String.valueOf(code), avail_qty - 1);
            System.out.println("Please collect your item, Thank you !");
        } else if (confirm.equalsIgnoreCase("X"))
            System.out.println("Please collect refund of " + itemcost);

    }

    public void ifAmountLessThanValue(Scanner scan, int p, int code, int amt) {
        System.out.println("Type Y(YES) to confirm purchase or X(Cancel) to cancel and Enter key ");
        String confirm = scan.next();
        if (confirm.equalsIgnoreCase("Y")) {
            int cost = p * (-1);
            int avail_qty = details.getAvailQuantity(String.valueOf(code));
            details.updateQuantity(String.valueOf(code), avail_qty - 1);
            System.out.println("Please Collect your item and change of \t" + cost);
        } else if (confirm.equalsIgnoreCase("X"))
            System.out.println("Please Collect your refund of " + amt);
    }

    public int calculateChange(int amt, int code) {
        List<Integer> Itemdetails = details.GetDetails(code);
        return Itemdetails.get(1) - amt;
    }

}
