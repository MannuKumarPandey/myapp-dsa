package math;

public class NumberAPrimeOrnot {
    public static void main(String[] args) {
        int num = 23;
        boolean flag = true;
        for (int i = 2; i < Math.sqrt(num); i++) {
            if (num % i == 0) {
                flag = false;
                break;
            } else {
                continue;
            }
        }

        if (flag) {
            System.out.println("Prime");
        } else {
            System.out.println("Not a prime");
        }

    }

}
