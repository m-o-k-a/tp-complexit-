package TP1.Project3;

public class Symbol {
    public final String value;

    public Symbol(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof Symbol)) { return false; }
        Symbol s = (Symbol) o;
        return s.value.equals(this.value);
    }
}
