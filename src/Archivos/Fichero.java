package Archivos;

import Objeto.*;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Stream;

public class Fichero {
    private static final String fichero = "D:\\Mio 19\\Programming\\JavaIDEA\\src\\stream.txt";
    private static final BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
    private static PrintWriter salida;
    private static BufferedReader entradaA;
    private static Path path = Paths.get(fichero);
/*
    public static void main(String[] args) {
        escribirArchivo();
    }
*/
    public static void toStringObjeto(){

        int acum = 0;
        Integer id = 0;
        Character clave = '\u0000', genero = '\u0000';
        String nombre = "", str = "";
        Long telefono = 0L;
        Boolean casado  = false;

        while ((!str.equals("salir")) || acum < 6) {
            try {
                switch (acum) {
                    case 0:
                        System.out.print("Ingrese su identificacion:");
                        str = entrada.readLine();
                        id = Integer.parseInt(str);
                        acum++;
                        break;
                    case 1:
                        System.out.print("Ingrese su clave: ");
                        str = entrada.readLine();
                        clave = Character.valueOf(str.charAt(0));
                        acum++;
                        break;
                    case 2:
                        System.out.print("Ingrese su nombre: ");
                        str = entrada.readLine();
                        nombre = str;
                        acum++;
                        break;
                    case 3:
                        System.out.print("Ingrese su telefono: ");
                        str = entrada.readLine();
                        telefono = Long.valueOf(str);
                        acum++;
                        break;
                    case 4:
                        while (str.charAt(0) != 'f' && str.charAt(0) != 'm') {
                            System.out.print("Ingrese su genero: ");
                            str = entrada.readLine();
                        }
                        genero = str.charAt(0);
                        acum++;
                    case 5:
                        while (!str.equals("true") && !str.equals("false")) {
                            System.out.print("¿Esta casado? Ingrese true o false: ");
                            str = entrada.readLine();
                        }
                        casado = Boolean.valueOf(str);
                        acum++;
                        break;
                    default:
                        if (acum >= 5)
                            str = "salir";
                        break;

                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (IllegalFormatConversionException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //escribirArchObjeto(new Objeto(id, clave, nombre, telefono,genero, casado).toString());
    }

    public static void escribirArchObjeto(String str)
    {
        System.out.printf("Ingresando Informacion al archivo con direccion: %s%n",fichero);
        try {
            salida = new PrintWriter(new BufferedWriter(new FileWriter(fichero,true)));
            salida.println(str);
            salida.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static Objeto buscarObjeto(String obj)
    {
        ArrayList<Objeto> listObj = leerArchToObjeto();
        if(obj != null) {
            for (int i = 0; i < listObj.size(); i++) {
                if (Valida.isEqualId(obj,listObj.get(i).getClave().toString()))
                    return listObj.get(i);
            }
        }
        return null;
    }

    public static ArrayList<Objeto> leerArchToObjeto()
    {
        String str = leerArchStream1();
        String[] str1;
        str1 = str.split("[,|\\n]"); // regex opcional split([,?\n]+)
        ArrayList<Objeto> listObj = new ArrayList<>();

        for(int i = 0; i < str1.length; i+=6){
            if(Valida.validarId(str1[i]) && Valida.validarClave(str1[i+1]) &&
            Valida.validarNombre(str1[i+2]) && Valida.validarTelefono(str1[i+3]) &&
            Valida.validarGenero(str1[i+4]) && Valida.validarCasado(str1[i+5]))
            {
                listObj.add(new Objeto(Valida.crearNumero(str1[i]), str1[i+1], str1[i+2], Valida.crearNumero(str1[i+3]),
                        Valida.crearGenero(str1[4]), Valida.crearCasado(str1[5])));
            }
        }
        Collections.sort(listObj);
        return listObj;
    }

    public static void escribirArchivo()
    {

        ArrayList<Objeto> listObj = leerArchToObjeto();

        try(BufferedWriter bw = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.TRUNCATE_EXISTING))
        {

            for(int i = 0; i < listObj.size(); i++)
            {
                System.out.printf("Escribiendo en el archivo:%n%s%n",listObj.get(i).toString());
                bw.write(listObj.get(i).toString());
                bw.newLine();
            }
            //salida.println(str);

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * Ingresa en consola lo que quieras escribir en un archivo y para terminar escribes salir
     */
    public static void escribirArchPath()
    {
        System.out.println("Escribe:");
        boolean salir = false;
        String str;
        try(BufferedWriter bw = Files.newBufferedWriter(path, Charset.defaultCharset(), StandardOpenOption.APPEND))
        {
            //salida = new PrintWriter(bw);
            while(!salir)
            {
                str = entrada.readLine();
                if (!str.equals("salir")) {
                    //salida.println(str);
                    bw.write(str);
                    bw.newLine();
                }
                else {
                    salir = true;
                }
            }
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    /**
     * Ingresa en consola lo que quieras escribir en un archivo y para terminar escribes salir
     */
    public static void escribirArch()
    {
        System.out.print("Ingresa lo que se te de la gana: ");
        boolean salir = false;
        String str;
        while(!salir)
        {
            try {
                salida = new PrintWriter(new BufferedWriter(new FileWriter(fichero,true)));
                str = entrada.readLine();
                if (!str.equals("salir")) {
                    salida.println(str);
                } else {
                    salir = true;
                }
                salida.close();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    /**
     * Lee un archivo utilizando BufferedReader
     */
    public static void leerArch()
    {
        try {
            entradaA = new BufferedReader(new FileReader(fichero));
            String s, s2 = new String();
            while((s = entradaA.readLine()) != null)
            {
                s2 += s +"\n";
            }
            System.out.printf("%s",s2);
        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void leerArchStream()
    {
        try(Stream<String> stream = Files.lines(path, Charset.defaultCharset())){
            stream.forEach(System.out::println);
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static String leerArchStream1()
    {
        try(Stream<String> stream = Files.lines(path))
        {
            StringBuilder str = new StringBuilder();
            Stream<String> lines = Files.lines(path, Charset.defaultCharset());
            lines.forEach(line -> str.append(line).append("\n"));
            lines.close();
            return str.toString();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        return "";
    }
}
