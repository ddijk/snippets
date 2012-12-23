/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosft.snippets;

import java.util.Calendar;
import java.util.Date;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author dick
 */
public class DateHelperTest {
  
  public DateHelperTest() {
  }

  @Test
  public void testIsMeerderJarig() {

    Calendar dob = Calendar.getInstance();
    dob.set(1973, 6, 8);  // 8 juli 1973
    assertTrue("Dick is niet meerderjarig",DateHelper.isMeerderJarig(dob.getTime()));
    
    dob.set(2005,7,13);

    assertFalse("Jens is wel meerderjarig",DateHelper.isMeerderJarig(dob.getTime()));

  }

  @Test(expected=NullPointerException.class)
  public void testNullDob() {
    DateHelper.isMeerderJarig(null);
  }

}
