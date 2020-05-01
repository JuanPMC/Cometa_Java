import java.util.ArrayList;
import java.io.*;

public class Main
{
    public static void main(String[] args) {
                
        Departamentos listaDeDepartamentos = new Departamentos(); // Departamentos ya inicializados
        
        Mostrador mainMostrador = new Mostrador(); // mostrador
        
       try{ // main block to test wrong file input
            
            mainMostrador.mensajeNormal("Se an leido " + String.valueOf(Lector.leer("temp.txt",listaDeDepartamentos)) + " miembros!");// coge los miembros y coge sus excepciones
            mainMostrador.mostrarInterfaz(listaDeDepartamentos); // Muestra la interfaz para navegar la lista de departamentos

        }catch(TooManyPeopleEx e){
            mainMostrador.mensajeError("Mucha gente un departamento");
        }catch(TooManyPercelEx e){
            mainMostrador.mensajeError("Muchos percel un cargo");
        }catch(TooManyCargoEx e){
            mainMostrador.mensajeError("Mucha gente un el cargo");
        }catch(NoRequisitosEx e){
            mainMostrador.mensajeError("Algun miembro no cumple los requisitos para su puesto");
        }catch(FileNotFoundException ex) {
            mainMostrador.mensajeError("No se encuentra fichero de configuracion");           
        }
    }
}