package CapaGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaInscripcionAsignatura extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textCed;
	private JTextField textCod;
	private JTextField textMonto;
	private JTextField textAnio;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaInscripcionAsignatura frame = new VentanaInscripcionAsignatura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaInscripcionAsignatura() {
		setTitle("REGISTRAR INSCRIPCION");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 445, 277);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCedulaAlumno = new JLabel("Ingrese cedula del alumno");
		lblCedulaAlumno.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCedulaAlumno.setBounds(33, 23, 153, 19);
		contentPane.add(lblCedulaAlumno);
		
		textCed = new JTextField();
		textCed.setColumns(10);
		textCed.setBounds(240, 22, 133, 20);
		contentPane.add(textCed);
		
		JLabel lblCodigoAsignatura = new JLabel("Ingrese codigo de la asignatura");
		lblCodigoAsignatura.setFont(new Font("Arial", Font.PLAIN, 12));
		lblCodigoAsignatura.setBounds(33, 65, 181, 19);
		contentPane.add(lblCodigoAsignatura);
		
		textCod = new JTextField();
		textCod.setColumns(10);
		textCod.setBounds(240, 64, 133, 20);
		contentPane.add(textCod);
		
		JLabel lblMontoBase = new JLabel("Ingrese monto base");
		lblMontoBase.setFont(new Font("Arial", Font.PLAIN, 12));
		lblMontoBase.setBounds(33, 106, 118, 19);
		contentPane.add(lblMontoBase);
		
		JLabel lblAnioLectivo = new JLabel("Ingrese año lectivo");
		lblAnioLectivo.setFont(new Font("Arial", Font.PLAIN, 12));
		lblAnioLectivo.setBounds(33, 148, 118, 19);
		contentPane.add(lblAnioLectivo);
		
		textMonto = new JTextField();
		textMonto.setColumns(10);
		textMonto.setBounds(240, 105, 133, 20);
		contentPane.add(textMonto);
		
		textAnio = new JTextField();
		textAnio.setColumns(10);
		textAnio.setBounds(240, 147, 133, 20);
		contentPane.add(textAnio);
		
		JButton btnInscribir = new JButton("INSCRIBIR");
		btnInscribir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInscribir.setForeground(Color.BLACK);
		btnInscribir.setFont(new Font("Arial", Font.PLAIN, 12));
		btnInscribir.setBackground(Color.GREEN);
		btnInscribir.setBounds(240, 197, 100, 30);
		contentPane.add(btnInscribir);
		
		JButton btnVolver = new JButton("VOLVER");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Arial", Font.PLAIN, 12));
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.setBounds(78, 197, 92, 30);
		contentPane.add(btnVolver);
	}
}
