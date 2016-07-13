package Ventanas;



import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import TiendaOnline.Carrito;

import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class SeleccionarPago {

	private JFrame frame;
	private Carrito carrito;


	public SeleccionarPago(Carrito carrito) {
		this.carrito=carrito;
		initialize();

	}


	private void initialize() {

		frame = new JFrame();
		frame.setBounds(0, 0, 450, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);




		JLabel lblSeleccioneSuForma = new JLabel("Seleccione su forma de pago");
		lblSeleccioneSuForma.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 15));
		lblSeleccioneSuForma.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccioneSuForma.setBounds(135, 6, 225, 29);
		frame.getContentPane().add(lblSeleccioneSuForma);

		JButton btnAmbos = new JButton("Pagar");

		JCheckBox TarjetaCredito = new JCheckBox("Tarjeta Credito");
		TarjetaCredito.setBounds(167, 133, 128, 23);
		frame.getContentPane().add(TarjetaCredito);

		JCheckBox Paypal = new JCheckBox("PayPal");
		Paypal.setBounds(167, 94, 128, 23);
		frame.getContentPane().add(Paypal);

		btnAmbos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {




				if(TarjetaCredito.isSelected()&&!Paypal.isSelected()) {

					new InterfazTarjeta(carrito);
					frame.setVisible(false);
				}

				if(!TarjetaCredito.isSelected()&&Paypal.isSelected()) {

					new InterfazPaypal(carrito);
					frame.setVisible(false);
				}

				if(TarjetaCredito.isSelected()&&Paypal.isSelected()) {

					new InterfazAmbas(carrito);
					frame.setVisible(false);
				}

				if(!TarjetaCredito.isSelected()&&!Paypal.isSelected()) {

					JOptionPane.showMessageDialog(null, "Seleccione al menos una opcion");
				}

			}
		});
		btnAmbos.setBounds(309, 132, 117, 29);
		frame.getContentPane().add(btnAmbos);

		JLabel lblSuMontonA = new JLabel("Su monton a pagar es de: $"+carrito.CalcularTotal());
		lblSuMontonA.setBounds(153, 66, 225, 16);
		frame.getContentPane().add(lblSuMontonA);



		JLabel img = new JLabel(" "); 


		ImageIcon image = new ImageIcon("carrito.png"); 

		img.setIcon(image); 
		img.setSize(123,108); 
		img.setLocation(0,0); 
		img.setVisible(true); 
		img.createVolatileImage(50, 50);
		frame.getContentPane().add(img);
		
		JLabel lblParaPagarCombinado = new JLabel("Para pagar combinado tilde ambas opciones");
		lblParaPagarCombinado.setFont(new Font("Lucida Grande", Font.PLAIN, 7));
		lblParaPagarCombinado.setBounds(192, 156, 168, 16);
		frame.getContentPane().add(lblParaPagarCombinado);





		frame.setVisible(true);
	}
}
