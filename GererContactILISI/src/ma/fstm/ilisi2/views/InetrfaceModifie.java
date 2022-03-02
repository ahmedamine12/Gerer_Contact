package ma.fstm.ilisi2.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi2.controllers.ContactController;
import ma.fstm.ilisi2.models.bo.Contact;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InetrfaceModifie extends JFrame {

	private JPanel contentPane;
	private ContactController CtrModif = new ContactController();
	JFrame Context=this;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public InetrfaceModifie(Contact c , Accueil a) 
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea Nom = new JTextArea();
		Nom.setBounds(141, 50, 83, 22);
		Nom.setText(c.getNom());
		contentPane.add(Nom);
		
		JTextArea Prenom = new JTextArea();
		Prenom.setBounds(141, 96, 83, 22);
		Prenom.setText(c.getPrenom());
		contentPane.add(Prenom);
		
		JTextArea Numero = new JTextArea();
		Numero.setBounds(141, 140, 83, 22);
		Numero.setText(c.getNumero());
		contentPane.add(Numero);
		
		JLabel lblNewLabel = new JLabel("Nom");
		lblNewLabel.setBounds(38, 55, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblPrnom = new JLabel("Pr\u00E9nom ");
		lblPrnom.setBounds(38, 101, 46, 14);
		contentPane.add(lblPrnom);
		
		JLabel lblNumro = new JLabel("Num\u00E9ro ");
		lblNumro.setBounds(38, 145, 46, 14);
		contentPane.add(lblNumro);
		
		JButton btnNewButton = new JButton("Confirmer Modification");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CtrModif.ConfirModifie(Nom.getText(), Prenom.getText(), Numero.getText(), c.getId());
				a.creer_tableau();
				Context.dispose();
				
			}
		});
		btnNewButton.setBounds(206, 204, 162, 23);
		contentPane.add(btnNewButton);
	}

}
