import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class pedidoList{

	ArrayList<PersonaDeInteres> PersonaDeInteresList = new ArrayList<PersonaDeInteres>();
	PersonaDeInteresList objPersona = new PersonaDeInteresList();
	
	static ArrayList<EscuelaAcademica> escuelaList = new ArrayList();

	//  variables validaciones
	private String datoIngreso, letraValido;
	private int numValido;  

	// Datos iniciales del arreglo lista escuela
	public void escuelaInicio(){
		escuelaList.add(new EscuelaAcademica(1,"Escuela de Ciencias y Tecnología",2022001));
		escuelaList.add(new EscuelaAcademica(2,"Escuela de Humanidades y Ciencias Sociales",2022002));
	}

	// Solicitar entrada de texto
	public String input(String texto){
		System.out.println(texto);
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	// Comprobar que sea número
	public int serNumero(String datoIngreso){
		String contenido = datoIngreso;
		Pattern patron = Pattern.compile("[0-9]{1,7}");
		Matcher matcher = patron.matcher(contenido);
		boolean resultado = matcher.matches();		
			
		if (resultado == true){
			numValido = Integer.parseInt(contenido);
		} else {
			numValido = 0;
		};
		return numValido;
	}

	// Comprobar que sean letras
	public String serLetras(String datoIngreso){
		String contenido = datoIngreso;
		Pattern patron = Pattern.compile(".+[0-9]+.+");
		Matcher matcher = patron.matcher(contenido);
		boolean resultado = matcher.matches();		
			
		if (resultado == false){
			letraValido = contenido;
		} else {
			letraValido = "0";
		};
		return letraValido;
	}

	// Buscar por codigo de escuela
	public boolean existeCodigo(int datoIngreso){
		boolean existe= false;
		for (int i=0; i< escuelaList.size(); i++){
			if(escuelaList.get(i).getCodigo() == datoIngreso){
				existe= true;
			}
		} return existe;
	}

	// Buscar por nombre de escuela
	public boolean existeNombre(String datoIngreso){
		boolean existe= false;
		for (int i=0; i< escuelaList.size(); i++){
			if(escuelaList.get(i).getNombre().trim().equals(datoIngreso)){
				existe= true;
			}
		} return existe;
	}

	// Buscar por codigo de persona de interes
	public boolean existePersona(String datoIngreso){
		String inputBuscar = datoIngreso;
		int BuscarPersona = Integer.parseInt(inputBuscar);
		boolean existe= false;
		for (int i=0; i< escuelaList.size(); i++){
			if(escuelaList.get(i).getPersona() == BuscarPersona){
				existe= true;
			}
		} return existe;
	}

	// Busca el Codigo de la Escuela y regresa la posición de esta en el arreglo
	public int posicionCodigo(int CodigoBuscado){
		int inputBuscar = CodigoBuscado;
		int poss=-1;
		for (int i=0; i< escuelaList.size(); i++){
			if(escuelaList.get(i).getCodigo() == inputBuscar){
				poss=i;
			}
		}	
		return poss;
	}

	// Describir escuela por su posición
	public String describirEscuela(int posicion){
		String string = ("\tNo.: " +(posicion+1) +
			"\t\tCodigo: " + escuelaList.get(posicion).getCodigo() +
			"\n\tNombre: " + escuelaList.get(posicion).getNombre() +
			"\n\tDecano: " + objPersona.describirNombre(objPersona.posicionCodigo(escuelaList.get(posicion).getPersona())) +
			"\n---------------------------------------------------------------------------\n");
		return string;
	}

	// Describir nombre de la escuela por su posición
	public String describirNombre(int posicion){
		String string = (escuelaList.get(posicion).getNombre());
		return string;
	}

	// Visualizar el contenido del listado de escuelas
	public void verEscuela(){
		System.out.println("\n--------------- ESCUELAS ACADÉMICAS --------------");
		System.out.println("---------------------------------------------------------------------------\n");
		for (int i=0; i< escuelaList.size(); i++){
			System.out.println(describirEscuela(i));
		}
		System.out.println("----------------------- FIN ----------------------");
	}

	// Visualizar el contenido del listado de escuelas código - nombre
	public void verListaEscuela(){
		for (int i=0; i< escuelaList.size(); i++){
			System.out.println("\t\tCodigo: " + escuelaList.get(i).getCodigo() + " " + escuelaList.get(i).getNombre());
			}
	}

	// Buscar escuela por su código
	public void buscarEscuela(){
		System.out.println("\n\t----- Buscar Escuela Académica por Número de código -----");
		int inputBuscar = serNumero(input("\n\tIngrese el código de la Escuela Académica que desea buscar"));

		// Buscando el código
		int poss = posicionCodigo(inputBuscar);

		// Devoler dato
		if(poss!=-1){
			System.out.println("\tSe ha encontrado la Escuela Académica:\n");
			System.out.println(describirEscuela(poss));
		}else{
			System.out.println("\t***EL ELEMENTO BUSCADO NO SE ENCUENTRA EN LA LISTA***");
		}		
	}

	// Agregar nueva escuela
	public void agregarEscuela(){
		System.out.println("\n\t----- Agregar una nueva Escuela Académica --------");
		int Codigo = serNumero(input("\n\tIngrese el código de la nueva Escuela Académica"));
		boolean repetidoCodigo = existeCodigo(Codigo);		

		if (repetidoCodigo == true){
			System.out.println("\n\t***ESTE CÓDIGO YA EXISTE EN LA BASE DE DATOS***");
		} else 	if (Codigo == 0){
			System.out.println("\t***EL CÓDIGO DE LA ESCUELA INGRESADA NO ES VALIDO***");
		} else {
			String Nombre = serLetras(input("\n\tIngrese el nombre de la nueva Escuela Académica"));
			boolean repetidoNombre = existeNombre(Nombre);
			if (repetidoNombre == true){
				System.out.println("\t***ESTE NOMBRE YA EXISTE EN LA BASE DE DATOS***");
			} else if (Nombre == "0"){
				System.out.println("\t***EL NOMBRE DE LA ESCUELA NO DEBE LLEVAR CARACTERES NUMÉRICOS***");
			} else if (Nombre.trim().isEmpty()== true){
				System.out.println("\t***EL NOMBRE NO DEBE QUEDAR VACIO***");
			} else {
				System.out.println("\n\tIngrese el código de la persona de interes asociada a la nueva Escuela Académica\n\nSugerencias:");
				System.out.println(objPersona.verListaPersona(1));
				int Persona = serNumero(input("\n"));
				boolean repetidoPersona = existePersona(Integer.toString(Persona));
				if (objPersona.existeCodigo(Persona)== false){
					System.out.println("\t***EL CÓDIGO DE LA PERSONA INGRESADO NO EXISTE EN LA BASE DE DATOS***");
				}else if (repetidoPersona == true){
					System.out.println("\t***ESTA PERSONA YA ESTA ASOCIADA A OTRA ESCUELA ACADÉMICA***");
				}else if (Persona == 0){
					System.out.println("\t***EL CÓDIGO DE LA PERSONA INGRESADA NO ES VALIDO***");
				}else {
					EscuelaAcademica escuela = new EscuelaAcademica(Codigo,Nombre,Persona);
					escuelaList.add(escuela);
					System.out.println("\n\t--- Se ha agregado una nueva Escuela Académica ---");
					int poss = posicionCodigo(Codigo);
					System.out.println(describirEscuela(poss));
				}	
			}
		}
	}

	// Modificar el nombre de una escuela del listado
	public void modificarNombreEscuela(){
		System.out.println("\n\t----- Modificar Nombre de la Escuela Académica -----\n\nSugerencias:");
		verListaEscuela();
		int ModificarElemento = serNumero(input("\n-----Ingrese el código de la Escuela Académica que desea modificar-----"));
		int poss = posicionCodigo(ModificarElemento);	
		
		if(poss!=-1){
			System.out.println(describirEscuela(poss));
			String Nombre = input("\tIngrese el nuevo nombre de la nueva Escuela Académica");
			boolean repetidoNombre = existeNombre(Nombre);
			
			if (repetidoNombre == true){
				System.out.println("\t***ESTE NOMBRE YA EXISTE EN LA BASE DE DATOS***");
			} else if (Nombre == "0"){
				System.out.println("\t***EL NOMBRE DE LA ESCUELA NO DEBE LLEVAR CARACTERES NUMÉRICOS***");
			} else if (Nombre.trim().isEmpty()== true){
				System.out.println("\t***EL NOMBRE NO DEBE QUEDAR VACIO***");
			} else {
				escuelaList.get(poss).setNombre(Nombre);
				System.out.println("\tNueva información de la Escuela Académica:\n");
				System.out.println(describirEscuela(poss));	
			}
		} else {
			System.out.println("\t***EL ELEMENTO BUSCADO NO SE ENCUENTRA EN LA LISTA***");
		}
	}

	// Modificar la persona de una escuela del listado
	public void modificarPersonaEscuela(){
		System.out.println("\n\t-----Asignar/Modificar Rector la Escuela Académica-----\n\nSugerencias:");
		verListaEscuela();
		int ModificarElemento = serNumero(input("\n-----Ingrese el código de la Escuela Académica que desea modificar-----"));
		int poss = posicionCodigo(ModificarElemento);	

		if(poss!=-1){
			System.out.println(describirEscuela(poss));
			System.out.println("\n\tIngrese el código de la persona de interes asociada a la nueva Escuela Académica\n\nSugerencias:");
			System.out.println(objPersona.verListaPersona(1));
			int Persona = serNumero(input("\n"));
			boolean repetidoPersona = existePersona(Integer.toString(Persona));

			if (objPersona.existeCodigo(Persona)== false){
				System.out.println("\t***EL CÓDIGO DE LA PERSONA INGRESADO NO EXISTE EN LA BASE DE DATOS***");
			}else if (repetidoPersona == true){
				System.out.println("\t***ESTA PERSONA YA ESTA ASOCIADA A OTRA ESCUELA ACADÉMICA***");
			}else if (Persona == 0){
				System.out.println("\t***EL CÓDIGO DE LA PERSONA INGRESADA NO ES VALIDO***");
			}else {
				escuelaList.get(poss).setPersona(Persona);
				System.out.println("\tNueva información de la Escuela Académica:\n");
				System.out.println(describirEscuela(poss));
			}
			} else {
				System.out.println("\t***EL ELEMENTO BUSCADO NO SE ENCUENTRA EN LA LISTA***");
		}	
	}

	// Eliminar escuela
	public void eliminarEscuela(){

		ArrayList<Carrera> CarreraList = new ArrayList<Carrera>();
		CarreraList objCarrera = new CarreraList();
		
		System.out.println("\n\t----- Eliminar una Escuela Académica -------------\n\nSugerencias:");
		verListaEscuela();
		int inputEliminar = serNumero(input("\n\tIngrese el código de la Escuela Académica que desea eliminar"));

		int poss = posicionCodigo(inputEliminar);

		// Eliminar informacion
		String string;
		if(poss!=-1){
			string = describirEscuela(poss);
			escuelaList.remove(poss);	
			System.out.println("\tSe ha eliminado la Escuela Académica: ");
			System.out.println(string);
			
			objCarrera.buscarCarreraEscuela(inputEliminar);
			
			if ((objCarrera.existeEscuela(inputEliminar))== true){
				objCarrera.eliminarEscuela(inputEliminar);
			}
		}else{
			System.out.println("\t***EL ELEMENTO BUSCADO NO SE ENCUENTRA EN LA LISTA***");
		}	
	}

	// Menú de opciones para administrar Escuela Académicas 
	public void menuEscuela(){
		EscuelaAcademicaList objEscuela = new EscuelaAcademicaList();
		
		byte opcion;
		byte numValido = 0;   
   
		do{
			Scanner menuScanner = new Scanner(System.in);		
			System.out.println("\n"
				   +"\t\t------------- Menú Escuela Académica -------------\n\n"
				   +"\t\t1. Ver Escuelas Academicas\n"
				   +"\t\t2. Buscar Escuela Académica\n"
				   +"\t\t3. Agregar Escuela Académica\n"
				   +"\t\t4. Modificar el nombre de la Escuela Académica\n"
				   +"\t\t5. Asignar Rector a la Escuela Académica\n"
				   +"\t\t6. Eliminar Escuela Académica\n"
				   +"\t\t7. Regresar al menú principal\n"
				   +"\t\t--------------------------------------------------\n");

			String contenido = menuScanner.nextLine();

			if (contenido.trim().isEmpty()== true){
				numValido = 0;
				System.out.println("\n\t***NO DEBE INGRESAR ESPACIOS EN BLANCO***");
			} else {		
				Pattern patron = Pattern.compile("[0-9]{0,2}");
				Matcher matcher = patron.matcher(contenido);
				boolean resultado = matcher.matches();

				if (resultado == true){
					numValido = Byte.parseByte(contenido);
				} else {
					numValido = 0;
				};
			};
			
			opcion = numValido;
		   
		   switch(opcion){
			  case 1:
				 objEscuela.verEscuela();
				 break;
			  case 2:
				 objEscuela.buscarEscuela();
				 break; 
			  case 3:
				 objEscuela.agregarEscuela();
				 break;
			  case 4:
				 objEscuela.modificarNombreEscuela();
				 break;
			  case 5:
				 objEscuela.modificarPersonaEscuela();
				 break; 
			  case 6:
				 objEscuela.eliminarEscuela();
				 break;
			  case 7:
				 System.out.println("\n");
				 break;
			  default:
				 System.out.println("\n\t----***OPCIÓN NO VÁLIDA**----");
				 break;
		   }
		}while(opcion!=7);
	}
}