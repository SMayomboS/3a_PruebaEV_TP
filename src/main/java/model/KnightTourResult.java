package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "knight_tour_results")
public class KnightTourResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int n;
    private String inicio;
    private boolean completo;
    private int movimientos;
    private LocalDateTime fecha;

    public KnightTourResult() {
        this.fecha = LocalDateTime.now();
    }

    public KnightTourResult(int n, String inicio, boolean completo, int movimientos) {
        this.n = n;
        this.inicio = inicio;
        this.completo = completo;
        this.movimientos = movimientos;
        this.fecha = LocalDateTime.now();
    }

    // Getters y setters
    public Long getId() { return id; }
    public int getN() { return n; }
    public void setN(int n) { this.n = n; }
    public String getInicio() { return inicio; }
    public void setInicio(String inicio) { this.inicio = inicio; }
    public boolean isCompleto() { return completo; }
    public void setCompleto(boolean completo) { this.completo = completo; }
    public int getMovimientos() { return movimientos; }
    public void setMovimientos(int movimientos) { this.movimientos = movimientos; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}