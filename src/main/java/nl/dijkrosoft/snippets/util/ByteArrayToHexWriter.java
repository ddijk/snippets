package nl.dijkrosoft.snippets.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Input byte array:
 * Output: Hex representation of byte array
 */
public class ByteArrayToHexWriter {

    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

    public static void main(String[] args) throws IOException {


//        String hexString = new String(Files.readAllBytes(Paths.get("some-file-with-hex-string")));

        String hexString = "ABCD1234";
        System.out.println("From Hex -> byte array -> Hex. Results in the same hex string: "+roundtrip(hexString));
    }

    /**
     * HexString => byte array => HexString2
     * Verify that HexString == HexString2
     * @param hexString
     * @return
     * @throws IOException
     */
    public static boolean roundtrip(String hexString) {

        // make even number, ignore last byte when uneven
        int n = 2 * Math.floorDiv(hexString.length(), 2);

        byte[] data = hexStringToByteArray(hexString.substring(0, n));

        String hex = bytesToHex(data);

        return hex.equalsIgnoreCase(hexString.trim());
    }
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    /* s must be an even-length string. */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }
}
