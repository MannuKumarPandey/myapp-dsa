package sorting;

import java.util.HashSet;

public class SubStringMaxSplit {

    public static void main(String[] args) {
        System.out.println(maxUniqueSplit("wwwzfvedwfvhsww"));
    }

    public static int maxUniqueSplit(String s) {
        int len = s.length();
        int i = 0;
        int temp = 0;
        HashSet<String> hs = new HashSet<String>();

        while (i < len && temp < len - 1) {
            if (hs.contains(s.substring(i, temp + 1))) {
                while(temp < len) {
                    temp++;
                    if (hs.contains(s.substring(i, temp + 1))) {
                        temp++;
                    }else {
                        break;
                    }
                }
                hs.add(s.substring(i, temp + 1));
                i++;
                temp = temp+1;

            } else {
                hs.add(s.substring(i, temp + 1));
                i++;
                temp = temp+1;
            }
        }
        if (!hs.contains(s.substring(temp))) {
            hs.add(s.substring(i, temp + 1));
        }

        return hs.size();
    }

}
