package Ventanas;



import javax.swing.JFrame;

import TiendaOnline.Carrito;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import com.jgoodies.forms.factories.DefaultComponentFactory;


import MediosPago.PayPal;
import MediosPago.TarjetaCredito;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class InterfazAmbas {

	private JFrame frame;
	private Carrito carrito;
	private JTextField Numero_Tarjeta;
	private JTextField Titular_Tarjeta;
	private JTextField Vencimiento_Tarjeta;
	private JTextField Monto_Tarjeta;
	private JPasswordField Codigo_Tarjeta;
	private JTextField user_PayPal;
	private JPasswordField pass_Paypal;
	private JTextField Monto_PayPal;

	
	public InterfazAmbas(Carrito carrito) {
		
		this.carrito=carrito;
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 450, 365);
		 frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().setLayout(null);
			
			JLabel lblCreditCard = DefaultComponentFactory.getInstance().createLabel("Credit Card");
			lblCreditCard.setBounds(42, 51, 120, 16);
			frame.getContentPane().add(lblCreditCard);
			
			JLabel lblNumeroTarjeta = DefaultComponentFactory.getInstance().createLabel("Numero Tarjeta");
			lblNumeroTarjeta.setBounds(6, 79, 120, 16);
			frame.getContentPane().add(lblNumeroTarjeta);
			
			JLabel lblCodigo = DefaultComponentFactory.getInstance().createLabel("Codigo");
			lblCodigo.setBounds(6, 137, 120, 16);
			frame.getContentPane().add(lblCodigo);
			
			JLabel lblTitular = DefaultComponentFactory.getInstance().createLabel("Titular");
			lblTitular.setBounds(6, 187, 120, 16);
			frame.getContentPane().add(lblTitular);
			
			JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Vencimiento");
			lblNewJgoodiesLabel.setBounds(6, 239, 120, 16);
			frame.getContentPane().add(lblNewJgoodiesLabel);
			
			JLabel lblMontoAPagar = DefaultComponentFactory.getInstance().createLabel("Monto a Pagar");
			lblMontoAPagar.setBounds(6, 295, 120, 16);
			frame.getContentPane().add(lblMontoAPagar);
			
			Numero_Tarjeta = new JTextField();
			Numero_Tarjeta.setBounds(6, 97, 130, 26);
			frame.getContentPane().add(Numero_Tarjeta);
			Numero_Tarjeta.setColumns(10);
			
			Titular_Tarjeta = new JTextField();
			Titular_Tarjeta.setBounds(9, 200, 130, 26);
			frame.getContentPane().add(Titular_Tarjeta);
			Titular_Tarjeta.setColumns(10);
			
			Vencimiento_Tarjeta = new JTextField();
			Vencimiento_Tarjeta.setBounds(6, 257, 130, 26);
			frame.getContentPane().add(Vencimiento_Tarjeta);
			Vencimiento_Tarjeta.setColumns(10);
			
			Monto_Tarjeta = new JTextField();
			Monto_Tarjeta.setBounds(6, 311, 130, 26);
			frame.getContentPane().add(Monto_Tarjeta);
			Monto_Tarjeta.setColumns(10);
			
			JLabel lblPaypal = DefaultComponentFactory.getInstance().createLabel("PayPal");
			lblPaypal.setBounds(289, 51, 120, 16);
			frame.getContentPane().add(lblPaypal);
			
			Codigo_Tarjeta = new JPasswordField();
			Codigo_Tarjeta.setBounds(9, 149, 130, 26);
			frame.getContentPane().add(Codigo_Tarjeta);
			
			JLabel lblNewJgoodiesLabel_1 = DefaultComponentFactory.getInstance().createLabel("Usuario");
			lblNewJgoodiesLabel_1.setBounds(264, 79, 120, 16);
			frame.getContentPane().add(lblNewJgoodiesLabel_1);
			
			user_PayPal = new JTextField();
			user_PayPal.setBounds(264, 97, 130, 26);
			frame.getContentPane().add(user_PayPal);
			user_PayPal.setColumns(10);
			
			JLabel lblContrasea = DefaultComponentFactory.getInstance().createLabel("Contraseña");
			lblContrasea.setBounds(264, 137, 120, 16);
			frame.getContentPane().add(lblContrasea);
			
			pass_Paypal = new JPasswordField();
			pass_Paypal.setBounds(264, 149, 130, 26);
			frame.getContentPane().add(pass_Paypal);
			
			JLabel lblNewJgoodiesLabel_2 = DefaultComponentFactory.getInstance().createLabel("Monto a Pagar:");
			lblNewJgoodiesLabel_2.setBounds(264, 187, 120, 16);
			frame.getContentPane().add(lblNewJgoodiesLabel_2);
			
			Monto_PayPal = new JTextField();
			Monto_PayPal.setBounds(264, 200, 130, 26);
			frame.getContentPane().add(Monto_PayPal);
			Monto_PayPal.setColumns(10);
			
			JButton btnConfirmar = new JButton("Confirmar");
			btnConfirmar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(!CamposVacios())
					{
						String passPaypal=new String(pass_Paypal.getPassword());
						String codigoTarjeta = new String(Codigo_Tarjeta.getPassword());
						
						PayPal paypal=new PayPal(user_PayPal.getText(), passPaypal);
						TarjetaCredito tarjeta= new TarjetaCredito
								(Numero_Tarjeta.getText(), Titular_Tarjeta.getText(), codigoTarjeta, Vencimiento_Tarjeta.getText());
						
						int montoTarjeta=Integer.parseInt(Monto_Tarjeta.getText());
						int montoPayPal= Integer.parseInt(Monto_PayPal.getText());
						if(montoPayPal+montoTarjeta==carrito.getMonto())
						{
							
							
							JOptionPane.showMessageDialog(null, "Se ha pagado: $"+carrito.getMonto());
							tarjeta.pagar(montoTarjeta, carrito);
							paypal.pagar(montoPayPal, carrito);
							btnConfirmar.setEnabled(false);
						}
						
						else{
							JOptionPane.showMessageDialog(null, "La suma de ambos montos debe dar: $"+ carrito.getMonto());
						}
						
						
						
						
					}
					
					else 
						JOptionPane.showMessageDialog(null, "Llene todos los campos");
				}
			});
			btnConfirmar.setBackground(Color.RED);
			btnConfirmar.setForeground(Color.RED);
			btnConfirmar.setBounds(267, 273, 117, 29);
			frame.getContentPane().add(btnConfirmar);
			frame.setVisible(true);
			
		
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
	}
	
	public boolean CamposVacios()
	{
		if (Numero_Tarjeta.getText().length()==0)return true;
		if(Codigo_Tarjeta.getPassword().length==0)return true;
		if(Titular_Tarjeta.getText().length()==0)return true;
		if(Vencimiento_Tarjeta.getText().length()==0)return true;
		if(user_PayPal.getText().length()==0)return true;
		if(pass_Paypal.getPassword().length==0)return true;
		else
			return false;
	}
}
