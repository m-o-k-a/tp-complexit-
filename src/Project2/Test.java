package Project2;

public class Test {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1},
                {0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 0},
                {0, 1, 1, 1, 0, 1},
                {0, 1, 1, 0, 1, 0}
        };

        int[][] test_2 = {
               //0,1,2,3,4,5,6,7,8
                {0,1,0,0,0,0,0,0,0},
                {1,0,1,0,0,0,0,0,0},
                {0,1,0,1,0,0,1,0,0},
                {0,0,1,0,1,0,1,0,0},
                {0,0,0,1,0,1,0,0,0},
                {0,0,0,0,1,0,0,0,0},
                {0,0,1,1,0,0,0,1,0},
                {0,0,0,0,0,0,1,0,1},
                {0,0,0,0,0,0,0,1,0},};

        Graph graph = new Graph(edges);
        Graph test = new Graph(test_2);
        DensityZone densityZone = new DensityZone();
        System.out.println(densityZone.isDensityZone(graph, new int[]{1, 2, 4, 5}));
        System.out.println(densityZone.isDensityZone(graph, new int[]{0, 1, 4, 3}));
        System.out.println(densityZone.findDensityZone(graph, 4));
        System.out.println(densityZone.findMaxDensityZone(test));

    }
}
