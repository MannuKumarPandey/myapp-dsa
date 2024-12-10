package MandeepDSA200HARD;

public class L154FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{2, 2, 2, 0, 1}));
    }

    public static int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;

            if (nums[start] > nums[mid]) {
                // Matlab left part wala unsoredt hai so high ko mid tak lao
                //qki originally arr[start] < arr[mid] hona chahiye tha
                end = mid;
            } else if (nums[mid] > nums[end]) {
                // Matlab right wala unsorted hai isliye low ko mid+1 lao
                //qki originally arr[mid] < arr[end] hona chahiye tha
                start = mid + 1;
            } else { // Matlab na hi mid start se chhota hai aur na hi end mid se chhota hai matlab
                // kuch esa hua hai ki
                // same index par start and end pahunch gaye hai isliye high-- kare so
                //that ki loop break ho jaye

                end--;
            }
        }

        // finally jaha start point karega wahi minimum value ka index hai

        return nums[start];
    }

}
