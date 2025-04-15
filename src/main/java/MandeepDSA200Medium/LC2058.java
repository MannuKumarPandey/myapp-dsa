package MandeepDSA200Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC2058 {


    public static void main(String[] args) {
        //5,3,1,2,5,1,2
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);


        System.out.println(Arrays.toString(nodesBetweenCriticalPoints(head)));
    }

    public static int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> arr=new ArrayList<>();
        ListNode node=head;

        while(node!=null){
            arr.add(node.val);
            node=node.next;
        }

        List<Integer> cp=new ArrayList<>();
        int n=arr.size();
        for(int i=1; i<=n-2; i++){
            if(arr.get(i-1)>arr.get(i) && arr.get(i+1)>arr.get(i)){
                cp.add(i);
            }
            if(arr.get(i-1)<arr.get(i) && arr.get(i+1)<arr.get(i)){
                cp.add(i);
            }
        }

        int min=Integer.MAX_VALUE;
        int max=-1;
        n = cp.size();
        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;

                min=Math.min(min, Math.abs(cp.get(j)-cp.get(i)));
                max=Math.max(max, Math.abs(cp.get(j)-cp.get(i)));
            }
        }

        return new int[] {min, max};
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}