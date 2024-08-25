package model;

import java.time.LocalDate;

public class Cita {
    private Cliente cliente;
    private LocalDate fecha;
    private String hora;

    // Constructorr

    public Cita(Cliente cliente, LocalDate fecha, String hora) {
        this.cliente = cliente;
        this.fecha = fecha;
        this.hora = hora;
    }



    // Getters
    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    // Setters
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}

