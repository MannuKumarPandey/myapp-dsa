package geometry;

public class MaxPointsOnALine {

    public static void main(String[] args) {
        System.out.println(maxPoints(new int[][]{{1, 1}, {2, 2}, {3,3}}));
    }

    public static int maxPoints(int[][] points) {

        int result = Integer.MIN_VALUE;

        int len = points.length;

        if (len == 1) {
            return 1;
        }

        for (int i = 0; i < len - 1; i++) {
            int localMax = 1;
            int prevSlope = Integer.MIN_VALUE;

            for (int j = 0; j < len; j++) {

                if (i != j) {
                    int x1 = points[i][0];
                    int y1 = points[i][1];

                    int x2 = points[j][0];
                    int y2 = points[j][1];
                    int slope = 0;
                    if ((x2 - x1) != 0) {
                        slope = (y2 - y1) / (x2 - x1);
                    }
                    if (prevSlope == Integer.MIN_VALUE) {
                        prevSlope = slope;
                        localMax++;
                        result = Math.max(result, localMax);
                    } else if (slope == prevSlope) {
                        localMax++;
                        result = Math.max(result, localMax);
                    } else {
                        break;
                    }


                }
            }
        }
        return result;
    }
}
