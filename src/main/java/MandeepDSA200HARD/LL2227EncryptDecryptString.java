package MandeepDSA200HARD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LL2227EncryptDecryptString {




    public static void main(String[] args) {
        char[] keys = {'a', 'b', 'c'};
        String[] values = {"aa", "bb", "cc"};
        String[] dictionary = {"abc", "cba"};

        Encrypter encrypter = new Encrypter(keys, values, dictionary);
        System.out.println(encrypter.encrypt("abc")); // Output: "aabbcc"
        System.out.println(encrypter.decrypt("aabbcc")); // Output: 1
    }
}

class Encrypter {

    /*
    Encryption:
    Use a direct dictionary lookup to replace each character in the input string with its mapped value.

    Decryption:
    Reverse the mapping to find all characters that map to a given substring.
    Use recursion and memoization to explore all possible splits of the encrypted string and count the valid ways.*/



    private Map<Character, String> encryptionMap;
    private Map<String, Integer> memo;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        encryptionMap = new HashMap<>();
        memo = new HashMap<>();

        // Build the encryption map
        for (int i = 0; i < keys.length; i++) {
            encryptionMap.put(keys[i], values[i]);
        }

        // Preprocess dictionary to count valid decrypted words
        for (String word : dictionary) {
            String encrypted = encrypt(word);
            memo.put(encrypted, memo.getOrDefault(encrypted, 0) + 1);
        }
    }

    public String encrypt(String word1) {
        StringBuilder sb = new StringBuilder();
        for (char c : word1.toCharArray()) {
            if (!encryptionMap.containsKey(c)) return ""; // Invalid character
            sb.append(encryptionMap.get(c));
        }
        return sb.toString();
    }

    public int decrypt(String word2) {
        return memo.getOrDefault(word2, 0);
    }
}


