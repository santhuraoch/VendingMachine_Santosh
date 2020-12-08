package test;

import main.Validations;
import org.junit.Assert;
import org.junit.Test;


public class ValidationsTest {
	
  @Test
  public void TC07_Validate_if_the_item_code_is_valid() {
	  Validations val = new Validations();
	  boolean is_valid = val.IsValid_code(25);
	  Assert.assertEquals(true, is_valid);
  }

  @Test
  public void TC08_Validate_if_the_item_code_is_invalid() {
	  Validations val = new Validations();
	  boolean is_valid = val.IsValid_code(30);
	  Assert.assertEquals(false, is_valid);
  }
  
  @Test
  public void TC09_Validate_if_the_amount_is_valid() {
	  Validations valid = new Validations();
	  boolean is_valid = valid.Isvalid_amount(1);
	  Assert.assertEquals(true, is_valid);
  }
  
  @Test
  public void TC10_Validate_if_the_amount_is_invalid() {
	  Validations valid = new Validations();
	  boolean is_valid = valid.Isvalid_amount(4);
	  Assert.assertEquals(false, is_valid);
  }
}
