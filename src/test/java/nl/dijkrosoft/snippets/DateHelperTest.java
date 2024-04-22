/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosoft.snippets;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 *
 * @author dick
 */
public class DateHelperTest {
  
  public DateHelperTest() {
  }

    @Test
    void isMeerderJarig() {

    Calendar dob = Calendar.getInstance();
    dob.set(1973, 6, 8);  // 8 juli 1973
    assertTrue(DateHelper.isMeerderJarig(dob.getTime()),"Dick is niet meerderjarig");
    
    dob.set(2004,7,13);

    assertTrue(DateHelper.isMeerderJarig(dob.getTime()),"Jens is wel meerderjarig");

  }

    @Test
    void nullDob() {
      assertThrows(NullPointerException.class, () -> {
          DateHelper.isMeerderJarig(null);
      });
  }

}
