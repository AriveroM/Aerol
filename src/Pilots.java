import java.util.ArrayList;
import java.util.Scanner;

public class Pilots
{
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String codiPilot;
    private String dataNacimiento;

    ArrayList<Pilots> listaPilots = new ArrayList<Pilots>();

    public Pilots() {
    }

    public Pilots(String nombre, String apellido, String dni, String telefono, String codiPilot, String dataNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.codiPilot = codiPilot;
        this.dataNacimiento = dataNacimiento;
    }

    public static void MostrarPilotos(ArrayList<Pilots> listaPilots)
    {
        listaPilots = Pilots(listaPilots);
        int salir;
        boolean acabado = false;
        Scanner sc = new Scanner(System.in);


        do {
            for (int i = 0; i < listaPilots.size(); i++) {
                System.out.println(listaPilots.get(i).allToString() + " ");
            }
            salir = sc.nextInt();
            if(salir == 0)
            {
                acabado = true;
            }
        }while(!acabado);
    }

    public static ArrayList<Pilots> Pilots(ArrayList<Pilots> listaPilots)
    {

        listaPilots.add(new Pilots("Alex","Campos","46576026D","661552526","1","05/12/96"));
        listaPilots.add(new Pilots("Mi","mama","26546182K","65145621","2","05/11/93"));
        return listaPilots;
    }

    public ArrayList<Pilots> getListaPilots() {
        return listaPilots;
    }

    @Override
    public String toString() {
        return
                 nombre +" "+
                 apellido

                ;
    }


    public String allToString() {
        return
                "nombre: "+ nombre +"   apellido: " + apellido +
                "   dni: " + dni +
                "   telefono: " + telefono +
                "   Codigo: " + codiPilot +
                "   Fecha de nacimiento: " + dataNacimiento
               ;
    }
}
