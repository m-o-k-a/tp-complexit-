package TP1;

import java.io.*;
import java.util.ArrayList;

public class FNCBuilder {
    ArrayList<ArrayList<String>> clauses;
    int nbOfLitteral;
    int nbOfClauses;

    public FNCBuilder(String file) throws Exception {
        clauses = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
        String line = "";
        /* first line - definition*/
        if((line = reader.readLine()) != null) {
            String[] data = line.split(" ");
            if(data.length != 4) throw new Exception("First Line Missing: p cnf X Y");
            nbOfLitteral = Integer.parseInt(data[2]);
            nbOfClauses = Integer.parseInt(data[3]);
        } else { throw new Exception("First Line Missing: p cnf X Y"); }
        /* other lines - clauses */
        for(int i = 0; i<nbOfClauses; i++) {
            if((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                if(!data[data.length-1].equals("0")) throw new Exception("Clause line number "+i+" is badly formatted");
                ArrayList<String> literals = new ArrayList<>();
                for(int j = 0; j<data.length-1; j++) {
                    String literal = data[j];
                    if(Integer.parseInt(literal) > nbOfLitteral) throw new Exception("Clause line number "+i+" has a literal out of range");
                    literals.add(literal);
                }
                clauses.add(literals);
            }
        }
    }

    public boolean isModel(String file) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
        String line = "";
        if((line = reader.readLine()) != null) {
            String[] data = line.split(" ");
            for(int i = 0; i<data.length; i++) {
                if(Integer.parseInt(data[i]) > nbOfLitteral) throw new Exception("literal "+data[i]+" has a literal out of range");
            }
            for(int c = 0; c<clauses.size(); c++) {
                ArrayList<String> clause = clauses.get(c);
                boolean isClauseValid = false;
                for(int i = 0; i<data.length; i++) {
                    if(clause.contains(data[i])) isClauseValid = true;
                }
                if(!isClauseValid) return false;
            }
            return true;
        } else { throw new Exception("File missing a line"); }

    }

    @Override
    public String toString() {
        String str = "";
        for(int i = 0; i<clauses.size(); i++) {
            str += "(";
            ArrayList<String> clause = clauses.get(i);
            for(int j = 0; j<clause.size(); j++) {
                String value = clause.get(j);
                if(value.startsWith("-")) str += "-x"+clause.get(j).substring(1);
                else str += "x"+clause.get(j);
                if(j != clause.size()-1) str += " v ";
            }
            str += ")";
            if(i != clauses.size()-1) str += " ^ ";
        }
        return str;
    }
}
