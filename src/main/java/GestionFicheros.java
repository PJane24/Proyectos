import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;

public class GestionFicheros {

    public static void main(String[] args) {
        //Inicializamos una variable int para las opciones del menú
        int respuesta = 0;
        String[] respuestas = { 
            "Crear",
            "Escribir",
            "Leer",
            "Borrar",
            "Salir" };
        
        //Bucle para el menú con sus respectivas funciones
        
        boolean bucle = true;
        while (bucle) {
            respuesta = JOptionPane.showOptionDialog(null,
                    "Elija la opción que desea ejecutar",
                    "Menú Ficheros",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/imagenes/archivo.png"),
                    respuestas, respuestas[0]);
            
            //Bucle switch para cada caso
            switch (respuesta) {
                case 0:      //Creación de un fichero
                    try {
                        JFileChooser chooser = new JFileChooser();
                        int returnVal = chooser.showOpenDialog(null);
                        if(returnVal == JFileChooser.APPROVE_OPTION) {
                            File fichero = chooser.getSelectedFile();
                        
                        
                        if (fichero.createNewFile()) {
                            JOptionPane.showMessageDialog(null, "El fichero ha sido creado 🗃👍️");
                            }else {
                            JOptionPane.showMessageDialog(null, "El fichero ya existe ☹");
                            }
                        }
                        
                       
                    } catch (IOException e) {
                        e.printStackTrace();        //Esta dentro de un try catch 
                    }                               //por si el fichero no se puede crear
                    break;
                    
                    
                case 1:   //Este caso es para escribir dentro del fichero
                    
            }  
        }
}   }