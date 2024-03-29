package CapaGrafica;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CapaGrafica.Controladores.ControladorListadoEgresados;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaListadoEgresados {

	private JFrame frmListarEgresados;
	private JRadioButton rdbtnCompleto;
	private JRadioButton rdbtnParcial;
	private VentanaPrincipal ventanaPrincipal;
	private ControladorListadoEgresados controlador;
	private JTable table;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
					ventanaPrincipal.setVisible(true); 
					VentanaListadoEgresados window = new VentanaListadoEgresados(ventanaPrincipal);
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
	public VentanaListadoEgresados(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		initialize();
		controlador = new ControladorListadoEgresados(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmListarEgresados = new JFrame();
		frmListarEgresados.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/Logo.png")));
		frmListarEgresados.getContentPane().setBackground(new Color(255, 255, 255));
		frmListarEgresados.setTitle("LISTAR EGRESADOS");
		frmListarEgresados.setBounds(100, 100, 496, 443);
		frmListarEgresados.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmListarEgresados.getContentPane().setLayout(null);

		frmListarEgresados.setResizable(false);


		ButtonGroup bgp = new ButtonGroup();

		JLabel lblModoListado = new JLabel("Indique un modo de listado:");
		lblModoListado.setFont(new Font("Arial", Font.BOLD, 12));
		lblModoListado.setBounds(67, 41, 163, 19);
		frmListarEgresados.getContentPane().add(lblModoListado);

		final JRadioButton rdbtnParcial = new JRadioButton("Parcial");
		rdbtnParcial.setBackground(Color.WHITE);
		rdbtnParcial.setBounds(247, 39, 71, 23);
		frmListarEgresados.getContentPane().add(rdbtnParcial);
		bgp.add(rdbtnParcial);

		final JRadioButton rdbtnCompleto = new JRadioButton("Completo");
		rdbtnCompleto.setBackground(Color.WHITE);
		rdbtnCompleto.setBounds(331, 39, 79, 23);
		frmListarEgresados.getContentPane().add(rdbtnCompleto);
		bgp.add(rdbtnCompleto);

		JButton btnVolver = new JButton("VOLVER");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setVisible(true);
				frmListarEgresados.dispose();
			}
		});
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Arial", Font.BOLD, 12));
		btnVolver.setBackground(new Color(0x8fe1f7));
		btnVolver.setBounds(101, 81, 92, 30);
		frmListarEgresados.getContentPane().add(btnVolver);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 143, 462, 238);
		frmListarEgresados.getContentPane().add(scrollPane);

		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		scrollPane.setVisible(false);
		table.getTableHeader().setReorderingAllowed(false);


		JButton btnListar = new JButton("LISTAR");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean modo;
				if(rdbtnCompleto.isSelected()) {
					modo = true;
					controlador.listarEgresados(modo);
				}
				else if(rdbtnParcial.isSelected()) {
					modo = false;
					controlador.listarEgresados(modo);
				}
				else {
					JOptionPane.showMessageDialog(null, "Por favor, seleccione una opcion");
				}
			}
		});
		btnListar.setForeground(Color.BLACK);
		btnListar.setFont(new Font("Arial", Font.BOLD, 12));
		btnListar.setBackground(new Color(0x42b881));
		btnListar.setBounds(266, 81, 100, 30);
		frmListarEgresados.getContentPane().add(btnListar);



	}

	public void setearDatosCompleto(Object[][] data) {
		String[] columnNames = {"Apellido",
				"Nombre",
				"Cedula",
				"PromedioAprobadas",
				"PromedioTotal"
		};

		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		table.setModel(dtm);
		scrollPane.setVisible(true);
	}

	public void setearDatosParcial(Object[][] data) {
		String[] columnNames = {"Apellido",
				"Nombre",
				"Cedula",

		};

		DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
		table.setModel(dtm);
		scrollPane.setVisible(true);
	}



	public void setVisible(boolean mostrar) {
		frmListarEgresados.setVisible(mostrar);
	}


	public void mostrarMensajeError (String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}
	
	public void setLocationRelativeToNull() {
		frmListarEgresados.setLocationRelativeTo(null);
    }
}
