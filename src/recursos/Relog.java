package recursos;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTextField;

public class Relog implements Runnable {

    //Variables de intancia
    private int hora, minutos, segundos;
    private Calendar calendario;
    private Thread h1;
    private JTextField txtHora;

    //Costructor
    public Relog(JTextField txtHora) {
        h1 = new Thread(this);
        h1.start();
        this.txtHora = txtHora;
    }

    //Metodo para obtener la hora actual del sistema
    public void obtenerHora() {
        calendario = new GregorianCalendar();
        hora = calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
    }

    //Implementar el metodo run() para mostrar la hora en tiempo real
    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            obtenerHora();
            if (segundos < 10 && minutos < 10) {
                txtHora.setText(hora + ":0" + minutos + ":0" + segundos);
            } else if (minutos < 10) {
                txtHora.setText(hora + ":0" + minutos + ":" + segundos);
            } else if (segundos < 10) {
                txtHora.setText(hora + ":" + minutos + ":0" + segundos);

            } else {
                txtHora.setText(hora + ":" + minutos + ":" + segundos);
            }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {

                }
            
        }
    }

}
