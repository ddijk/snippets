/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.dijkrosft.snippets;

/**
 *
 * @author dickdijk
 */
public class CharacterSet {

    public static void main(String... args) throws Exception {
        String czech = "Český";
        String japanese = "日本語";

        System.out.println("UTF-8 czech: " + new String(czech.getBytes("UTF-8")));
        System.out.println("UTF-8 japanese: " + new String(japanese.getBytes("UTF-8")));

        System.out.println("ISO-8859-1 czech: " + new String(czech.getBytes("ISO-8859-1")));
        System.out.println("ISO-8859-1 japanese: " + new String(japanese.getBytes("ISO-8859-1")));
    }

}
