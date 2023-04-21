import java.util.Scanner;

public class Admin
{
    private String usuario;
    private String contraseña;

    public Admin() {
        this.usuario = "admin";
        this.contraseña = "123admin";
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean checkContraseña(String checkUs, String checkContra) {
        boolean correctoUs = false;
        boolean correctoContra = false;
        boolean lasDos = false;
        Scanner sc = new Scanner(System.in);

        if (checkUs.equals(this.usuario)) {
            correctoUs = true;
        }

        if (checkContra.equals(this.contraseña)) {
            correctoContra = true;

        }
        if(correctoUs && correctoContra) lasDos = true;
        return lasDos;

    }
}

