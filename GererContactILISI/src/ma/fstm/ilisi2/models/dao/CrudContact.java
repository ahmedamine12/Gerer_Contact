package ma.fstm.ilisi2.models.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import ma.fstm.ilisi2.models.bo.Contact;

public class CrudContact implements ICrudContact {
	Connection conn =ConnectionBD.getCon(); 
	@Override
	public boolean ajouterConatact(Contact contact) {
		// TODO Auto-generated method stub
	
		try {
			PreparedStatement requete =conn.prepareStatement("insert into contact(nom,prenom,numero) values(?,?,?)");
			requete.setString(1, contact.getNom());
			requete.setString(2, contact.getPrenom());
			requete.setString(3, contact.getNumero());
			requete.executeUpdate();
			return true;
		}catch (Exception e) 
		{
			e.printStackTrace();
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean supprimerContact(int id) {
		
		// TODO Auto-generated method stub
		try {
			PreparedStatement requete = conn.prepareStatement("delete from contact where id=?");
			requete.setInt(1, id);
			requete.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean modifierContact(Contact contact) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement requete= conn.prepareStatement("update contact set nom=?"+
					", prenom=? ,numero=? where id=?");
			requete.setString(1, contact.getNom());
			requete.setString(2, contact.getPrenom());
			requete.setString(3, contact.getNumero());
			requete.setInt(4, contact.getId());
			requete.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	
	}

	@Override
	public Contact  rechercheID(int id) 
	{
		// TODO Auto-generated method stub
		
			try {
				PreparedStatement requete =conn.prepareStatement("select * from contact"+
						" where id=?");
				requete.setInt(1,id);
				ResultSet resultat = requete.executeQuery();
				if(resultat.next())
				{
					String nom= resultat.getString("nom");
					String prenom= resultat.getString("prenom");
					String numero= resultat.getString("numero");
					Contact contact = new Contact(nom, prenom, numero);
				
				contact.setId(id);
				return contact;
				}
				return null;
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		return null;
	}
	
	// stocker le resultat de la requete dans une collection des contacts
	public Collection<Contact> getCollectionFromPreparedStatement(PreparedStatement requete) throws SQLException{
		ResultSet rs=requete.executeQuery();
		Collection<Contact> contacts=new ArrayList<>();
		while(rs.next()) 
		{
			int id=rs.getInt("id");
			String nom=rs.getString("nom");
			String prenom=rs.getString("prenom");
			String numero=rs.getString("numero");
			Contact contact=new Contact(nom,prenom,numero);
			contact.setId(id);
			contacts.add(contact);
		}
		return contacts;
	}

	@Override
	public Collection<Contact> ToutConatct() {
		
		try {
			PreparedStatement requete=conn.prepareStatement("select * from contact");
			return this.getCollectionFromPreparedStatement(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Collection<Contact> rechercheClavier(String motTape) {
		// TODO Auto-generated method stub
		
		try {
			PreparedStatement requete = conn.prepareStatement("select* from contact where nom like ?"+
		"or prenom like ?"+" or numero like ?");
			requete.setString(1, "%"+motTape+"%");
			requete.setString(2, "%"+motTape+"%");
			requete.setString(3, "%"+motTape+"%");
			return getCollectionFromPreparedStatement(requete);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
