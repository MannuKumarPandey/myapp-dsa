package MandeepDSA200HARD;

import java.util.HashSet;

class LC391PerfectRectangle {
    public static void main(String[] args) {
        System.out.println(isRectangleCover(new int[][]{{1, 1, 3, 3}, {3, 1, 4, 2}, {3, 2, 4, 4}, {1, 3, 2, 4}, {2, 3, 3, 4}}));
    }

    public static boolean isRectangleCover(int[][] rectangles) {
            //To store the every points in string format
            HashSet<String> hs=new HashSet<>();
            int area=0;
            int minX=Integer.MAX_VALUE;
            int minY=Integer.MAX_VALUE;
            int maxA=Integer.MIN_VALUE;
            int maxB=Integer.MIN_VALUE;

            //Har ek rectangle ke points ko bari bari se iterate kar rahe hai
            for(int i=0;i<rectangles.length;i++){
                int x=rectangles[i][0];
                int y=rectangles[i][1];
                int a=rectangles[i][2];
                int b=rectangles[i][3];

                //calculating the area of this rectangle
                area+=Math.abs(y-b)*Math.abs(x-a);

                //is rectangle ko add karne ke bad bahari rectangle jo hai uske outer points kya honge
                minX=Math.min(minX,x);
                minY=Math.min(minY,y);
                maxA=Math.max(maxA,a);
                maxB=Math.max(maxB,b);

                //taken rectangle ka 4 points
                String bottomLeft=x+":"+y;
                String bottomRight=a+":"+y;
                String topLeft=x+":"+b;
                String topRight=a+":"+b;

                //Key concept yah hai ki
                //agar sare rectangle ek dusre ke sath milkar bahari rectangle banaye tab sirf ek
                //hi bahari rectangle ke charo points one time present hone varna sare points even number
                //of times present hone.


                if(!hs.contains(bottomLeft))
                    hs.add(bottomLeft);
                else
                    hs.remove(bottomLeft);



                if(!hs.contains(bottomRight))
                    hs.add(bottomRight);
                else
                    hs.remove(bottomRight);


                if(!hs.contains(topLeft))
                    hs.add(topLeft);
                else
                    hs.remove(topLeft);


                if(!hs.contains(topRight))
                    hs.add(topRight);
                else
                    hs.remove(topRight);

            }

            //means at lasst only 4 points will be there in hashset and rest all will be removed
            String FullbottomLeft=minX+":"+minY;
            String FullbottomRight=maxA+":"+minY;
            String FulltopLeft=minX+":"+maxB;
            String FulltopRight=maxA+":"+maxB;

            if(!(hs.size()==4) || !hs.contains(FullbottomLeft) || !hs.contains(FullbottomRight) || !hs.contains(FulltopRight) || !hs.contains(FulltopLeft))
                return false;

            //calculate new area with only those 4 corner points and compare with full area
            int newarea=Math.abs(minX-maxA)*Math.abs(minY-maxB);
        return newarea == area;
    }
}
