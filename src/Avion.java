import java.util.ArrayList;
import java.util.Scanner;

public class Avion {
    private String nombre;
    private String fechaCreacion;
    private String combustible;
    private int asientos;

    ArrayList<Avion> listaAviones = new ArrayList<>();





    public Avion()
    {

    }

    public Avion(String nombre, String fechaCreacion, String combustible, int asientos) {
        this.nombre = nombre;
        this.fechaCreacion = fechaCreacion;
        this.combustible = combustible;
        this.asientos = asientos;
    }

    public static ArrayList<Avion> listaDeAviones(ArrayList<Avion> listaAviones)
    {

        listaAviones.add(new Avion("Boeing 747", "2010", "200.000",189));
        listaAviones.add(new Avion("Boeing 777","2015","250.000", 200));
        listaAviones.add(new Avion("MD-80","2013","150.000", 120));
        listaAviones.add(new Avion("Pilatus PC-6","2018","300.000",250));
        listaAviones.add(new Avion("Airbus A380","2017","250.000",120));
        return listaAviones;
    }

    public static void MostrarAviones(ArrayList<Avion> listaAviones)
    {
        int salir;
        boolean acabado = false;
        listaAviones = listaDeAviones(listaAviones);
        Scanner sc = new Scanner(System.in);

        do {
            for (int i = 0; i < listaAviones.size(); i++) {
                System.out.println(listaAviones.get(i).allToString() + " ");
            }
            salir = sc.nextInt();
            if(salir == 0)
            {
                acabado = true;
            }
        }while(!acabado);
    }

    public ArrayList<Avion> getListaAviones()
    {
        return listaAviones;
    }

    @Override
    public String toString() {
        return
                 nombre + " " + "|" + " asientos: " + asientos;
    }


    public String allToString() {
        return
                nombre + " " + "   fechaCreacion: " + fechaCreacion + "   combustible: " + combustible +
                        "   asientos: " + asientos;
    }

    public int getAsientos()
    {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }
}




