package model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "hanoi_results")
public class HanoiResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int discos;
    private int movimientos;
    private boolean completado;
    private LocalDateTime fecha;

    public HanoiResult() {
        this.fecha = LocalDateTime.now();
    }

    public HanoiResult(int discos, int movimientos, boolean completado) {
        this.discos = discos;
        this.movimientos = movimientos;
        this.completado = completado;
        this.fecha = LocalDateTime.now();
    }

    // Getters y setters
    public Long getId() { return id; }
    public int getDiscos() { return discos; }
    public void setDiscos(int discos) { this.discos = discos; }
    public int getMovimientos() { return movimientos; }
    public void setMovimientos(int movimientos) { this.movimientos = movimientos; }
    public boolean isCompletado() { return completado; }
    public void setCompletado(boolean completado) { this.completado = completado; }
    public LocalDateTime getFecha() { return fecha; }
    public void setFecha(LocalDateTime fecha) { this.fecha = fecha; }
}
