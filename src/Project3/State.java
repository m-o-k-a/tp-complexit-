public class State {
    public final String value;

    public State(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (!(o instanceof State)) { return false; }
        State s = (State) o;
        return s.value.equals(this.value);
    }
}
