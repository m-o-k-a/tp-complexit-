package TP1.Project3;

public class Cell {
    public Symbol symbol;
    public Cell leftCell;
    public Cell rightCell;

    public Cell(Cell leftCell, Symbol symbol, Cell rightCell) {
        this.symbol = symbol;
        this.leftCell = leftCell;
        this.rightCell = rightCell;
    }

    public Cell(Symbol symbol, Symbol white) {
        this.symbol = symbol;
        this.leftCell = new Cell(null, white, this);
        this.rightCell = new Cell(this, white, (Cell) null);
    }

    public Cell(Symbol symbol, Cell rightCell) {
        this.symbol = symbol;
        this.leftCell = null;
        this.rightCell = rightCell;
        rightCell.leftCell = this;
    }

    public Cell(Cell leftCell, Symbol symbol, Symbol white) {
        this.symbol = symbol;
        this.leftCell = leftCell;
        this.rightCell = new Cell(this, white);
        leftCell.rightCell = this;
    }

    public Cell(Cell currentCell, Symbol symbol) {
        this.symbol = symbol;
        this.leftCell = currentCell;
        this.rightCell = null;
        leftCell.rightCell = this;
    }

    public String ToString() {
        String str = symbol.toString();
        if(leftCell != null) str = leftCell+", "+str;
        if(rightCell != null) str = str+", "+rightCell;
        return str;
    }
}
