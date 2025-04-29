package view;

import controller.HanoiTowerFacade;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class HanoiTowerPanel extends GamePanel {

    private JTextArea resultArea;
    private List<String> movimientos;
    private final HanoiTowerFacade facade = new HanoiTowerFacade();

    @Override
    public void iniciarJuego() {
        setLayout(new BorderLayout());

        int numDiscos = solicitarNumeroDiscos();
        if (numDiscos <= 0) return;

        movimientos = new ArrayList<>();
        facade.resolver(numDiscos, 'A', 'C', 'B', movimientos);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        for (String paso : movimientos) {
            resultArea.append(paso + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(resultArea);
        add(scrollPane, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(this,
                "Puzzle resuelto con " + movimientos.size() + " movimientos.",
                "Torres de Hanoi",
                JOptionPane.INFORMATION_MESSAGE);

        facade.guardarResultado(numDiscos, true);
    }

    private int solicitarNumeroDiscos() {
        try {
            String input = JOptionPane.showInputDialog(this, "Ingrese el número de discos:", "Torres de Hanoi", JOptionPane.PLAIN_MESSAGE);
            if (input == null) return -1;
            int n = Integer.parseInt(input);
            if (n < 1 || n > 8) {
                JOptionPane.showMessageDialog(this, "Ingrese un número entre 1 y 8.");
                return solicitarNumeroDiscos();
            }
            return n;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Entrada inválida.");
            return solicitarNumeroDiscos();
        }
    }
}