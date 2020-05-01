import java.io.*;

// Esta clase maneja toda la escritura a ficheros

public class Escritor {

   public static void writeDep(String dep, Departamentos listaDeDepartamentos )throws IOException {
       
       final int NUMERO_CARGOS = 5; // fix the number of cargos
       
       BufferedWriter writer = new BufferedWriter(new FileWriter("out.txt"));
       Departamento departamento = listaDeDepartamentos.getDepartamento(dep);
       int max = 0;
       
       writer.write(""); // limpiar el fichero
       writer.append(dep + "\n"); // nombre del departamento
       
       // Imprime los distintos cargos
       for( int j = 1; j <= NUMERO_CARGOS; j++){
           max = departamento.getGrupoMiembros(j).getCantidadMiembros();
           if (max > 0){
               writer.append(departamento.getGrupoMiembros(j).getMiembro(0).getCargo().getNombre() + ": ( " + departamento.getGrupoMiembros(j).getMiembro(0).getCargo().mostrarRequisitos() + " ) \n");
               for(int i = 0; i < max; i++){
                   writer.append(departamento.getGrupoMiembros(j).getMiembro(i).getNombre() + "\n");
               }
           }
       }
        
       writer.close(); // cerrar el filewriter
    }
    public static void writeMiem(Miembro miembro)throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("out_miembro.txt"));
        writer.write(""); // limpiar el fichero
        // imprime los dats del miembro
        writer.append(miembro.getNombre() + " " + miembro.getApellidos() + "\n");
        writer.append("Cargo: " + miembro.getCargo().getNombre() +  "\n");
        writer.append("Edad: " + miembro.getEdad() + "\n");
        writer.append("Habilidad: " + miembro.getHabilidad() + "\n");
        if(miembro.getPercel()){    
            writer.append("Percel: Si");
        }else{
            writer.append("Percel: No");
        }
        writer.close(); // cerrar el filewriter
    }
}