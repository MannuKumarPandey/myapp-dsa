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

    HashMap<Integer, PriorityQueue<Integer>> map;
    ArrayList<Integer> list;
    Random randomNum = new Random();

    public RandomizedCollection() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            PriorityQueue<Integer> maxPQ = new PriorityQueue<>((a, b) -> b - a);
            maxPQ.add(list.size());
            list.add(val);
            map.put(val, maxPQ);
            return true;
        } else {
            PriorityQueue<Integer> maxPQ = map.get(val);
            maxPQ.add(list.size());
            list.add(val);
            map.put(val, maxPQ);
            return false;
        }

    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        } else {
            PriorityQueue<Integer> maxPQ = map.get(val);
            int index = maxPQ.poll();


            if (maxPQ.size() == 0) {
                map.remove(val);
            } else {
                map.put(val, maxPQ); //newly added with same key but updated pq values
            }



            int lastVal = list.remove(list.size() - 1);
            if (lastVal != val) {
                PriorityQueue<Integer> maxPQ2 = map.get(lastVal);
                maxPQ2.poll();
                maxPQ2.add(index);
                list.set(index, lastVal);//O(1)
                map.put(lastVal, maxPQ2);
            }
            return true;
        }
    }

    public int getRandom() {
        int showMe = randomNum.nextInt(list.size());
        return list.get(showMe);
    }
}