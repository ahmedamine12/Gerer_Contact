package ma.fstm.ilisi2.models.bo;

public class Contact {
	
	private int id ;
	private String numero;
	private String nom ;
	private String prenom;
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getId()
	{
		return this.id;
	}
	public void setId(int id2 )
	{
		this.id=id2;
	}
	public Contact() {}
	public Contact(String nom,String prenom,String numero)
	{
		this.id++;
		this.nom=nom;
		this.prenom=prenom;
		this.numero=numero;
	}
	@Override
	public String toString() 
	{
		// TODO Auto-generated method stub
		return "[id="+id+",nom="+nom+",prenom="+prenom+",numero="+numero+"]";
	}
	
	
	

}
