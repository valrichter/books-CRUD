package Model;

import java.time.LocalDate;
import java.util.Date;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Alquiler {
    private Libro libro;
    private Usuario usuario;
    private LocalDate fechaAlquiler;
    private LocalDate fechaVencimiento;
    private LocalDate fechaDevolucion;

    public Alquiler(Libro libro, Usuario usuario) {
        this.libro = libro;
        this.usuario = usuario;
        this.fechaAlquiler = LocalDate.now();
        this.fechaVencimiento = fechaAlquiler.plusDays(7);
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "libro=" + libro +
                ", usuario=" + usuario +
                ", fechaAlquiler=" + fechaAlquiler +
                ", fechaVencimiento=" + fechaVencimiento +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
