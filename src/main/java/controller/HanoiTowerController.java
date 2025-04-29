package controller;

import model.HanoiResult;
import util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class HanoiTowerController {

    private int cantidadMovimientos = 0;

    public void resolverHanoi(int n, char origen, char destino, char auxiliar, java.util.List<String> movimientos) {
        if (n == 1) {
            movimientos.add("Mover disco 1 de " + origen + " a " + destino);
            cantidadMovimientos++;
        } else {
            resolverHanoi(n - 1, origen, auxiliar, destino, movimientos);
            movimientos.add("Mover disco " + n + " de " + origen + " a " + destino);
            cantidadMovimientos++;
            resolverHanoi(n - 1, auxiliar, destino, origen, movimientos);
        }
    }

    public void guardarResultado(int discos, boolean completado) {
        Session session = HibernateUtil.getInstance().getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        HanoiResult result = new HanoiResult(discos, cantidadMovimientos, completado);
        session.save(result);
        tx.commit();
        session.close();
    }
}
