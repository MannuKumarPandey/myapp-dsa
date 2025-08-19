package arrays;
import java.util.*;

public class PrintConsecutiveNumbersInStringDetails {
    public static void main(String[] args) {
        String inputArr[] = {"1", "2","3", "4", "5","9", "10", "a", "11", "12", "6", "7","8","4","@", "-5", "-7","-3", "-2","-1"};

        int i = 0;
        int len = inputArr.length;

        while (i < len) {
            List<Integer> sequence = new ArrayList<>();

            // Try parse starting number
            int prev;
            try {
                prev = Integer.parseInt(inputArr[i]);
                sequence.add(prev);
            } catch (Exception e) {
                i++;
                continue;
            }

            int j = i + 1;
            while (j < len) {
                try {
                    int current = Integer.parseInt(inputArr[j]);
                    if (current == prev + 1) {
                        sequence.add(current);
                        prev = current;
                        j++;
                    } else {
                        break; // not consecutive
                    }
                } catch (Exception e) {
                    break; // noise encountered
                }
            }

            if (sequence.size() > 1) {
                // Print nicely
                for (int num : sequence) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }

            i = j; // move outer loop to continue after this block
        }
    }
}

