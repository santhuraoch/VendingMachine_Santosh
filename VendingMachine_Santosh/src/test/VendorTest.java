package test;

import main.Vendor;
import org.junit.Assert;
import org.junit.Test;


public class VendorTest {
	
	Vendor vendor = new Vendor();

  @Test
  public void TC_11_Validate_if_Vendor_Passcode_is_Incorrect() {
	  boolean valid = vendor.passCode("9998");
	  Assert.assertEquals(false,valid);
  }

    @Test
    public void TC_12_Validate_if_Vendor_Passcode_is_correct() {
        boolean valid = vendor.passCode("9999");
        Assert.assertEquals(true, valid );
    }
}
