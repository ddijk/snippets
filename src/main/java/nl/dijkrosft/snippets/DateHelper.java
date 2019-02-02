/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosft.snippets;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author dick
 */
public class DateHelper {


  /**
   * Method bepaalt of iemand met de opgegeven geboortedatum op dit moment meerderjarig is.
   * @param dob geboortedatum
   * @return "true" indien meerderjarig, anders "false"
   */
  public static boolean isMeerderJarig(Date dob) {
    
    Calendar cal = Calendar.getInstance();
    
    cal.add(Calendar.YEAR, -18);

    // below will return null when dob==null
    return cal.getTime().after(dob);
    
  }
  
}
