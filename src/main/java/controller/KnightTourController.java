package controller;

import model.KnightTourResult;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class KnightTourController {

    private final int[] moveX = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] moveY = {1, 2, 2, 1, -1, -2, -2, -1};
    private int movimientosRealizados = 0;

    public boolean resolverRecorridoCaballo(int[][] tablero, int n) {
        for (int[] fila : tablero) {
            java.util.Arrays.fill(fila, -1);
        }
        tablero[0][0] = 0;
        return backtracking(tablero, 0, 0, 1, n);
    }

    private boolean backtracking(int[][] tablero, int x, int y, int moveCount, int n) {
        if (moveCount == n * n) return true;

        for (int i = 0; i < 8; i++) {
            int nextX = x + moveX[i];
            int nextY = y + moveY[i];
            if (esValido(nextX, nextY, tablero, n)) {
                tablero[nextX][nextY] = moveCount;
                movimientosRealizados++;
                if (backtracking(tablero, nextX, nextY, moveCount + 1, n)) return true;
                tablero[nextX][nextY] = -1;
            }
        }
        return false;
    }

    private boolean esValido(int x, int y, int[][] tablero, int n) {
        return (x >= 0 && x < n && y >= 0 && y < n && tablero[x][y] == -1);
    }

    public void guardarResultado(int n, boolean completo) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        KnightTourResult result = new KnightTourResult(n, "(0,0)", completo, movimientosRealizados);
        session.save(result);
        tx.commit();
        session.close();
    }
}
