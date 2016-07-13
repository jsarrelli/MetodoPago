package Ventanas;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


import MediosPago.TarjetaCredito;
import TiendaOnline.Carrito;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazTarjeta {

	private JFrame frame;
	private Carrito carrito;
	private JTextField numeroTarjeta;
	private JPasswordField Codigo;
	private JTextField Nombre;
	private JTextField Vencimiento;
	private boolean vacios=false;

	public InterfazTarjeta(Carrito carrito) {
		this.carrito=carrito;
		initialize();
	}


	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 450, 300);
		 frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
		
		JLabel lblAccedeATu = new JLabel("Accede a tu cuenta:");
		lblAccedeATu.setBounds(117, 90, 141, 16);
		frame.getContentPane().add(lblAccedeATu);
		
		numeroTarjeta = new JTextField();
		numeroTarjeta.setBounds(117, 118, 130, 26);
		frame.getContentPane().add(numeroTarjeta);
		numeroTarjeta.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Numero Tarjeta");
		lblUsuario.setBounds(6, 123, 99, 16);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrase = new JLabel("Nombre ");
		lblContrase.setBounds(6, 194, 110, 16);
		frame.getContentPane().add(lblContrase);
		
		Codigo = new JPasswordField();
		Codigo.setBounds(117, 155, 130, 26);
		frame.getContentPane().add(Codigo);
		
		JButton btnRegresar = new JButton("Back");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
				new SeleccionarPago(carrito);
				
				
			}
		});
		btnRegresar.setFont(new Font("Lucida Grande", Font.PLAIN, 5));
		btnRegresar.setBounds(6, 0, 61, 29);
		frame.getContentPane().add(btnRegresar);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				String codigoString=new String(Codigo.getPassword());
				
		
				if(!CamposVacios())
				{
					
					TarjetaCredito tarjeta=new TarjetaCredito(numeroTarjeta.getText(), Nombre.getText(), codigoString, Vencimiento.getText());
					int monto=carrito.CalcularTotal();
					tarjeta.pagar(monto,carrito);
					btnPagar.setEnabled(false);
					
				}
				
				else
				{
					JOptionPane.showMessageDialog(null, "Llene todos los campos");
					
				}
				
				
				
				
				
			}
		});
		btnPagar.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnPagar.setBounds(306, 152, 99, 29);
		frame.getContentPane().add(btnPagar);
		
		JLabel lblPaypal = new JLabel("Credit Card");
		lblPaypal.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPaypal.setBounds(164, 35, 155, 26);
		frame.getContentPane().add(lblPaypal);
		
		Nombre = new JTextField();
		Nombre.setBounds(117, 189, 130, 26);
		frame.getContentPane().add(Nombre);
		Nombre.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(6, 160, 61, 16);
		frame.getContentPane().add(lblCodigo);
		
		JLabel lblNewLabel = new JLabel("Vencimiento");
		lblNewLabel.setBounds(6, 227, 110, 16);
		frame.getContentPane().add(lblNewLabel);
		
		Vencimiento = new JTextField();
		Vencimiento.setBounds(117, 222, 130, 26);
		frame.getContentPane().add(Vencimiento);
		Vencimiento.setColumns(10);
		
		

		
		
		
		
		
		
	}
	
	public boolean CamposVacios()
	
	{
		if (Nombre.getText().length()==0)return true;
		if (numeroTarjeta.getText().length()==0)return true;
		if (Vencimiento.getText().length()==0)return true;
		if (Codigo.getPassword().length==0)return true;
		else return false;
	}
}
