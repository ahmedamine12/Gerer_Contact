package ma.fstm.ilisi2.models.dao;
import java.util.Collection;
import ma.fstm.ilisi2.models.bo.Contact;

public interface ICrudContact {
boolean ajouterConatact(Contact contact);
boolean supprimerContact(int id);
boolean modifierContact(Contact contact);
public Contact rechercheID(int id);
Collection<Contact> ToutConatct();
Collection<Contact> rechercheClavier(String keyword);


}
