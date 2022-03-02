package ma.fstm.ilisi2.controllers;

import java.util.Collection;

import ma.fstm.ilisi2.models.bo.Contact;
import ma.fstm.ilisi2.models.dao.CrudContact;
import ma.fstm.ilisi2.models.dao.ICrudContact;
import ma.fstm.ilisi2.views.Accueil;
import ma.fstm.ilisi2.views.InetrfaceModifie;
import ma.fstm.ilisi2.views.InterfaceAjouter;

public class ContactController 
{
	
	
	
	
	
	private ICrudContact myContact;
	
	public ContactController() {
		myContact = new CrudContact();
		
	}
	public Collection<Contact> getAllContacts(){
		return myContact.ToutConatct();
	}
	public void ajouterInterface(Accueil a)
	{
		InterfaceAjouter InterAjout = new InterfaceAjouter(a);
		InterAjout.setVisible(true);
	}
	public void ajouterContact(String nom,String prenom,String numero)
	{
		
		myContact.ajouterConatact(new Contact(nom,prenom,numero));
	}
	
	public void ModifierInterface(int id , Accueil a )
	{
		Contact c = myContact.rechercheID(id);
		InetrfaceModifie IntMo = new InetrfaceModifie(c,a );
		IntMo.setVisible(true);
	}
	public void ConfirModifie(String nom,String prenom,String numero,int id )
	{
		Contact c =new Contact(nom,prenom,numero);
		c.setId(id);
		myContact.modifierContact(c);
		
	}
	public void SupprimContact(int id )
	{
		myContact.supprimerContact(id);
		
	}
	
	public Collection<Contact> ChercheClavier(String mot)
	{
		
		return  myContact.rechercheClavier(mot);
	}
	

}
