package Objeto;

public class Valida {

    public static boolean validarId(String str)
    {
        return str.matches("^[1-9][0-9]{9}$");
    }

    public static boolean validarNombre(String str)
    {
        return str.matches("^[a-zA-Z]+$");
    }

    public static boolean validarVacio(String str)
    {
        return str.isEmpty();
    }

    public static boolean validarTelefono(String str)
    {
        return str.matches("^[3][0-9]{9}");
    }

    public static boolean validarGenero(String str) { return str.matches("^[f]|^[m]"); }

    public static boolean validarClave(String str) { return str.matches("^[1-9][0-9]{2}[a-z]$"); }

    public static boolean validarCasado(String str) { return str.matches("^si|no$"); }

    public static Long crearNumero(String str)throws NumberFormatException {return Long.valueOf(str);}

    public static char crearGenero(String str){ return str.charAt(0); }

    public static boolean crearCasado(String str) { return str.equals("si")? true : false; }

    public static boolean isEqualId(String str1, String str2)
    {
        return str1.equals(str2);
    }
}
