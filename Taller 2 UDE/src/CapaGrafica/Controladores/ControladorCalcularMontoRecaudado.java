package CapaGrafica.Controladores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import CapaGrafica.VentanaCalcularMontoRecaudado;
import CapaLogica.IFachada;
import CapaLogica.Exceptions.AlumnoNoInscriptoException;
import CapaLogica.Exceptions.DicAsignaturasVacioException;
import CapaLogica.VO.voAlumnoCompleto;
import CapaLogica.VO.voAsignatura;

public class ControladorCalcularMontoRecaudado {
	private VentanaCalcularMontoRecaudado ventana;
	private IFachada fachada;

	public ControladorCalcularMontoRecaudado(VentanaCalcularMontoRecaudado ven) {
		this.ventana = ven;
		try {

			Properties prop = new Properties();
			String nomArch = "config/txt.properties";
			prop.load (new FileInputStream (nomArch));
			String ip = prop.getProperty("ip");
			String puerto = prop.getProperty("puerto");
			fachada = (IFachada)
					Naming.lookup("//"+ip+":"+puerto+"/fachada");

		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con el servidor");
			e.printStackTrace();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con el servidor");
			e.printStackTrace();
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con el servidor");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public void montoRecaudado (String ced, String anio) {
		try {
			if (!ced.matches("\\d+")) {
				ventana.mostrarMensajeError("La cedula no tiene formato numerico");
			}
			else {
				if (!anio.matches("\\d+")) {
					ventana.mostrarMensajeError("El año no tiene formato numerico");
				}
				else {
					float monto = fachada.montoRecaudado(Long.parseLong(ced),Integer.parseInt(anio));
					String.format("%.2f",monto);
					String montoString = String.valueOf(monto);
					ventana.setearMonto(montoString);
				}
			}
		} catch (AlumnoNoInscriptoException exc) {
			ventana.mostrarMensajeError(exc.darMensaje());
		} catch (RemoteException exc) {
			ventana.mostrarMensajeError(exc.getMessage());
		}
	}
}
