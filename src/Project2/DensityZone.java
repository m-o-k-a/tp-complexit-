package Project2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DensityZone {

    /**
     * complexity: theta(|subsummits|^^2)
     * worse case theta(n^^2)
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
                    //System.out.println("summit "+xi+", "+xj+" not linked");
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
                    //System.out.println("summit "+xi+", "+xj+" not linked");
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Complexity : theta(n^^3)
     */
    public ArrayList<Integer> findDensityZone(Graph g, int start_summit) {
        ArrayList<Integer> densityZone = new ArrayList<>();
        densityZone.add(start_summit);
        for(int i = 0; i<g.nmax; i++){ //O(n)
            if(g.matrix[start_summit][i] == 1) {
                densityZone.add(i);
                if (!isDensityZone(g,densityZone)) densityZone.remove(densityZone.indexOf(i)); //O(n^^2)
            }
        }
        return densityZone;
    }


    static ArrayList<int[]> subsets(ArrayList<Integer> set_list) {
        int[] set = new int[set_list.size()];
        for (int a=0;a<set_list.size();a++) set[a] = set_list.get(a);

        int n = set.length;
        ArrayList<int[]> subsets = new ArrayList();

        for (int i = 0; i < (1<<n); i++) {
            ArrayList<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < n; j++){
                if ((i & (1 << j)) > 0){
                    sublist.add(set[j]);
                }
            }
            int[] subset = new int[sublist.size()];
            for (int a=0;a<sublist.size();a++) subset[a] = sublist.get(a);
            subsets.add(subset);
        }
        return subsets;
    }


    /**
     * Complexitée exponentielle : on explore tous les sous-ensemble possible de sommets,
     * soit 2^^n possibilitées, O(2^^n), avec n le nombre de sommets dans g
     * @param g
     * @return
     */
    public ArrayList<Integer> findMaxDensityZone(Graph g){
        ArrayList<Integer> summits = new ArrayList<>();
        for (int i = 0; i < g.nmax ; i++){
            summits.add(i);
        }
        //COMPUTE SUBSETS
        ArrayList<int[]> subsets = subsets(summits);
        int result = 0;
        int max = 0;
        for (int i = subsets.size()-1 ; i>=0 ; i--){
            if (isDensityZone(g, subsets.get(i))){
                if (subsets.get(i).length > max){
                    max = subsets.get(i).length;
                    result = i;
                }
            }
        }

        ArrayList<Integer> r = new ArrayList<>();
        for (int i = 0; i < subsets.get(result).length ; i++){
            r.add(subsets.get(result)[i]);
        }
        System.out.println("Meilleur Zone dense : "+ r.size() + " : " + r);
        return r;

    }

    public ArrayList<Integer> findMaxDensityIncomplete(Graph g) {
        int max = 0;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i< g.nmax ; i++){
            ArrayList<Integer> candidateZone = findDensityZone(g,i);
            if (candidateZone.size()>max){
                max = candidateZone.size();
                result = candidateZone;
            }
        }
        System.out.println(" Zone dense : "+ result.size() + " : " + result);
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
