public class empleado{
	// Atributos
	private int ID_empleado;	
	private String Nombres, Apellidos, Email, Direccion, Password;
	
	// Constructor
	public empleado(int ID_empleado, String Nombres, String Apellidos, String Email, String Direccion, String Password){
		this.ID_empleado = ID_empleado;
		this.Nombres = Nombres;
		this.Apellidos = Apellidos;
		this.Email = Email;
		this.Direccion = Direccion;
		this.Password = Password;
	}
	
	// Getters	
	public int getID_empleado(){
		return ID_empleado;
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
	public String getPassword(){
		return Password;
	}

	// Setters
	public void setID_empleado(int ID_empleado){
		this.ID_empleado = ID_empleado;
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
	public void setPassword(String Password){
		this.Password = Password;
	}
}