package notificacion;

import observer.Observer;

public class NotificacionService implements Observer {
    @Override
    public void update(String message) {
        // Lógica para manejar la notificación
        System.out.println("Notificación recibida: " + message);
    }
}
