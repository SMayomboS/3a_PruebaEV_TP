package view;

import javax.swing.*;
import java.awt.*;

public class NQueensPanel extends GamePanel {
    private int n = 8;
    private int[][] board;

    @Override
    public void iniciarJuego(){
        String input = JOptionPane.showInputDialog("Ingrese el tamaño del tablero (n):");
        if (input != null) {
            try {
                n = Integer.parseInt(input);
                board = new int [n][n];
                if (solveNQueens(0)){
                    repaint();
                    JOptionPane.showMessageDialog(this, "Solución encontrada!");
                } else {
                    JOptionPane.showMessageDialog(this, "No hay solución para n = " + n);
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Entrada inválida.");
            }
        }
    }

    private boolean solveNQueens(int col) {
        if (col >= n) return true;
        for (int i = 0; i < n; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                if (solveNQueens(col + 1)) return true;
                board[i][col] = 0; // backtrack
            }
        }
        return false;
    }

    private boolean isSafe(int row, int col){
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1) return false;
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1) return false;
        for (int i = row, j = col; j >= 0 && i < n; i++, j--)
            if (board[i][j] == 1) return false;
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (board != null) {
            int size = Math.min(getWidth(), getHeight()) / n;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if ((i + j) % 2 == 0) {
                        g.setColor(Color.LIGHT_GRAY);
                    } else {
                        g.setColor(Color.DARK_GRAY);
                    }
                    g.fillRect(j * size, i * size, size, size);
                    if (board[i][j] == 1) {
                        g.setColor(Color.RED);
                        g.fillOval(j * size + size / 4, i * size + size / 4, size / 2, size / 2);
                    }
                }
            }
        }

    }
}
