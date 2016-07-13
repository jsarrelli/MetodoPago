package Ventanas;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import MediosPago.PayPal;
import TiendaOnline.Carrito;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazPaypal {

	private JFrame frame;
	private Carrito carrito;
	private JTextField Usuario;
	private JPasswordField password;

	public InterfazPaypal(Carrito carrito) {
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
		lblAccedeATu.setBounds(134, 22, 141, 16);
		frame.getContentPane().add(lblAccedeATu);
		
		Usuario = new JTextField();
		Usuario.setBounds(117, 57, 130, 26);
		frame.getContentPane().add(Usuario);
		Usuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("User:");
		lblUsuario.setBounds(69, 62, 61, 16);
		frame.getContentPane().add(lblUsuario);
		
		JLabel lblContrase = new JLabel("Password:");
		lblContrase.setBounds(42, 95, 78, 16);
		frame.getContentPane().add(lblContrase);
		
		password = new JPasswordField();
		password.setBounds(117, 90, 130, 26);
		frame.getContentPane().add(password);
		
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
		
		JButton btnAcceder = new JButton("Pagar");
		btnAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(!CamposVacios()){
				btnAcceder.setEnabled(false);
				char[] passChar=password.getPassword();
				String passwordString= new String(passChar);
				PayPal paypal=new PayPal(Usuario.getText(), passwordString);
				
				int monto=carrito.CalcularTotal();
				paypal.pagar(monto,carrito);
				}
				
				else {
					JOptionPane.showMessageDialog(null, "Llene todos los campos");
				}
				
				
				
				
				
			}
		});
		btnAcceder.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		btnAcceder.setBounds(221, 122, 99, 29);
		frame.getContentPane().add(btnAcceder);
		
		
		
		
		
	}
	
	public boolean CamposVacios()
	{
		if (Usuario.getText().length()==0)return true;
		if (password.getPassword().length==0)return true;
		else return false;
	}
}
