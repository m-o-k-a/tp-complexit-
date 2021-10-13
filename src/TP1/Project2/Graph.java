package TP1.Project2;

public class Graph {
    int nmax;
    int[][] matrix;

    public Graph(int nmax) {
        this.nmax = nmax;
        this.matrix = new int[nmax][nmax];
    }

    public Graph(int[][] matrix) {
        //todo square matrix only
        this.nmax = matrix.length;
        this.matrix = matrix;
    }

    public void addEdge(int x, int y) {
        //todo check possibility and x != y
        matrix[x][y] = 1;
        matrix[y][x] = 1;

    }
}
