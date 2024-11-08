package string;

public class maximumScoreAfterSplit {

    public static void main(String[] args) {
        System.out.println(maxScore("00"));
    }


    public static int maxScore(String s) {
        int result = Integer.MIN_VALUE;
        int len = s.length()-1;

        int cc11 = count1(s, 0, len);
        if(cc11 == len+1){
            result = Math.max(result, cc11-1);
        }

        int cc00 = count0(s, 0, len);
        if(cc00 == len+1){
            result = Math.max(result, cc00-1);
        }

        for(int i = 0; i<=len; i++){
            int getCount = count0(s,0,i)+count1(s,i+1,len);
            if(getCount != len+1){
                result = Math.max(result, getCount);
            }
        }
        return result;
    }

    public static int count1(String s, int start , int end){
        int c1 = 0;
        for(int i = start; i<=end; i++){
            if(s.charAt(i) == '1'){
                c1++;
            }
        }
        return c1;
    }
    public static int count0(String s, int start , int end){
        int c0 = 0;
        for(int i = start; i<=end; i++){
            if(s.charAt(i) == '0'){
                c0++;
            }
        }
        return c0;
    }
}
