/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import configBD.Conexion;
import modelo.Proveedor;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author octaviano
 */
public class ProveedoreDAO {
    
    /*Variables de instancia*/
   private Conexion conexion = new Conexion();
   private String sql ;
   
    public boolean registrarProveedor(Proveedor p) {
        sql = "INSERT INTO Proveedores VALUES('" +
                p.getRfc().toUpperCase() + "','" +
                p.getNombre() + "','" + 
                p.getPrimerAp()+ "','" +
                p.getSegundoAp()+ "','" + 
                p.getDireccion() + "','" + p.getTelefono() + "','" +
                p.getEmpresa() + "');";
        System.out.println(sql);
       return conexion.ejecutarInstruccionSQL(sql);
    }
    
    public boolean eliminarProveedor(String rfc) {
       sql = " DELETE FROM Proveedores WHERE Rfc ='" + rfc.toUpperCase() + "'";
        return conexion.ejecutarInstruccionSQL(sql);
    }
    
    public Proveedor consultaProveedor(String rfc){
		String sql = " SELECT * FROM Proveedores WHERE Rfc ='"+rfc.toUpperCase()+"'";
		System.out.println(sql);
		ResultSet rs = conexion.ejecutarConsulta(sql);
		if(rs == null){
			return null;
		}else{
			Proveedor p = null;
			try {
				while (rs.next()) {
					p = new Proveedor();
					p.setNombre(rs.getString(2));
					p.setPrimerAp(rs.getString(3));
					p.setSegundoAp(rs.getString(4));
					p.setDireccion(rs.getString(5));
					p.setTelefono(rs.getString(6));
					p.setEmpresa(rs.getString(7));
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				return null;
			}
			return p;
		}
	}
    
    public boolean modificacionProveedor(Proveedor p) {
        sql = "UPDATE Proveedores SET Nombre='" + p.getNombre() +
                "',Primer_Ap='" + p.getPrimerAp()+
                "',Segundo_Ap='" + p.getSegundoAp()+
                "',Direccion='" + p.getDireccion() + 
                "',Telefono='" + p.getTelefono() + 
                "',Empresa='" + p.getEmpresa() +
                "' WHERE Rfc='" + p.getRfc().toUpperCase() + "'";
        System.out.println(sql);
        return conexion.ejecutarInstruccionSQL(sql);

    }

}
