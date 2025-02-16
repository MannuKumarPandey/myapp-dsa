package MandeepDSA200Medium;

public class LC2698PunishmentNumber {


    public static void main(String[] args) {
        System.out.println(punishmentNumber(10));
    }

    public static int punishmentNumber(int n) {
        int result = 0;
        for(int i= 1; i<=n; i++){
            int d = digitSum(i*i);
            if( d == digitSum(i)){
                result += i*i;
            }
        }

        return result;
    }

    public static int digitSum(int n){
        int ds = 0;
        while(n > 0){
            ds = ds+ n%10;
            n = n/10;
        }
        return ds;
    }
}
