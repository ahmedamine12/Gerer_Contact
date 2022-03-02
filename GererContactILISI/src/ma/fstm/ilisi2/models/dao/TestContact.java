package ma.fstm.ilisi2.models.dao;
import java.sql.Connection;

import ma.fstm.ilisi2.models.bo.Contact;


public class TestContact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Connection conn =ConnectionBD.getCon();
Contact c =new Contact("Bouricha","Ali","0677992837");
Contact c1 =new Contact("Bouricha","Ahmed","0610474696");
CrudContact crud =new CrudContact();
//crud.ajouterConatact(c);
//crud.supprimerContact(1);
crud.modifierContact(c);
	}

}
