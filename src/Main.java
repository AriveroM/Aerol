import javax.sql.rowset.serial.SQLOutputImpl;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Robot;
import java.awt.AWTException;
import java.awt.event.KeyEvent;

public class Main {
    public static void main(String[] args)
    {
        Admin ad;
        Vuelos v = new Vuelos();
        Avion a = new Avion();
        Pilots p = new Pilots();
        ad = new Admin();
        boolean correcto = false;
        int opcion = 0;
        int elegirOpcion = 0;
        int eligeCliente = 0;
        boolean acabado = false;
        ArrayList<Vuelos> listaDeVuelos = new ArrayList<Vuelos>();
        ArrayList<Vuelos> listaDeReservas;
        ArrayList<Avion> listaAviones;
        ArrayList<Pilots> listaPilots;


        listaPilots = p.getListaPilots();
        listaAviones = a.getListaAviones();
        listaDeVuelos = v.getListaDeVuelos(listaDeVuelos);
        listaDeReservas = v.getListaDeReservas(listaDeVuelos);

        opcion = menu(ad,correcto);
        if(opcion == 1)
        {
            correcto = menuAdmin(ad);
            do{
                limpiarConsola();
                delay(5);
                if(correcto)  elegirOpcion = opcionesAdmin();
                switch (elegirOpcion) {
                    case 1:
                        limpiarConsola();
                        delay(5);
                        Vuelos.crearVuelo(listaDeVuelos);
                        break;
                    case 2:
                        limpiarConsola();
                        delay(5);
                        Vuelos.MostrarVuelos(listaDeVuelos);
                        break;
                    case 3:
                        limpiarConsola();
                        delay(5);
                        Vuelos.ModificarVuelos(listaDeVuelos);
                        break;
                    case 4:
                        limpiarConsola();
                        delay(5);
                        Vuelos.BorrarVuelo(listaDeVuelos);
                        break;
                    case 5:
                        limpiarConsola();
                        delay(5);
                        Avion.MostrarAviones(listaAviones);
                        break;
                    case 6:
                        limpiarConsola();
                        delay(5);
                        Pilots.MostrarPilotos(listaPilots);
                        break;
                    case 0:
                        opcion = menu(ad,correcto);
                        acabado = true;
                }
            }while(!acabado);
        }
        if(opcion == 2)
        {
            acabado = false;
            do{
                limpiarConsola();
                eligeCliente =  menuCliente();
                switch (eligeCliente){
                    case 1:
                        limpiarConsola();
                        delay(5);
                        Vuelos.VisualizarInformacion(listaDeReservas);
                        break;
                    case 2:
                        limpiarConsola();
                        delay(5);
                        Vuelos.comprarBilletes(listaDeVuelos, listaDeReservas);
                        break;
                    case 3:
                        limpiarConsola();
                        delay(5);
                        Vuelos.anularReserva(listaDeReservas);
                        break;
                    case 0:
                        opcion = menu(ad,correcto);
                        acabado = true;
                }
            }while (!acabado);
        }
    }

    public static int menu(Admin ad, boolean correcto)
    {
        boolean acabado = true;
        Scanner sc = new Scanner(System.in);
        int opcion;
        limpiarConsola();
        delay(5);
        do {
            acabado = true;
            System.out.println(Colores.BLACK + Colores.WHITE_BACKGROUND + "Como quieres iniciar sesion?" + Colores.RESET);
            System.out.println();
            System.out.println("1-Administrador      2-Cliente");
            System.out.println();
            System.out.println("0-Salir");
            opcion = sc.nextInt();
            if(opcion >= 3)
            {
                System.out.println(Colores.RED+"Opcion no valida"+Colores.RESET);
                acabado = false;
            }
        }while(!acabado);
        return  opcion;
    }
    public static boolean menuAdmin(Admin ad)
    {
        boolean correcto = false;
        do {
            Scanner sc = new Scanner(System.in);
            String usuario = "";
            String contraseña = "";
            System.out.println("Usuario");
            usuario = sc.next();
            System.out.println();
            System.out.println("Contraseña");
            contraseña = sc.next();
            correcto = ad.checkContraseña(usuario, contraseña);
            if(!correcto) System.out.println(Colores.RED+"El usuario o la contraseña son incorrectos, vuelve a intentarlo"+Colores.RESET);
            System.out.println();
        }while(!correcto);
        return correcto;
    }

    public static int opcionesAdmin()
    {
             Scanner sc = new Scanner(System.in);
             boolean valido = false;
            int elegegirOpcio = 0;

            delay(3);

            System.out.println();
            System.out.println(Colores.BLACK + Colores.WHITE_BACKGROUND + "Hola administrador" + Colores.RESET);
            System.out.println();
            System.out.println("1-Deshacer Vuelo"); //antes ponia Crear Vuelo
            System.out.println();
            System.out.println("2-Visualizar vuelos");
            System.out.println();
            System.out.println("3-Modificar vuelos");
            System.out.println();
            System.out.println("4-Borrar vuelo");
            System.out.println();
            System.out.println("5-Mostrar aviones");
            System.out.println();
            System.out.println("6-Mostrar pilotos");
            System.out.println();
            System.out.println("0-Salir");
            do {
                elegegirOpcio = sc.nextInt();
                if (elegegirOpcio <= 6 ||
                        elegegirOpcio > 1) {
                    valido = true;
                }
            }while(!valido);
        return elegegirOpcio;
    }

    public static int menuCliente()
    {
        Scanner sc = new Scanner(System.in);
        boolean valido = false;
        int elegegirOpcio = 0;


        System.out.println(Colores.BLACK + Colores.WHITE_BACKGROUND + "Hola Cliente" + Colores.RESET);
        System.out.println();
        System.out.println("1-Visualizar información vuelos");
        System.out.println();
        System.out.println("2-Comprar billetes");
        System.out.println();
        System.out.println("3-Anular billetes");
        System.out.println();
        System.out.println("0-Salir");
        do{
            elegegirOpcio = sc.nextInt();
            if(elegegirOpcio <= 3 || elegegirOpcio > 1)
            {
                valido = true;
            }
        }while (!valido);

        return elegegirOpcio;
    }

    public static void limpiarConsola() {
        //File >Settings> Keymap  -   ShortCut "ClearAll": Alt + Shift + 1
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_SHIFT);
            robot.keyPress(KeyEvent.VK_1);
            robot.keyRelease(KeyEvent.VK_ALT);
            robot.keyRelease(KeyEvent.VK_SHIFT);
            robot.keyRelease(KeyEvent.VK_1);
            robot.delay(10);
        } catch (AWTException ignored) {
        }
    }

    public static void delay(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ignored) {
        }
    }

}



