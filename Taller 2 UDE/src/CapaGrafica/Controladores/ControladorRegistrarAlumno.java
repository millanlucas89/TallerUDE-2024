package CapaGrafica.Controladores;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import javax.swing.JOptionPane;

import CapaGrafica.VentanaRegistrarAlumno;
import CapaLogica.IFachada;
import CapaLogica.Exceptions.AlumnoNoInscriptoException;
import CapaLogica.Exceptions.AlumnoYaExisteExceptions;
import CapaLogica.Exceptions.AsignaturaYaExisteException;
import CapaLogica.Exceptions.AsignaturasCompletaException;
import CapaLogica.Inscripciones.Inscripciones;
import CapaLogica.VO.voAlumno;
import CapaLogica.VO.voBecado;

public class ControladorRegistrarAlumno {

	private VentanaRegistrarAlumno ventana;
	private IFachada fachada;

	public ControladorRegistrarAlumno(VentanaRegistrarAlumno ven) {
		this.ventana = ven;
		try {
			Properties prop = new Properties();
			String nomArch = "config/txt.properties";
			prop.load (new FileInputStream (nomArch));
			String ip = prop.getProperty("ip");
			String puerto = prop.getProperty("puerto");
			fachada = (IFachada)
					Naming.lookup("//"+ip+":"+puerto+"/fachada");

		}catch (MalformedURLException e) {
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

	public void registrarAlumno(String cedula,String nombre,String apellido,String domicilio,String telefono) {
		try {
			if (!cedula.matches("\\d+")) {
				ventana.mostrarMensajeError("La cedula no tiene formato numerico");
			}
			else {
				if (!telefono.matches("\\d+")) {
					ventana.mostrarMensajeError("El telefono no tiene formato numerico");
				}
				else {
					if (nombre.isEmpty()) {
						ventana.mostrarMensajeError("El campo nombre no puede estar vacío");
					}
					else {
						if (apellido.isEmpty()) {
							ventana.mostrarMensajeError("El campo apellido no puede estar vacío");
						}
						else {
							if (domicilio.isEmpty()) {
								ventana.mostrarMensajeError("El campo domicilio no puede estar vacío");
							}
							else {
								voAlumno alumno = new voAlumno(Long.parseLong(cedula),nombre,apellido,domicilio,Long.parseLong(telefono));
								fachada.registarAlumno(alumno);
								ventana.mostrarMensajeExito("Alumno ingresado correctamente.");
							}
						}	
					}
				}
			}
		}
		catch (AlumnoYaExisteExceptions exc) {
			ventana.mostrarMensajeError(exc.darMensaje());
		} catch (RemoteException exc) {
			ventana.mostrarMensajeError(exc.getMessage());
		}
	}

	public void registrarAlumnoBecado(String cedula,String nombre,String apellido,String domicilio,String telefono, String porcentaje, String razon) {
		try {
			if (!cedula.matches("\\d+")) {
				ventana.mostrarMensajeError("La cedula no tiene formato numerico");
			}
			else {
				if (!telefono.matches("\\d+")) {
					ventana.mostrarMensajeError("El telefono no tiene formato numerico");
				}
				else {
					if (!porcentaje.matches("\\d+")) {
						ventana.mostrarMensajeError("El porcentaje no tiene formato numerico");
					}
					else {
						if (nombre.isEmpty()) {
							ventana.mostrarMensajeError("El campo nombre no puede estar vacío");
						}
						else {
							if (apellido.isEmpty()) {
								ventana.mostrarMensajeError("El campo apellido no puede estar vacío");
							}
							else {
								if (domicilio.isEmpty()) {
									ventana.mostrarMensajeError("El campo domicilio no puede estar vacío");
								}
								else {
									if (razon.isEmpty()) {
										ventana.mostrarMensajeError("El campo razon no puede estar vacío");
									}
									else {
										voBecado becado = new voBecado(Long.parseLong(cedula),nombre,apellido,domicilio,Long.parseLong(telefono), Integer.parseInt(porcentaje), razon);
										fachada.registarAlumno(becado);
										ventana.mostrarMensajeExito("Alumno becado ingresado correctamente.");
									}
								}
							}	
						}
					}
				}
			}
		}
		catch (AlumnoYaExisteExceptions exc) {
			ventana.mostrarMensajeError(exc.darMensaje());
		} catch (RemoteException exc) {
			ventana.mostrarMensajeError(exc.getMessage());
		}
	}

}


