import java.io.*;
// Esta clase se utiliza para leer del fichero y aniadir todos lo miembros
public class Lector { // excepcion de mas de 100 miembros 
    public static int leer(String fileName, Departamentos listaDeDepartamentos) throws TooManyPeopleEx, TooManyPercelEx, TooManyCargoEx, NoRequisitosEx, FileNotFoundException{
        
        // Cuenta los miembros de la mision
        int numeroDeMiembros = 0;
        
        // para referenciar letras de una en una
        char letra = (char) -1;
        
        // variables para guardar los atributos que tendra el miembro
        String buffer = ""; // guardar los caracteres para un elemento concreto
        
        String nombre = "";
        String apellido = "";
        Cargo cargo = null;
        int xp = -1;
        int naci = -1;
        int habi = -1;
        Departamento dep = null;
        boolean percel = false;
        
        // para indicar el elemneto que se esta leyendo
        int elemento = 1;
        
        try {
            // Lee ficheros de texto con encoding en utf8
            InputStreamReader fileReader = new InputStreamReader( new FileInputStream(fileName), "UTF8");
            
            // Envuelto en un buffer reader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // recorer el fichero entero
            while((letra =  (char) bufferedReader.read()) !=  (char) -1 ) { 
                
                //Para los distintos elementos del miembro
                if(letra != ';' && letra != '\n' && elemento == 1){
                    nombre += letra;
                }
                else if(letra != ';' && letra != '\n' && elemento == 2){
                    apellido += letra;
                }
                else if(letra != ';' && letra != '\n' ){ // para el resto de elementos que son string
                    buffer += letra;
                }
                if(letra == ';'){ // delimitador de atributos
                    //traducir casos q no son string
                    if( elemento == 3 ){
                        cargo = Traductor.cargo(buffer);
                        buffer = "";
                    }
                    if( elemento == 4){
                        xp = Integer.parseInt(buffer);
                        buffer = "";
                    }
                    if( elemento == 5){
                        naci = Integer.parseInt(buffer);
                        buffer = "";
                    }
                    if( elemento == 6){
                        habi = Integer.parseInt(buffer);
                        buffer = "";
                    }
                    if( elemento == 7){
                        dep = listaDeDepartamentos.getDepartamento(buffer); // traductor no tiene acceso a la lista de departamentos
                        buffer = "";
                    }
                    if( elemento == 8){
                        percel = Traductor.percel(buffer);
                        new Miembro(nombre,apellido,cargo,xp,naci,habi,dep,percel); // crea el miembro q se guarda en el departamento
                        nombre = "";
                        apellido = "";
                        elemento = 0; // para reiniciarlo a 1
                        buffer = "";
                        numeroDeMiembros++;
                        if (numeroDeMiembros > 100){
                            throw new TooManyPeopleEx();
                        }
                    }
                    
                    elemento++;
                }
                
            }   
            // Siempre cerrear los ficheros
            bufferedReader.close();
        }catch(IOException ex) {
            ex.printStackTrace();
        }
        return numeroDeMiembros;
    }
}
