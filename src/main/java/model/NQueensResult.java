package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "n_queens_results")
public class NQueensResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int n;
    private boolean solucionEncontrada;
    private int iteraciones;
    private LocalDateTime fecha;

    public NQueensResult() {
        this.fecha = LocalDateTime.now();
    }

    public NQueensResult(int n, boolean solucionEncontrada, int iteraciones) {
        this.n = n;
        this.solucionEncontrada = solucionEncontrada;
        this.iteraciones = iteraciones;
        this.fecha = LocalDateTime.now();
    }

    // Getters y setters
    public Long getId() { return id; }
    public int getN() { return n; }
    public void setN(int n) { this.n = n; }
    public boolean isSolucionEncontrada() { return solucionEncontrada; }
    public void setSolucionEncontrada(boolean solucionEncontrada) { this.solucionEncontrada = solucionEncontrada; }
    public int getIteraciones() { return iteraciones; }
    public void setIteraciones(int iteraciones) { this.iteraciones = iteraciones; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
