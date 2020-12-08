package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemsMap {

    public Map<String, List<Integer>> myMap() {

        List<Integer> cokelist = new ArrayList<Integer>();
        cokelist.add(25);
        cokelist.add(25);

        List<Integer> pepsilist = new ArrayList<Integer>();
        pepsilist.add(35);
        pepsilist.add(10);

        List<Integer> sodalist = new ArrayList<Integer>();
        sodalist.add(45);
        sodalist.add(20);

        Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();
        map.put("Coke", cokelist);
        map.put("Pepsi", pepsilist);
        map.put("Soda", sodalist);
        return map;
    }

}
