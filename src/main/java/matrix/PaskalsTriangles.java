package matrix;
import java.util.*;


public class PaskalsTriangles {
    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
    public static List<Integer> getRow(int rowIndex) {
        // Initialize list with 0s
        List<Integer> row = new ArrayList<>();
        //rowIndex se ek extra value rahegi us row me
        for (int i = 0; i <= rowIndex; i++) {
            row.add(0);
        }

        // First element is always 1
        row.set(0, 1);

        // Build Pascal's Triangle row by row
        for (int i = 1; i <= rowIndex; i++) {
            // Update from right to left to avoid overwriting
            for (int j = i; j > 0; j--) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }

        return row;
    }
}
