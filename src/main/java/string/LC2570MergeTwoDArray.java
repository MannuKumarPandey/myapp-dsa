package string;

import java.util.*;

public class LC2570MergeTwoDArray {

    public static void main(String[] args) {
        int[][] a = mergeArrays(new int[][]{{1, 2}, {2, 3}, {4, 5}}, new int[][]{{1, 4}, {3, 2}, {4, 1}});
        for(int []ss: a){
            System.out.println(Arrays.toString(ss));
        }
    }

    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int[] arr2T : nums2) {
            hm.put(arr2T[0], arr2T[1]);
        }


        for (int[] arr1 : nums1) {
            if(hm.containsKey(arr1[0])){
                int existingV = hm.get(arr1[0]);
                hm.put(arr1[0], hm.get(arr1[0])+arr1[1]);
            }else{
                hm.put(arr1[0], arr1[1]);
            }

        }

        List<Integer> aa = new ArrayList<>();
        for (Map.Entry<Integer, Integer> hh : hm.entrySet()) {
            aa.add(hh.getKey());
        }


        Collections.sort(aa);
        int lenn = aa.size();
        int[][] result = new int[lenn][2];
        for (int i = 0; i < lenn; i++) {
            result[i][0] = aa.get(i);
            result[i][1] = hm.get(aa.get(i));

        }
        return result;

    }
}
