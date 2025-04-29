package controller;

public class KnightTourFacade {

    private final KnightTourController controller = new KnightTourController();

    public boolean resolver(int[][] tablero, int n) {
        return controller.resolverRecorridoCaballo(tablero, n);
    }

    public void guardarResultado(int n, boolean completo) {
        controller.guardarResultado(n, completo);
    }
}
