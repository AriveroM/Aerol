import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.sql.rowset.serial.SQLOutputImpl;
import java.util.*;



public class Vuelos
{
    int codigoVuelo;
    String destino;
    int  duracion;
    String horaSalida;
    String horaLlegada;

    Pilots p;
    Avion a;

    int avion;

    int asientos;



    ArrayList<Vuelos> listaDeVuelos = new ArrayList<Vuelos>();
    ArrayList<Vuelos> listaDeReservas = new ArrayList<Vuelos>();

    public Vuelos(int codigoVuelo, String destino, int duracion, String horaSalida, String horaLlegada, Pilots p, Avion a) {

        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.duracion = duracion;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.p = p;
        this.a = a;
    }

    public Vuelos(int asientos,int codigoVuelo, String destino, int duracion, String horaSalida, String horaLlegada, Pilots p, Avion a) {

        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.duracion = duracion;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.p = p;
        this.a = a;
        this.asientos = asientos;
    }
    public static void crearVuelo(ArrayList<Vuelos> listaDeVuelos)
    {
        Vuelos v = null;
        Avion a = new Avion();
        Pilots p = new Pilots();
        Scanner sc = new Scanner(System.in);
        int codigoVuelo;
        String destino;
        int duracion;
        String horaDeSalida;
        Date horaDeLlegada;
        int codigoPiloto;
        int codigoAvion;



       ;

        ArrayList<Pilots> listaPilots = p.getListaPilots();
        ArrayList<Avion> listaAviones = a.getListaAviones();
        a.listaDeAviones(listaAviones);
        p.Pilots(listaPilots);



        System.out.println("Introduce el codigo del vuelo");
        do {
            codigoVuelo = (sc.nextInt()-1);
        }while (codigoVuelo > listaDeVuelos.size());
        System.out.println("Introduce el destino");
        destino = sc.next();
        System.out.println("Cuanto dura?(minutos)");
        duracion = Check.checkInt();
        System.out.println("Hora y fecha de salida? (dd/mm/yyyy hh/mm/ss)");
        horaDeSalida = Check.hora();
        Date horaDeSalida3 = new Date(horaDeSalida);
        horaDeLlegada = new Date(horaDeSalida3.getTime()+duracion*60000);
        System.out.println("Selecciona el avion");
        codigoAvion = Check.checkInt();
        System.out.println("Selecciona al piloto");
        codigoPiloto = Check.checkInt();
        codigoVuelo = codigoVuelo+1;

        listaDeVuelos.add(new Vuelos(codigoVuelo,destino,duracion,horaDeSalida,horaDeLlegada.toString(),listaPilots.get(codigoPiloto),listaAviones.get(codigoAvion)));
        //Main.opcionesAdmin();

    }
    public static void MostrarVuelos(ArrayList<Vuelos> listaDeVuelos)
    {
        int codigoVuelo;
        int salida;
        boolean acabado = false;
        Vuelos v = new Vuelos();
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < listaDeVuelos.size() ; i++)
        {
            System.out.println(listaDeVuelos.get(i).toString());
        }

        salida = sc.nextInt();

