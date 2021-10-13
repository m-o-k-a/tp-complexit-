package Project2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Test {
    public static Graph randomGraphGen(int size, int min_nb,int max_nb){
        int [][] edges = new int[size][size];
        for (int i = 0; i < size; i++){
            for (int j = 0; j<size ; j++){
                edges[i][j] = 0;
            }
        }

        Random random = new Random();

        for (int i = 0; i < size; i++){

            HashSet<Integer> free_set = new HashSet<>();
            int count = 0;
            for (int j = 0; j<size ; j++){
                if (edges[i][j] == 0 && j!=i) free_set.add(j);
            }
            count = (size-1) - free_set.size();

            int gen = (min_nb - count) + random.nextInt(max_nb);
            while (gen>0 && free_set.size()>0){
                int randIndex = random.nextInt(free_set.size());
                randIndex = (int) free_set.toArray()[randIndex];
                edges[i][randIndex] = 1;
                edges[randIndex][i] = 1;
                free_set.remove(randIndex);
                gen--;

            }

        }



        return new Graph(edges);
    }
    public static void printEdges(int[][] edges){
        for (int i = 0; i < edges.length; i++){
            for (int j = 0; j < edges.length ; j++){
                System.out.printf(" " + edges[i][j]);
            }
            System.out.println();
        }
    }

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
        System.out.println(densityZone.findMaxDensityIncomplete_2(test));
        printEdges(test_2);
        printEdges(randomGraphGen(20,0,20).matrix);

    }
}
