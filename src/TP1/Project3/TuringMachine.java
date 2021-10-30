package TP1.Project3;

import java.io.*;
import java.util.ArrayList;

public class TuringMachine {
    private ArrayList<State> states;
    private ArrayList<Symbol> symbols;
    private Symbol white;
    private State initialState;
    private ArrayList<State> finalStates;
    private ArrayList<Transition> transitions;

    public TuringMachine(String file) throws Exception {
        states = new ArrayList<>();
        symbols = new ArrayList<>();
        finalStates = new ArrayList<>();
        transitions = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File(file)));
        String line = "";
        /* State Line*/
        if((line = reader.readLine()) != null) {
            String[] statesValues = line.split(",");
            for(int i = 0; i<statesValues.length; i++) {
                states.add(new State(statesValues[i]));
            }
        } else { throw new Exception("Missing States Line"); }
        /* Symbols line */
        if((line = reader.readLine()) != null) {
            String[] symbolsValues = line.split(",");
            for(int i = 0; i<symbolsValues.length; i++) {
                symbols.add(new Symbol(symbolsValues[i]));
            }
        } else { throw new Exception("Missing Symbols Line"); }
        /* White Symbol */
        if((line = reader.readLine()) != null) {
            Symbol temp = new Symbol(line);
            if(!symbols.contains(temp)) throw new Exception("White Symbol "+line+" not in Symbol List");
            white = symbols.get(symbols.indexOf(temp));
        } else { throw new Exception("Missing White Symbol Line"); }
        /* Initial State */
        if((line = reader.readLine()) != null) {
            State temp = new State(line);
            if(!states.contains(temp)) throw new Exception("Initial State "+line+" not in State List");
            initialState = states.get(states.indexOf(temp));
        } else { throw new Exception("Missing Initial State Line"); }
        /* Final States */
        if((line = reader.readLine()) != null) {
            String[] finalStatesValues = line.split(",");
            for(int i = 0; i<finalStatesValues.length; i++) {
                State temp = new State(finalStatesValues[i]);
                if(!states.contains(temp)) throw new Exception("Final State "+finalStatesValues[i]+" not in State List");
                finalStates.add(states.get(states.indexOf(temp)));
            }
        } else { throw new Exception("Missing Final State Line"); }
        /* Transitions*/
        while((line = reader.readLine()) != null) {
            String[] newTransitions = line.split(",");
            if(!states.contains(new State(newTransitions[0]))) throw new Exception("State "+newTransitions[0]+" not in State List");
            if(!symbols.contains(new Symbol(newTransitions[1]))) throw new Exception("Symbol "+newTransitions[1]+" not in Symbol List");
            if(!states.contains(new State(newTransitions[2]))) throw new Exception("State "+newTransitions[2]+" not in State List");
            if(!symbols.contains(new Symbol(newTransitions[3]))) throw new Exception("Symbol "+newTransitions[3]+" not in Symbol List");
            Transition transition = new Transition(new Symbol(newTransitions[1]), new State(newTransitions[0]), new Symbol(newTransitions[3]), new State(newTransitions[2]), newTransitions[4]);
            if(transitions.contains(transition)) throw new Exception("Cannot accept non deterministic transitions on: "+transition);
            transitions.add(transition);
        }
        /* Machine Print */
        System.out.println("TURING MACHINE\n---\nStates "+states+"\nSymbols "+symbols+"\nWhite "+white+"\nInitial State "+initialState
        +"\nFinal states "+finalStates+"\nTransitions: "+transitions+"\n---\n");
    }

    public boolean isWord(String w) {
        System.out.println("is "+w+" recognized?");
        State currentState = initialState;
        //Construction du ruban
        Cell firstCell = new Cell(new Symbol(w.substring(0, 1)), white);
        Cell currentCell = firstCell;
        for(int i = 1; i<w.length(); i++) {
            Cell newCell = new Cell(currentCell, new Symbol(w.substring(i, i+1)), white);
            currentCell = newCell;
        }
        currentCell = firstCell;
        //Fin construction ruban
        //Debut iteration
        while(true) {
            if(!symbols.contains(currentCell.symbol)) return false;
            Transition tempTransition = new Transition(currentCell.symbol, currentState, null, null, "NONE");
            if(!transitions.contains(tempTransition)) {
                System.out.println(currentCell.ToString());
                return finalStates.contains(currentState);
            }
            Transition trans = transitions.get(transitions.indexOf(tempTransition));
            currentCell.symbol = trans.symbolDest;
            currentState = trans.stateDest;
            System.out.println("GOTO: "+trans.stateDest);
            switch(trans.direction) {
                case "-1":
                    if(currentCell.leftCell == null) {
                        currentCell.leftCell = new Cell(white, currentCell);
                    }
                    currentCell = currentCell.leftCell;
                    break;
                case "+1":
                    if(currentCell.rightCell == null) {
                        currentCell.rightCell = new Cell(currentCell, white);
                    }
                    currentCell = currentCell.rightCell;
                    break;
            }
        }
    }
}
