package MandeepDSA200Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class LC981TimeBasedKeyValueDSDesign {
    public static Map<Integer, Pair> oHM;

    public LC981TimeBasedKeyValueDSDesign() {
        oHM = new HashMap<>();
    }

    public static void main(String[] args) {

        



        LC981TimeBasedKeyValueDSDesign a = new LC981TimeBasedKeyValueDSDesign();
        a.set("love","high",10);
        a.set("love","low",20);

        System.out.println(get("love",5));
        System.out.println(get("love",10));
        System.out.println(get("love",15));
        System.out.println(get("love",20));
        System.out.println(get("love",25));
    }

    public static void set(String key, String value, int timestamp) {
        oHM.put(timestamp, new Pair(key, value));
    }

    public static String get(String key, int timestamp) {
        Integer actualTime = getFloorKey(oHM, timestamp);
        if(actualTime == null){
            return "";
        }else{
            Pair pp = oHM.get(actualTime);
            return pp.value;
        }
    }
    public static Integer getFloorKey(Map<Integer, Pair> map, int target) {
        Integer floorKey = null;

        for (Integer key : map.keySet()) {
            if (key <= target && (floorKey == null || key > floorKey)) {
                floorKey = key;
            }
        }

        return floorKey;
    }


    public static class Pair {
        String key;
        String value;

        Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }


}

//Best solution
class TimeMap {
    HashMap<String, TreeMap<Integer,String>> map;
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key,t->new TreeMap<>()).put(timestamp,value);
    }

    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";
        Map.Entry<Integer,String> entry= map.get(key).floorEntry(timestamp);
        if(entry==null) return "";

        return entry.getValue();

    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
