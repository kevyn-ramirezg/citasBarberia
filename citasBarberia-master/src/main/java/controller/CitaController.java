package controller;

import factory.CitaFactory;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import model.Cliente;
import model.Cita;
import notificacion.NotificacionService;
import observer.Observer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CitaController {
    @FXML
    private TextField nombreField;

    @FXML
    private TextField telefonoField;

    @FXML
    private DatePicker fechaField;

    @FXML
    private TextField horaField;

    private List<Observer> observers = new ArrayList<>();

    @FXML
    private void initialize() {
        NotificacionService notificacionService = new NotificacionService();
        addObserver(notificacionService);
    }

    @FXML
    protected void agendarCita() {
        String nombre = nombreField.getText();
        String telefono = telefonoField.getText();
        LocalDate fecha = fechaField.getValue();
        String hora = horaField.getText();

        if (nombre.isEmpty() || telefono.isEmpty() || fecha == null || hora.isEmpty()) {
            System.out.println("Por favor, complete todos los campos.");
            return;
        }

        Cliente cliente = new Cliente(nombre, telefono);
        Cita cita = CitaFactory.crearCita(cliente, fecha, hora);

        System.out.println("Cita agendada para: " + cliente.getNombre() + " el " + cita.getFecha() + " a las " + cita.getHora());

        notifyObservers("Cita agendada para: " + cliente.getNombre() + " el " + cita.getFecha() + " a las " + cita.getHora());
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    private void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}  