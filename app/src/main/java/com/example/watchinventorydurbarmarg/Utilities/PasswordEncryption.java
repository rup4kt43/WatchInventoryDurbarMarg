package com.example.watchinventorydurbarmarg.Utilities;

public class PasswordEncryption {

    public static String Encrypt(String Text, String Key) {
        int i;
        char TEXTCHAR;
        char KEYCHAR;
        String keychar = "";
        String encoded = "";
        for (i = 0; i < Text.length(); i++) {
            TEXTCHAR = Text.charAt(i);
            int keysI = ((i + 1) % Key.length());
            keychar = Key.substring(keysI);
            KEYCHAR = keychar.charAt(0);
            int encrypted = (int) TEXTCHAR ^ (int) KEYCHAR;
            encoded += (char) encrypted;

        }
        return encoded;
    }

}
