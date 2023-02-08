import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class GestionFicheros {

    public static void main(String[] args) {
        // Inicializamos una variable int para las opciones del menú
        int respuesta = 0;
        String[] respuestas = {
                "Crear",
                "Escribir",
                "Leer",
                "Borrar",
                "Salir" };

        // Bucle para el menú con sus respectivas funciones

        boolean bucle = true;
        while (bucle) {
            respuesta = JOptionPane.showOptionDialog(null,
                    "Elija la opción que desea ejecutar",
                    "Menú Ficheros",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/archivo.png"),
                    respuestas, respuestas[0]);

            // Bucle switch para cada caso
            switch (respuesta) {
                case 0:
                    File fichero = new File("fichero.txt"); // Creación de un fichero
                    try {
                        if (fichero.createNewFile()) {
                            JOptionPane.showMessageDialog(null, "El fichero ha sido creado 🗃👍️");
                        } else {
                            JOptionPane.showMessageDialog(null, "El fichero ya existe ☹");
                        }
                    } catch (IOException e) {
                        e.printStackTrace(); // Esta dentro de un try catch
                    } // por si el fichero no se puede crear
                    break;

                case 1: // Este caso es para escribir dentro del fichero
                    try {
                        FileWriter escritorFichero = new FileWriter("fichero.txt", true);
                        BufferedWriter escritorFichero2 = new BufferedWriter(escritorFichero);
                        String contenido = JOptionPane.showInputDialog("Ingresa el contenido a escribir en el fichero");
                        escritorFichero2.write(contenido + "\n"); // Aquí escribirá lo que haya en la variable contenido
                        escritorFichero2.close();
                        escritorFichero.close();
                        JOptionPane.showMessageDialog(null, "Se ha escrito el contenido en el fichero 🔨");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2: // Para leer el fichero en donde se ha escrito contenido
                    try {
                        FileReader LeerFichero = new FileReader("fichero.txt");
                        BufferedReader LeerFichero2 = new BufferedReader(LeerFichero);
                        String mensaje;
                        String contenido = ""; // Inicializamos la variable vacía
                        while ((mensaje = LeerFichero2.readLine()) != null) { // Bucle para escribir dentro del fichero
                            contenido += mensaje + "\n"; // El += se utiliza para agregarle el valor a la variable de la
                                                         // derecha
                        }
                        LeerFichero2.close();
                        LeerFichero.close();
                        JOptionPane.showMessageDialog(null, "El contenido escrito en el fichero es:\n" + contenido);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    String nombreBorrar = JOptionPane.showInputDialog("Introduce el nombre del fichero a borrar:\n"
                            + " (Por defecto se crea con el nombre fichero) ");
                    File ficheroBorrar = new File(nombreBorrar + ".txt");
                    if (ficheroBorrar.delete()) {
                        JOptionPane.showMessageDialog(null, "Fichero borrado con éxito :)👍");
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo borrar el fichero ☹️");
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "¡Gracias por utilizar este gestor de ficheros! 😊👋✦️");
                    bucle = false;
                    break;
            }
        }
    }
}