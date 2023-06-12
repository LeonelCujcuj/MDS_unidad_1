public class cliente{
	// Atributos
	private int ID_cliente;	
	private String Nombres, Apellidos, Email, Direccion;
	
	// Constructor
	public cliente(int ID_cliente, String Nombres, String Apellidos, String Email, String Direccion){
		this.ID_cliente = ID_cliente;
		this.Nombres = Nombres;
		this.Apellidos = Apellidos;
		this.Email = Email;
		this.Direccion = Direccion;
	}
	
	// Getters	
	public int getID_cliente(){
		return ID_cliente;
	}
	public String getNombres(){
		return Nombres;
	}	
	public String getApellidos(){
		return Apellidos;
	}
	public String getEmail(){
		return Email;
	}
	public String getDireccion(){
		return Direccion;
	}

	// Setters
	public void setID_cliente(int ID_cliente){
		this.ID_cliente = ID_cliente;
	}
	public void setNombres(String Nombres){
		this.Nombres = Nombres;	
	}
	public void setApellidos(String Apellidos){
		this.Apellidos = Apellidos;
	}
	public void setEmail(String Email){
		this.Email = Email;
	}
	public void setDireccion(String Direccion){
		this.Direccion = Direccion;
	}
}

