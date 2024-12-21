package string;

import java.util.*;

public class MinimumIndexSumOfTwoLists {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})));
    }

    public static String[] findRestaurant(String[] list1, String[] list2) {

        List<String> resultantStringList = new ArrayList<>();
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();

        int resultantIndexSum = Integer.MAX_VALUE;

        //list2 ki sari strings ko hm me rakh diya
        HashMap<String, Integer> hm2 = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            hm2.put(list2[i], i);
        }

        //Since there would not be any duplicates values
        for (int i = 0; i < list1.length; i++) {
            if (hm2.containsKey(list1[i])) {
                int indexSum = i + hm2.get(list1[i]);
                minHeap.add(new Pair(indexSum, list1[i]));
            }
        }
        int minIndexSumS = minHeap.peek().indexSum;
        while(minHeap.peek()!= null && minIndexSumS <= minHeap.peek().indexSum){
            resultantStringList.add(minHeap.poll().word);
        }

        int ss= resultantStringList.size();
        String[] res = new String[ss];
        for(int i=0; i<ss; i++){
            res[i] = resultantStringList.get(i);
        }
        return res;
    }

    public static class Pair implements Comparable<Pair> {
        int indexSum;
        String word;
        Pair(int indexSum, String word) {
            this.indexSum = indexSum;
            this.word = word;
        }
        @Override
        public int compareTo(Pair o){
            return this.indexSum - o.indexSum;
        }
    }

}
