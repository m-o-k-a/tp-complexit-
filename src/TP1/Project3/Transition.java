package TP1.Project3;

public class Transition {
    public final Symbol symbolSrc;
    public final State stateSrc;
    public final Symbol symbolDest;
    public final State stateDest;
    public final String direction;

    public Transition(Symbol symbolSrc, State stateSrc, Symbol symbolDest, State stateDest, String direction) {
        this.symbolSrc = symbolSrc;
        this.stateSrc = stateSrc;
        this.symbolDest = symbolDest;
        this.stateDest = stateDest;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "("+stateSrc+"*"+symbolSrc+"->"+stateDest+"*"+symbolDest+"*"+direction+")";
    }

    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof Transition)) { return false; }
        Transition s = (Transition) o;
        return (s.symbolSrc.equals(this.symbolSrc) && s.stateSrc.equals(this.stateSrc));
    }
}
