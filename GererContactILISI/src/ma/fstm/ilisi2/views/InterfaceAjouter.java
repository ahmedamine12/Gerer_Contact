package ma.fstm.ilisi2.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi2.controllers.ContactController;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfaceAjouter extends JFrame {
	private JFrame context=this;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public InterfaceAjouter(Accueil a) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(22, 47, 74, 14);
		contentPane.add(lblNewLabel);
		
		JTextArea Nom = new JTextArea();
		Nom.setBounds(128, 42, 110, 22);
		contentPane.add(Nom);
		
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom ");
		lblPrnom.setBounds(22, 83, 74, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblNumro = new JLabel("Num\u00E9ro ");
		lblNumro.setBounds(22, 123, 74, 14);
		contentPane.add(lblNumro);
		
		JTextArea Prenom = new JTextArea();
		Prenom.setBounds(128, 78, 110, 22);
		contentPane.add(Prenom);
		
		JTextArea Numero = new JTextArea();
		Numero.setBounds(128, 118, 110, 22);
		contentPane.add(Numero);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactController ctrContact = new 	ContactController();
				ctrContact.ajouterContact(Nom.getText(),Prenom.getText(),Numero.getText());
				a.creer_tableau();
				context.dispose();
				
			}
		});
		btnNewButton.setBounds(123, 197, 89, 23);
		contentPane.add(btnNewButton);
	}
}
