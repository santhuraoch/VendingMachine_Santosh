package test;

import main.ItemDetails;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ItemCostTest {
    @Test
    public void TC_01_Validate_if_the_cost_of_the_item_is_correctly_displayed() {
        ItemDetails itemDetails = new ItemDetails();
        List<Integer> itemList;
        itemList = itemDetails.GetDetails(25);
        Assert.assertEquals(25, itemList.get(1).intValue());
    }

    @Test
    public void TC_02_Validate_if_the_cost_of_the_item_is_incorrectly_displayed() {
        ItemDetails itemDetails = new ItemDetails();
        List<Integer> itemList;
        itemList = itemDetails.GetDetails(35);
        Assert.assertNotEquals(16, itemList.get(1).intValue());
    }

}
