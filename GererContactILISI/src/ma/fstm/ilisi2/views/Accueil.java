package ma.fstm.ilisi2.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ma.fstm.ilisi2.controllers.ContactController;
import ma.fstm.ilisi2.models.bo.Contact;

import java.util.Collection;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextPane;

public class Accueil extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model ;
	private ContactController ContactCtr = new ContactController();
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Accueil frame = new Accueil();
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
	public void addContactstoModel(JTable table,Collection<Contact> contacts) {
		model=(DefaultTableModel)table.getModel();
		for(Contact contact:contacts) {
			model.addRow(new Object[] {contact.getId(),
					contact.getNom() +"    "+
					contact.getPrenom()+"    "+
					contact.getNumero()
					});
		}
	}
	
	public void creer_tableau( )
	{
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"id", "Contacts"
				}
			) {
				Class[] columnTypes = new Class[] {
					Integer.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
			table.getColumnModel().getColumn(0).setPreferredWidth(0);
			table.getColumnModel().getColumn(0).setMinWidth(0);
			table.getColumnModel().getColumn(0).setMaxWidth(0);
			
			addContactstoModel(table,ContactCtr.getAllContacts() );
	}

	public Accueil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(335, 11, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactController control = new ContactController();
				control.ajouterInterface(Accueil.this);
				
			}
		});
		
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 62, 399, 147);
		contentPane.add(scrollPane);
		
		table = new JTable();
		creer_tableau();
	
		scrollPane.setViewportView(table);
		btnNewButton_1 = new JButton("Supprimer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int row = table.getSelectedRow();
				if(row!=-1)
				{
					int id=(int)table.getValueAt(row,0);
					JOptionPane.showMessageDialog(null,"Etes vous sur de supprimmer", "Confirmation", JOptionPane.PLAIN_MESSAGE);
					ContactCtr.SupprimContact(id);
					while(model.getRowCount()>0)	model.removeRow(0);
					//Collection<Contact> contact=ContactCtr.getAllContacts();
					addContactstoModel(table,ContactCtr.getAllContacts() );
				}
				
			}
		});
		btnNewButton_1.setBounds(65, 227, 89, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Modifier");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if(row!=-1)
				{
					int id=(int)table.getValueAt(row,0);
					ContactCtr.ModifierInterface(id,Accueil.this);
					while(model.getRowCount()>0)	model.removeRow(0);
					//Collection<Contact> contact=ContactCtr.getAllContacts();
					addContactstoModel(table,ContactCtr.getAllContacts() );
				}
				
					
			}
		});
		btnNewButton_2.setBounds(257, 227, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JTextPane ChercheZone = new JTextPane();
		ChercheZone.setBounds(31, 11, 110, 20);
		contentPane.add(ChercheZone);
		
		JButton BtnChertche = new JButton("Chercher ");
		BtnChertche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					String mot = ChercheZone.getText();
					Collection<Contact>  nouveaulist = ContactCtr.ChercheClavier(mot);
					if(nouveaulist!=null) {
						while(model.getRowCount()>0)	model.removeRow(0);
						addContactstoModel(table, nouveaulist);
					

				}
				
			}
		});
		BtnChertche.setBounds(166, 11, 89, 23);
		contentPane.add(BtnChertche);
	}
}
