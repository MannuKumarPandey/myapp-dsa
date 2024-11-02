package graph;

import java.util.ArrayList;
import java.util.List;

/*
Rank : ka matlab yah hai ki kisi bhi node ka uske sabse dur ke leaf nodes se duri.
Ultimate Parent :  Kisi bhi node ka sabse topmost parent node Means topmost node or the root node

In order to implement Union by rank, we basically need two arrays of size N(no. of nodes).
One is the rank and the other one is the parent.
The rank array basically stores the rank of each node and the parent array stores the ultimate parent for each node.

Finally, we will connect the ultimate parent with a smaller rank to the other ultimate parent with a larger rank.
But if the ranks are equal, we can connect any parent to the other parent and we will increase the rank by one for the parent node to whom we have connected the other one.


Let’s see why we need to find the ultimate parents.

After union by rank operations, if we are asked (refer to the above picture) if node 5 and node 7 belong to the same component or not, the answer must be yes.
If we carefully look at their immediate parents, they are not the same but if we consider their ultimate parents they are the same i.e. node 4.
So, we can determine the answer by considering the ultimate parent. That is why we need to find the ultimate parent.

*/

class DisjointSet {
    List<Integer> rank = new ArrayList<>(); // Kisi bhi node ki rank matlab current node se sabse dur wale leaf node ki
    // duri
    List<Integer> parent = new ArrayList<>();// Kisi bhi node ki ultimate parent rakhne ki storage

    public DisjointSet(int numberOfvertices) {
        for (int i = 0; i <= numberOfvertices; i++) {
            rank.add(0);// Suru me sare nodes ke rank 0 rakh diye
            parent.add(i);// and sare nodes ka ultimate parents unko khud bana diye
        }
    }

    public int findUltimateParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int ulp = findUltimateParent(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }

    public void unionByRank(int u, int v) { // Matlab node u ko node v ke sath isake Rank ke basis par jodiye : Rule yah rahega ki chhote rank me bade wale ko jodna hai
        int ulp_u = findUltimateParent(u); // Pahle u ka ultimate parent nikal lijiye
        int ulp_v = findUltimateParent(v); // v ka ultimate parent nikal lijiye
        if (ulp_u == ulp_v) // agar dono ka ultimate parent same hai matlab dono nodes same components me already jude hai no no need to add them again
            return;


        if (rank.get(ulp_u) < rank.get(ulp_v)) { // agar u ke ultimate parent ka rank chhota hai v ke ultimate parent se to u ko v ka parent banaiye matlab v ko u ke ultimate parent ke niche jod dijiye
            parent.set(ulp_u, ulp_v);
        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {// agar v ke ultimate parent ka rank chhota hai u ke ultimate parent se to v ko u ka parent banaiye matlab u ko v ke ultimate parent ke niche jod dijiye
            parent.set(ulp_v, ulp_u);
        } else {  // agar dono ke ultimate parents ke rank barabar hai to kisi ek ko kisi ek ke ultimate parent ke niche jod kar respective rank sirf ek se bada dena hai
            parent.set(ulp_v, ulp_u);
            int rankU = rank.get(ulp_u);
            rank.set(ulp_u, rankU + 1);
        }
    }

}

class DisjointSetDataStructure {
    public static void main(String[] args) {
        int numberOfvertices = 7;
        DisjointSet ds = new DisjointSet(numberOfvertices);
        ds.unionByRank(1, 2);
        ds.unionByRank(2, 3);
        ds.unionByRank(4, 5);
        ds.unionByRank(6, 7);
        ds.unionByRank(5, 6);

        // if 3 and 7 same or not
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");

        ds.unionByRank(3, 7);
        if (ds.findUltimateParent(3) == ds.findUltimateParent(7)) {
            System.out.println("Same");
        } else
            System.out.println("Not Same");
    }
}
