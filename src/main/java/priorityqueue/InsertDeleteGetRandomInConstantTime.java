package priorityqueue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

public class InsertDeleteGetRandomInConstantTime {
    public static void main(String[] args) {
        RandomizedCollection ran = new RandomizedCollection();
        ran.insert(10);
        ran.insert(20);
        ran.insert(30);
        ran.insert(10);
        ran.remove(10);
        System.out.println(ran.getRandom());
    }

}

class RandomizedCollection {

    HashMap<Integer, PriorityQueue<Integer>> hashMap;
    ArrayList<Integer> arrayList;
    Random randomNum = new Random();

    public RandomizedCollection() {
        hashMap = new HashMap<>();
        arrayList = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!hashMap.containsKey(val)) {
            PriorityQueue<Integer> maxHeapTemp = new PriorityQueue<>((a, b) -> b - a);
            maxHeapTemp.add(arrayList.size());
            arrayList.add(val);
            hashMap.put(val, maxHeapTemp);
            return true;
        } else {
            PriorityQueue<Integer> maxPQ = hashMap.get(val);
            maxPQ.add(arrayList.size());
            arrayList.add(val);
            hashMap.put(val, maxPQ);
            return false;
        }

    }

    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) {
            return false;
        } else {
            PriorityQueue<Integer> maxPQ = hashMap.get(val);
            int index = maxPQ.poll();


            if (maxPQ.size() == 0) {
                hashMap.remove(val);
            } else {
                hashMap.put(val, maxPQ); //newly added with same key but updated pq values
            }



            int lastVal = arrayList.remove(arrayList.size() - 1);
            if (lastVal != val) {
                PriorityQueue<Integer> maxPQ2 = hashMap.get(lastVal);
                maxPQ2.poll();
                maxPQ2.add(index);
                arrayList.set(index, lastVal);//O(1)
                hashMap.put(lastVal, maxPQ2);
            }
            return true;
        }
    }

    public int getRandom() {
        int showMe = randomNum.nextInt(arrayList.size());
        return arrayList.get(showMe);
    }
}