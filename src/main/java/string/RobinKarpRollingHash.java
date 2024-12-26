package string;

public class RobinKarpRollingHash {

    // using as hash factor
    private static final int PRIME = 100;

    public static void main(String[] args) {
        String text = "ababcabcabababd";
        String pattern = "ababd";

        int result = rabinKarp(text, pattern);
        if (result != -1) {
            System.out.println("Pattern found at index: " + result);
        } else {
            System.out.println("Pattern not found.");
        }
    }

    public static int rabinKarp(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();

        // Calculate initial hash for the pattern and the first window of the text
        long patternHash = calculateHash(pattern, patternLength);
        long textHash = calculateHash(text, patternLength);

        for (int i = 0; i <= textLength - patternLength; i++) {
            // If hash values match, check for exact match to avoid collision issues
            if (patternHash == textHash && text.substring(i, i + patternLength).equals(pattern)) {
                return i; // Pattern found at the index i
            }

            // Update the hash for the next window (rolling hash)
            if (i < textLength - patternLength) {
                textHash = recalculateHash(text, i, i + patternLength, textHash, patternLength);
            }
        }

        return -1; // Pattern not found
    }

    // Calculate hash for a string
    private static long calculateHash(String str, int length) {
        long hash = 0;
        for (int i = 0; i < length; i++) {
            hash += str.charAt(i) * Math.pow(PRIME, i);
        }
        return hash;
    }

    // Recalculate hash when sliding the window
    private static long recalculateHash(String str, int oldIndex, int newIndex, long oldHash, int patternLength) {
        long newHash = oldHash - str.charAt(oldIndex); // Remove old char contribution
        newHash /= PRIME; // Shift window
        newHash += str.charAt(newIndex) * Math.pow(PRIME, patternLength - 1); // Add new char contribution
        return newHash;
    }

}
