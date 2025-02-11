package MandeepDSA200HARD;

import java.util.HashSet;

public class LC2306 {
    public static void main(String[] args) {
        System.out.println(distinctNames(new String[]{"coffee","donuts","time","toffee"}));
    }
    public static boolean isValid(String aa, String bb,HashSet<String> set){
        StringBuilder a=new StringBuilder(aa);
        StringBuilder b=new StringBuilder(bb);
        char a0=a.charAt(0);
        char b0=b.charAt(0);
        a.setCharAt(0,b0);
        b.setCharAt(0,a0);

        if(set.contains(a.toString()) || set.contains(b.toString())){ // .toString() change !!!!!!!!!!!!!!
            return false;
        }
        else{
            return true;
        }


    }
    public static long distinctNames(String[] ideas) {
        HashSet<String> hss = new HashSet<>();
        int n=ideas.length;
        HashSet<String> set=new HashSet<>();
        for(int i=0;i <n; i++){
            set.add(ideas[i]);
        }
        for(int i=0; i<n; i++){
            for(int j=0;j<n; j++){
                if(i==j) continue;
                if(!hss.contains(i+"-"+j) && !hss.contains(j+"-"+i) && isValid(ideas[i],ideas[j],set)){
                    hss.add(i+"-"+j);
                    hss.add(j+"-"+i);
                }
            }
        }

        return hss.size();
    }
}
