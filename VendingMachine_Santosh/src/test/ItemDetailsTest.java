package test;

import main.ItemDetails;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ItemDetailsTest {

  @Test
  public void TC_03_Validate_if_the_item_code_entered_doesnot_exist() {
	  ItemDetails itemDetails= new ItemDetails();
	  List<Integer> itemList;
	  itemList = itemDetails.GetDetails(88);
	  Assert.assertEquals(true, itemList.isEmpty());
  }

  @Test
  public void TC_04_Validate_if_the_item_code_entered_exists() {
	  ItemDetails itemDetails= new ItemDetails();
	  List<Integer> itemList;
	  itemList = itemDetails.GetDetails(35);
	  Assert.assertEquals(true, itemList.containsAll(itemList));
	  Assert.assertEquals(35, itemList.get(0).intValue());
  }

  @Test
  public void TC_05_Validate_if_the_item_quantity_is_correct() {
	  ItemDetails itemDetails= new ItemDetails();
	  int availQuantity = itemDetails.getAvailQuantity("45");
	  int availQtyFromPropFile = 250;
	  Assert.assertEquals(availQuantity,availQtyFromPropFile);
  }

  @Test
  public void TC_06_Validate_if_the_item_quantity_is_incorrect() {
	  ItemDetails itemDetails= new ItemDetails();
	  int availQuantity = itemDetails.getAvailQuantity("25");
	  int availQtyFromPropFile = 100;
	  Assert.assertNotEquals(availQuantity,availQtyFromPropFile);
  }
}
