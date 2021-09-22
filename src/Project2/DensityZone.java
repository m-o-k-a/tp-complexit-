package Project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DensityZone {

    /**
     * complexity: theta(|subsummits|**)
     * @param subSummits
     * @return
     */
    public boolean isDensityZone(Graph g, int[] subSummits) {
        //todo check if all subSummits are inside g
        for(int i =0; i<subSummits.length; i++) {
            for(int j =0; j<subSummits.length; j++) {
                if(i==j) continue;
                int xi = subSummits[i];
                int xj = subSummits[j];
                if(g.matrix[xi][xj] == 0) {
                    System.out.println("summit "+xi+", "+xj+" not linked");
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isDensityZone(Graph g, ArrayList<Integer> subSummits) {
        //todo check if all subSummits are inside g
        for(int i =0; i<subSummits.size(); i++) {
            for(int j =0; j<subSummits.size(); j++) {
                if(i==j) continue;
                int xi = subSummits.get(i);
                int xj = subSummits.get(j);
                if(g.matrix[xi][xj] == 0) {
                    System.out.println("summit "+xi+", "+xj+" not linked");
                    return false;
                }
            }
        }
        return true;
    }

    public ArrayList<Integer> findDensityZone(Graph g, int start_summit) {
        ArrayList<Integer> densityZone = new ArrayList<>();
        densityZone.add(start_summit);
        for(int i = 0; i<g.nmax; i++){
            if(g.matrix[start_summit][i] == 1) {
                densityZone.add(i);
                if (!isDensityZone(g,densityZone)) densityZone.remove(densityZone.indexOf(i));
            }
        }
        return densityZone;
    }

    public ArrayList<Integer> findMaxDensityZone(Graph g){
        int max = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i< g.nmax ; i++){
            ArrayList<Integer> candidateZone = findDensityZone(g,i);
            if (candidateZone.size()>max){
                max = candidateZone.size();
                result = candidateZone;
            }
        }
        return result;
    }
}

/*
        //order by edges number
        HashMap<Integer, ArrayList<Integer>> cardinality_summits = new HashMap<>();
        for (int i = 0; i<g.nmax; i++){
            int card = 0;
            for (int si = 0; si< g.nmax; si++){
                if (g.matrix[i][si] == 1) card++;
            }
            if(cardinality_summits.containsKey(card)) {
                cardinality_summits.get(card).add(i);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                cardinality_summits.put(card, list);
            }
        }
        System.out.println(cardinality_summits);
        return false;
 */
