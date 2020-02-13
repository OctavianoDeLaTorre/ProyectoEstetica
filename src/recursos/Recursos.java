/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import vista.ResultSetTableModel;
import configBD.Conexion;
import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import rojerusan.RSNotifyAnimated;
import java.util.Date;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author octaviano
 */
public class Recursos {

    String CONTROLADOR = "com.mysql.jdbc.Driver";
    String URL = "jdbc:mysql://localhost/Estetica";

    /*Metodo para limpiar componentes graficos*/
    public void limpiar(JComponent... args) {
        for (Component x : args) {
            if (x instanceof JTextField) {
                ((JTextField) x).setText("");
            } else if (x instanceof JComboBox) {
                ((JComboBox) x).setSelectedIndex(0);
            }else if (x instanceof JSpinner) {
                ((JSpinner) x).setValue(0);
            }
        }

    }

    /*Metodo para mostrar resultado de consulta en tabla*/
    public boolean mostrarTabla(JTable tabla, String sql) {
        try {
            tabla.setModel(new ResultSetTableModel(CONTROLADOR, URL, sql));
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*Metodo para comprovar si los componetes estan vacios*/
    public boolean componentesVacios(JComponent... args) {
        for (Component x : args) {
            if (x instanceof JTextField) {
                if ((((JTextField) x).getText().replaceAll(" ", "")).equals("")) {
                    return true;
                }
            } else if (x instanceof JComboBox) {
                if (((JComboBox) x).getSelectedIndex() == 0) {
                    return true;
                }
            } else if (x instanceof JSpinner) {
                if (((int) ((JSpinner) x).getValue()) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public void habilitarComponentes(boolean b, JComponent... args) {
        for (Component x : args) {
            x.setEnabled(b);
        }
    }

    public void seleccionRBBuscar(JComponent actula, JComponent... args) {
        actula.setEnabled(true);
        ((JComponent) actula).requestFocus();
        for (JComponent x : args) {
            x.setEnabled(false);
            if (x instanceof JTextField) {
                ((JTextField) x).setText("");
            }
        }
    }

    public JTextField[] arreglocajas(JTextField... args) {
        JTextField a[] = new JTextField[args.length];
        for (int i = 0; i < args.length; i++) {
            a[i] = args[i];

        }
        return a;
    }

    public void llenarComboBox(String tabla, JComboBox<String> combo, int posicion) {
        String sql = " SELECT * FROM " + tabla;

        Conexion conexion = new Conexion();
        ResultSet rs = conexion.ejecutarConsulta(sql);
        if (rs == null) {

        } else {
            combo.removeAllItems();
            combo.addItem("Selecciona...");
            try {
                while (rs.next()) {
                    combo.addItem(rs.getString(posicion));
                }

            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println(e.getMessage());

            }

        }
    }

    public void ordenTabulacion(JComponent...args){
         for (int i = 0; i < args.length; i++) {
             if(i+1 < args.length){
                  args[i].setNextFocusableComponent(args[i+1]);
             }else{
                 args[i].setNextFocusableComponent(args[0]);
             }
      
             
         }
    }
    
    public void mostrarNotificacionError(String titulo,String mensaje){
        new rojerusan.RSNotifyAnimated(titulo,mensaje,7,RSNotifyAnimated.PositionNotify.BottomRight,
        RSNotifyAnimated.AnimationNotify.RightLeft,RSNotifyAnimated.TypeNotify.ERROR).setVisible(true);
    }
    
    public void mostrarNotificacionCuidado(String titulo,String mensaje){
        new rojerusan.RSNotifyAnimated(titulo,mensaje,7,RSNotifyAnimated.PositionNotify.BottomRight,
        RSNotifyAnimated.AnimationNotify.RightLeft,RSNotifyAnimated.TypeNotify.WARNING).setVisible(true);
    }
    
     public void mostrarNotificacionExito(String titulo,String mensaje){
        new rojerusan.RSNotifyAnimated(titulo,mensaje,7,RSNotifyAnimated.PositionNotify.BottomRight,
        RSNotifyAnimated.AnimationNotify.RightLeft,RSNotifyAnimated.TypeNotify.SUCCESS).setVisible(true);
    }
     
      public void mostrarNotificacionInfo(String titulo,String mensaje){
        new rojerusan.RSNotifyAnimated(titulo,mensaje,7,RSNotifyAnimated.PositionNotify.BottomRight,
        RSNotifyAnimated.AnimationNotify.RightLeft,RSNotifyAnimated.TypeNotify.INFORMATION).setVisible(true);
    }
 ;
    public String obtenerFecha(){
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }
    
    public String obtenerFecha(Date fecha) throws NullPointerException{
        return new SimpleDateFormat("yyyy-MM-dd").format(fecha);
    }
    
    public SpinnerNumberModel modeloSpinner(int max){
       SpinnerNumberModel sM = new SpinnerNumberModel();
       sM.setMinimum(0);
       sM.setMaximum(max);
        return sM;
    }
    
    public boolean validarDatosNumericos(JTextField...args){
        try {
            for (JTextField caja : args) {
                Double.parseDouble(caja.getText());
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
