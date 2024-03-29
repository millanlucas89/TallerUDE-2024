package CapaGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JTextField;

import CapaGrafica.Controladores.ControladorRegistrarAlumno;
import CapaGrafica.Controladores.ControladorRegistrarInscripcion;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaRegistrarInscripcion{

	private JFrame frmRegistrarInscripcion;
	private JPanel contentPane;
	private JTextField txtCed;
	private JTextField txtCod;
	private JTextField txtMonto;
	private JTextField txtAnio;
	private JButton btnVolver;
	private JButton btnRegistrar;
	private VentanaPrincipal ventanaPrincipal;
	private ControladorRegistrarInscripcion controlador;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
					ventanaPrincipal.setVisible(true); 
					VentanaRegistrarInscripcion window = new VentanaRegistrarInscripcion(ventanaPrincipal);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaRegistrarInscripcion(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		initialize();
		controlador = new ControladorRegistrarInscripcion(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegistrarInscripcion = new JFrame();
		frmRegistrarInscripcion.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/Logo.png")));
		frmRegistrarInscripcion.setTitle("REGISTRAR INSCRIPCION");
		frmRegistrarInscripcion.getContentPane().setBackground(new Color(255, 255, 255));
		frmRegistrarInscripcion.setBounds(100, 100, 450, 283);
		frmRegistrarInscripcion.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegistrarInscripcion.getContentPane().setLayout(null);
		frmRegistrarInscripcion.setResizable(false);


		JLabel lblCedulaAlumno = new JLabel("Ingrese cédula del alumno:");
		lblCedulaAlumno.setFont(new Font("Arial", Font.BOLD, 12));
		lblCedulaAlumno.setBounds(35, 22, 153, 19);
		frmRegistrarInscripcion.getContentPane().add(lblCedulaAlumno);

		JLabel lblCodigoAsignatura = new JLabel("Ingrese código de la asignatura:");
		lblCodigoAsignatura.setFont(new Font("Arial", Font.BOLD, 12));
		lblCodigoAsignatura.setBounds(35, 67, 181, 19);
		frmRegistrarInscripcion.getContentPane().add(lblCodigoAsignatura);

		JLabel lblMontoBase = new JLabel("Ingrese monto base:");
		lblMontoBase.setFont(new Font("Arial", Font.BOLD, 12));
		lblMontoBase.setBounds(35, 112, 118, 19);
		frmRegistrarInscripcion.getContentPane().add(lblMontoBase);

		JLabel lblAnioLectivo = new JLabel("Ingrese año lectivo:");
		lblAnioLectivo.setFont(new Font("Arial", Font.BOLD, 12));
		lblAnioLectivo.setBounds(35, 152, 118, 19);
		frmRegistrarInscripcion.getContentPane().add(lblAnioLectivo);

		txtCed = new JTextField();
		txtCed.setColumns(10);
		txtCed.setBounds(262, 22, 133, 20);
		frmRegistrarInscripcion.getContentPane().add(txtCed);

		txtCod = new JTextField();
		txtCod.setColumns(10);
		txtCod.setBounds(262, 67, 133, 20);
		frmRegistrarInscripcion.getContentPane().add(txtCod);

		txtMonto = new JTextField();
		txtMonto.setColumns(10);
		txtMonto.setBounds(262, 112, 133, 20);
		frmRegistrarInscripcion.getContentPane().add(txtMonto);

		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBounds(262, 152, 133, 20);
		frmRegistrarInscripcion.getContentPane().add(txtAnio);

		btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setVisible(true);
				frmRegistrarInscripcion.dispose();
			}
		});
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Arial", Font.BOLD, 12));
		btnVolver.setBackground(new Color(0x8fe1f7));
		btnVolver.setBounds(85, 202, 92, 30);
		frmRegistrarInscripcion.getContentPane().add(btnVolver);

		btnRegistrar = new JButton("REGISTRAR");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cedula = txtCed.getText();
				String codigo = txtCod.getText();
				String monto = txtMonto.getText();
				String anio = txtAnio.getText();
				controlador.registrarInscripcion(codigo, cedula, monto, anio);
			}
		});
		btnRegistrar.setForeground(Color.BLACK);
		btnRegistrar.setFont(new Font("Arial", Font.BOLD, 12));
		btnRegistrar.setBackground(new Color(0x42b881));
		btnRegistrar.setBounds(251, 202, 114, 30);
		frmRegistrarInscripcion.getContentPane().add(btnRegistrar);
	}

	public void setVisible(boolean mostrar) {
		frmRegistrarInscripcion.setVisible(mostrar);
	}

	public void mostrarMensajeError (String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	public void mostrarMensajeExito (String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void setLocationRelativeToNull() {
		frmRegistrarInscripcion.setLocationRelativeTo(null);
    }
}