        //Main.opcionesAdmin();
    }

    public static void ModificarVuelos(ArrayList<Vuelos> listaDeVuelos)
    {
        Avion a = new Avion();
        Pilots p = new Pilots();
        int codeVuelo = 0;
        Vuelos v = new Vuelos();
        Scanner sc = new Scanner(System.in);

        String destino;
        int duracion;
        String horaDeSalida;
        Date horaDeLlegada;
        int codigoPiloto;
        int codigoAvion;
        int codigoVuelo = 0;

        int opcionMod = 0;
        int opcionesModificacion = 0;

        ArrayList<Pilots> listaPilots = p.getListaPilots();
        ArrayList<Avion> listaAviones = a.getListaAviones();
        a.listaDeAviones(listaAviones);
        p.Pilots(listaPilots);

        Date durada;

        for (int i = 0; i < listaDeVuelos.size() ; i++)
        {
            System.out.println(listaDeVuelos.get(i).toString());
        }

        System.out.println(Colores.BLACK+Colores.WHITE_BACKGROUND+"Que vuelo quieres modificar?"+Colores.RESET);
        System.out.println();
        codeVuelo = Check.checkInt();
        codigoVuelo = codeVuelo;
        codeVuelo = codeVuelo - 1;
        System.out.println();
        System.out.println(Colores.BLACK+Colores.WHITE_BACKGROUND+"Quieres modificarlo entero?"+Colores.RESET);
        System.out.println();
        System.out.println("1-Si                         2-No");
        opcionMod = Check.checkInt();
        if(opcionMod == 1)
        {
            System.out.println("Introduce el nuevo destino");
            destino = sc.next();
            System.out.println("Cuanto dura?(minutos)");
            duracion = Check.checkInt();
            System.out.println("Hora y fecha de salida?");
            horaDeSalida = Check.hora();
            Date horaDeSalida1 = new Date(horaDeSalida);
            horaDeLlegada = new Date(horaDeSalida1.getTime() + duracion * 60000);
            System.out.println("Selecciona el avion");
            codigoAvion = Check.checkInt();
            System.out.println("Selecciona al piloto");
            codigoPiloto = Check.checkInt();
            listaDeVuelos.get(codeVuelo).SetVuelos(codigoVuelo, destino, duracion, horaDeSalida, horaDeLlegada.toString(), listaPilots.get(codigoPiloto), listaAviones.get(codigoAvion));
        }
        if(opcionMod == 2)
        {
            System.out.println(Colores.BLACK+Colores.WHITE_BACKGROUND+"Que apartado quieres modificar"+Colores.RESET);
            System.out.println();
            System.out.println("1-Destino");
            System.out.println();
            System.out.println("2-Duracion");
            System.out.println();
            System.out.println("3-Hora y fecha de salida");
            System.out.println();
            System.out.println("4-Avion");
            System.out.println();
            System.out.println("5-Piloto");
            opcionesModificacion = sc.nextInt();
            if(opcionesModificacion == 1)
            {
                destino = sc.next();
                listaDeVuelos.get(codeVuelo).setDestino(destino);
            }
            if(opcionesModificacion == 2)
            {
                duracion = Check.checkInt();
                horaDeSalida = listaDeVuelos.get(codeVuelo).getHoraSalida();
                Date horaDeSalida1 = new Date(horaDeSalida);
                horaDeLlegada = new Date(horaDeSalida1.getTime() + duracion * 60000);
                listaDeVuelos.get(codeVuelo).setDuracion(duracion);
                listaDeVuelos.get(codigoVuelo).setHoraLlegada(horaDeLlegada.toString());
            }
            if(opcionesModificacion == 3)
            {
                horaDeSalida = Check.hora();
                Date horaDeSalida1 = new Date(horaDeSalida);
                duracion = listaDeVuelos.get(codeVuelo).getDuracion();
                horaDeLlegada = new Date(horaDeSalida1.getTime() + duracion * 60000);
                listaDeVuelos.get(codeVuelo).setHoraSalida(horaDeSalida);
                listaDeVuelos.get(codeVuelo).setHoraLlegada(horaDeLlegada.toString());
            }
            if(opcionesModificacion == 4)
            {
                codigoAvion = Check.checkInt();
                listaDeVuelos.get(codeVuelo).setA(listaAviones.get(codigoAvion));
            }
            if(opcionesModificacion == 5)
            {
                codigoPiloto = Check.checkInt();
                listaDeVuelos.get(codeVuelo).setP(listaPilots.get(codigoPiloto));
            }

        }
        //Main.opcionesAdmin();

    }

    public static void BorrarVuelo(ArrayList<Vuelos> listaDeVuelos)
    {
        int codigoVuelo;
        Vuelos v = new Vuelos();
        Scanner sc = new Scanner(System.in);
        System.out.println("Que vuelo quieres borrar?");
        codigoVuelo = sc.nextInt();
        codigoVuelo = codigoVuelo-1;
        listaDeVuelos.remove(codigoVuelo);
        //Main.opcionesAdmin();
    }

    public static void comprarBilletes(ArrayList<Vuelos> listaDeVuelos, ArrayList<Vuelos> listaDeReservas)
    {
        Scanner sc = new Scanner(System.in);
        int codigoVuelo = 0;
        int avion = 0;
        int asientos = 0;
        int precioBillete = 60;
        int continuar = 0;
        Avion a = new Avion();
        boolean acabado = false;
        boolean hayVuelos = true;



        System.out.println(Colores.BLACK+Colores.WHITE_BACKGROUND+"Estos son los vuelos disponibles" + Colores.RESET);
        System.out.println();
        if(listaDeVuelos.size() == 0)
        {
            System.out.println("No hay vuelos disponibles");
            System.out.println();
            System.out.println("0-Salir");
            hayVuelos = false;
            continuar = Check.checkInt();
        }
        if(hayVuelos)
        {
            for (int i = 0; i < listaDeVuelos.size(); i++) {
                System.out.println(listaDeVuelos.get(i).toString());
            }

            System.out.println();
            do {
                System.out.println(Colores.BLACK + Colores.WHITE_BACKGROUND + "Escoge el vuelo en el que deseas viajar" + Colores.RESET);
                codigoVuelo = Check.checkInt();
                codigoVuelo = codigoVuelo - 1;
            } while (codigoVuelo > listaDeVuelos.size());
            avion = listaDeVuelos.get(codigoVuelo).a.getAsientos();
            do {
                System.out.println(Colores.BLACK + Colores.WHITE_BACKGROUND + "Cuantas asientos quieres comprar?" + Colores.RESET);
                asientos = Check.checkInt();
                if (asientos <= avion) {
                    avion = avion - asientos;
                    listaDeVuelos.get(codigoVuelo).a.setAsientos(avion);
                    precioBillete = precioBillete * asientos;
                    System.out.println(Colores.BLUE_BRIGHT + "El total del precio de tu compra es de " + precioBillete + Colores.RESET);
                    System.out.println();
                    System.out.println(Colores.BLACK + Colores.WHITE_BACKGROUND + "Deseas continuar?" + Colores.RESET);
                    System.out.println();
                    System.out.println("1-yes             2-no");
                    continuar = Check.checkInt();
                } else {
                    System.out.println(Colores.RED + "No hay tantos asientos disponibles" + Colores.RESET);
                }

                if (continuar == 1) {
                    acabado = true;
                    listaDeReservas.add(new Vuelos(asientos, listaDeVuelos.get(codigoVuelo).getCodigoVuelo(), listaDeVuelos.get(codigoVuelo).getDestino(), listaDeVuelos.get(codigoVuelo).getDuracion(), listaDeVuelos.get(codigoVuelo).getHoraSalida(), listaDeVuelos.get(codigoVuelo).getHoraLlegada(), listaDeVuelos.get(codigoVuelo).getP(), listaDeVuelos.get(codigoVuelo).getA())); //Crearte un GetAll
                } else {
                    precioBillete = 90;
                    avion = avion + asientos;
                }

            } while (!acabado);
        }
    }


    public static void VisualizarInformacion(ArrayList<Vuelos> listaDeReservas)
    {
        Scanner sc = new Scanner(System.in);
        int salir = 0;

        for (int i = 0; i < listaDeReservas.size() ; i++)
        {
            System.out.println(listaDeReservas.get(i).toStringDos());
        }
        if(listaDeReservas.size() == 0)
        {
            System.out.println("No tienes vuelos reservados");
            System.out.println();
            System.out.println("0-Salir");
        }
        salir = Check.checkInt();
        System.out.println();
        System.out.println("0-Salir");
    }

    public static void anularReserva(ArrayList<Vuelos> listaDeReservas)
    {
        int salir = 0;
        int codigovuelo  = 0;
        int anular = 0;
        int asientosAnular = 0;
        int sumarAsientosLibres = 0;
        double precioAnular = 0;
        Scanner sc = new Scanner(System.in);


        for (int i = 0; i < listaDeReservas.size() ; i++)
        {
            System.out.println(listaDeReservas.get(i).toStringDos());
        }

        System.out.println(Colores.BLACK + Colores.WHITE_BACKGROUND+"Que vuelo quieres anular?"+ Colores.RESET);
        System.out.println();
        codigovuelo = Check.checkInt();
        codigovuelo = codigovuelo - 1;
        System.out.println(Colores.BLACK + Colores.WHITE_BACKGROUND+"Cuantos asientos quieres anular?"+ Colores.RESET);
        anular = Check.checkInt();
        asientosAnular = listaDeReservas.get(codigovuelo).getAsientos();
        asientosAnular = asientosAnular - anular;
        listaDeReservas.get(codigovuelo).setAsientos(asientosAnular);
        sumarAsientosLibres = listaDeReservas.get(codigovuelo).getAsientos();
        listaDeReservas.get(codigovuelo).setAsientos(sumarAsientosLibres);
        if(listaDeReservas.get(codigovuelo).getAsientos() == 0)
        {
            listaDeReservas.remove(codigovuelo);
        }
        precioAnular = (anular * 60)*(0.5);

        System.out.println("Has anulado " + anular + " billetes, el precio de devolución es un 50% se te han devuelto " + precioAnular + " euros");
        salir = sc.nextInt();
    }


    @Override
    public String toString() {
        return
                "codigo de vuelo = " + codigoVuelo + "|" +
                " destino = " + destino  +"|" +
                " duracion = " + duracion  +"|" +
                " hora de salida = " + horaSalida  +"|" +
                " hora de llegada = " + horaLlegada  +"|" +
                " Piloto: " + p +"|" +
                " Avion: " + a + "|"
                 ;
    }

    public String toStringDos() {
        return

                "asiesntos reservados = " + asientos + "|" +
                "codigo de vuelo = " + codigoVuelo + "|" +
                        " destino = " + destino  +"|" +
                        " duracion = " + duracion  +"|" +
                        " hora de salida = " + horaSalida  +"|" +
                        " hora de llegada = " + horaLlegada  +"|" +
                        " Piloto: " + p +"|" +
                        " Avion: " + a + "|"
                ;
    }

    public int getAvion() {
        return avion;
    }

    public Vuelos() {
    }

    public ArrayList<Vuelos> getListaDeVuelos(ArrayList<Vuelos> listaDeVuelos)
    {

        return listaDeVuelos;
    }
    public static String hora()
    {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        boolean acabado = false;
        //SimpleDateFormat in;
        String fecha;
        do {
            fecha = sc.nextLine();
            try {
                dateFormat.parse(fecha);
                acabado = true;
            } catch (Exception e) {
                System.out.println(Colores.RED+"Fecha no valida"+Colores.RESET);
            }
        }while(!acabado);
        return fecha;
    }



    public void SetVuelos(int codigoVuelo, String destino, int duracion, String horaSalida, String horaLlegada, Pilots p, Avion a) {
        this.codigoVuelo = codigoVuelo;
        this.destino = destino;
        this.duracion = duracion;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.p = p;
        this.a = a;
    }

    public ArrayList<Vuelos> getListaDeReservas(ArrayList<Vuelos> listaDeVuelos)
    {
        return listaDeReservas;
    }

    public String getDestino() {
        return destino;
    }

    public int getDuracion() {
        return duracion;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public Pilots getP() {
        return p;
    }

    public Avion getA() {
        return a;
    }

    public int getCodigoVuelo() {
        return codigoVuelo;
    }

    public int getAsientos() {
        return asientos;
    }

    public void setAsientos(int asientos) {
        this.asientos = asientos;
    }

    public void setCodigoVuelo(int codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public void setP(Pilots p) {
        this.p = p;
    }

    public void setA(Avion a) {
        this.a = a;
    }
}
