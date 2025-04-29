package controller;

import java.util.List;

public class HanoiTowerFacade {

    private final HanoiTowerController controller = new HanoiTowerController();

    public void resolver(int n, char origen, char destino, char auxiliar, List<String> movimientos) {
        controller.resolverHanoi(n, origen, destino, auxiliar, movimientos);
    }

    public void guardarResultado(int discos, boolean completado) {
        controller.guardarResultado(discos, completado);
    }
}
