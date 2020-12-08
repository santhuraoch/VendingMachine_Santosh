package main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ItemDetails {
    ItemsMap map = new ItemsMap();
    Map<String, List<Integer>> mp = map.myMap();
    List<Integer> list = new ArrayList<Integer>();
    InputStream inputStream;
    Properties properties = new Properties();
    String Inventory_propFileName = "Inventory.properties";

    public List<Integer> GetDetails(int code) {

        Set<String> keys = mp.keySet();
        for (Object key : keys) {
            if (code == 25) {
                if (mp.containsKey("Coke")) {
                    List<Integer> cokelist = mp.get("Coke");
                    return cokelist;
                }
            }
            if (code == 45) {
                if (mp.containsKey("Soda")) {
                    return mp.get("Soda");
                }
            }
            if (code == 35) {
                if (mp.containsKey("Pepsi")) {
                    return mp.get("Pepsi");
                }
            }
        }
        return list;
    }

    public int getMaxQuantity(String code) {

        int max_quantity = 0;


        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(Inventory_propFileName);
            properties.load(inputStream);
            String property_name = code + "_max_quantity";
            max_quantity = Integer.parseInt(properties.getProperty(property_name));
            inputStream.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

        return max_quantity;
    }

    public int getAvailQuantity(String code) {
        int avail_quantity = 0;
        try {

            inputStream = getClass().getClassLoader().getResourceAsStream(Inventory_propFileName);
            properties.load(inputStream);
            String property_name = code + "_available_quantity";
            avail_quantity = Integer.parseInt(properties.getProperty(property_name));

            inputStream.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return avail_quantity;
    }

    public int resetQuantity(String code, int qty) { //This is for supplier
        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(Inventory_propFileName);
            properties.load(inputStream);
            inputStream.close();
            String property_name = code + "_max_quantity";


            OutputStream out = new FileOutputStream("ItemInventory_propFileName");
            properties.setProperty(property_name, String.valueOf(qty));
            properties.store(out, null);

            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }
        return qty;
    }

    public void updateQuantity(String code, int qty) { //This is for supplier

        try {
            inputStream = getClass().getClassLoader().getResourceAsStream(Inventory_propFileName);
            properties.load(inputStream);
            inputStream.close();
            String property_name = code + "_available_quantity";

            OutputStream out = new FileOutputStream("./src/Inventory.properties");
            properties.setProperty(property_name, String.valueOf(qty));
            properties.store(out, null);

            out.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

    }
}
