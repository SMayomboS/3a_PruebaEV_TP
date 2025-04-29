package controller;

public class NQueensFacade {

    private final NQueensController controller = new NQueensController();

    public boolean resolver(int[][] tablero, int n) {
        return controller.resolverNReinas(tablero, n);
    }

    public void guardarResultado(int n, boolean solucionEncontrada) {
        controller.guardarResultado(n, solucionEncontrada);
    }
}
