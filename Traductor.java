import java.util.*;

// Esta clase se utiliza para traducir varios elementos
  
public class Traductor
{
    // traducir de String a cargo
    public static Cargo cargo(String cargoS){
        Map<String, Cargo> cargos = new HashMap<String, Cargo>();
        
        Cargo tempCargo = new Director();
        cargos.put("director", tempCargo);
        tempCargo = new Subdirector();
        cargos.put("subdirector", tempCargo);
        tempCargo = new Responsable();
        cargos.put("responsable", tempCargo);
        tempCargo = new Coordinador();
        cargos.put("coordinador", tempCargo);
        tempCargo = new Operario();
        cargos.put("operario", tempCargo);
        
        return cargos.get(cargoS); // responde null si no existe el cargo
    }
    
    // Traduce de Si/No a true/false
    public static boolean percel(String percelS){ // Precondicion: el string es "si" o "no"
        if(percelS.equals("no")){
            return false;
        }else{
            return true;
        }
    }
}
