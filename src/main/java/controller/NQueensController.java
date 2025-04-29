package controller;

import model.NQueensResult;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class NQueensController {

    private int iteraciones = 0;

    public boolean resolverNReinas(int[][] tablero, int n) {
        return backtracking(tablero, 0, n);
    }

    private boolean backtracking(int[][] tablero, int col, int n) {
        if (col >= n) return true;
        for (int i = 0; i < n; i++) {
            if (esSeguro(tablero, i, col, n)) {
                tablero[i][col] = 1;
                iteraciones++;
                if (backtracking(tablero, col + 1, n)) return true;
                tablero[i][col] = 0;
            }
        }
        return false;
    }

    private boolean esSeguro(int[][] tablero, int fila, int col, int n) {
        for (int i = 0; i < col; i++)
            if (tablero[fila][i] == 1) return false;
        for (int i = fila, j = col; i >= 0 && j >= 0; i--, j--)
            if (tablero[i][j] == 1) return false;
        for (int i = fila, j = col; i < n && j >= 0; i++, j--)
            if (tablero[i][j] == 1) return false;
        return true;
    }

    public void guardarResultado(int n, boolean solucionEncontrada) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        NQueensResult result = new NQueensResult(n, solucionEncontrada, iteraciones);
        session.save(result);
        tx.commit();
        session.close();
    }
}
