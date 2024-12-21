package MandeepDSA200HARD;

public class LC330MinPatcher {

    public static void main(String[] args) {
        System.out.println(minPatches(new int[]{1, 5, 10}, 20));
    }


    public static int minPatches(int[] nums, int n) {

            long missingValue = 1;
            int i = 0;
            int patches = 0;

            while(missingValue <= n){
                if(i < nums.length && nums[i] <= missingValue){
                    missingValue = missingValue+nums[i]; //2
                    i++;
                }else{
                    patches= patches+1;
                    missingValue   = missingValue + missingValue ;
                }
            }
            return patches;
    }
}
