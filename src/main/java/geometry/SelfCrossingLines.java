package geometry;

public class SelfCrossingLines {

    public static void main(String[] args) {
        System.out.println(isSelfCrossing(new int[]{2, 2, 1, 1, 4}));
    }


    public static boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        //Agar given points 4 se kam hai means wese path me wo kabhi cross nahi karega
        if (n < 4) {
            return false;
        }

        for (int i = 3; i < n; i++) {
            // Case 1: Crossing the line 4 steps before ya uske similar wali next indexes ek liye bhi
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }

            // Case 2: Overlapping the line 5 steps before ya uske similar wali next indexes ek liye bhi
            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true;
            }

            // Case 3: Crossing the line 6 steps before ya uske similar wali next indexes ek liye bhi
            if (i >= 5 && distance[i - 2] >= distance[i - 4] &&
                    distance[i] + distance[i - 4] >= distance[i - 2] &&
                    distance[i - 1] <= distance[i - 3] &&
                    distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                return true;
            }
        }

        return false;
    }

}
