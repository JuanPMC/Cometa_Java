import java.util.*;
// Esta clase guarda todos los departamentos de la mision para instanciarlos unicamente una vez.
// Cualquier metodo quequiera utilizar los departamentos necesitara acceso a una instancia de este objeto (solo puede haber una)
public class Departamentos
{
    Map<String, Departamento> departamentos; // mapear los departamentos a un string (nombre)
    
    
    public Departamentos()
    {
        departamentos = new HashMap<String, Departamento>(); // almacenar todos los departamentos y mapearloscon un string
        
        departamentos.put("direcci\u00f3n", new Departamento("des1","des2","des3","des4","des5"));
        departamentos.put("log\u00edstica", new Departamento("des12","des13","des14","des15","des16"));
        departamentos.put("control de robots", new Departamento("des22","des23","des24","des25","des26"));
        departamentos.put("m\u00e9dico", new Departamento("des33","des34","des35","des36","des37"));
        departamentos.put("investigaci\u00f3n biol\u00f3gica", new Departamento("des45","des46","des47","des48","des49"));
        departamentos.put("construcci\u00f3n y mantenimiento", new Departamento("des1","hola q ase","psso","aaa","c3s"));
        departamentos.put("sistemas inform\u00e1ticos", new Departamento("des1","oss","ddl","af","css"));
        departamentos.put("investigaci\u00f3n astron\u00f3mica", new Departamento("des1","oh","gl","af","cs"));
        departamentos.put("cometolog\u00eda", new Departamento("des1","des1","dsd","aaa","decripcion to cicla"));
        departamentos.put("navegaci\u00f3n", new Departamento("des1","asfd","fhgj","gkj","jk"));
    }
    
    Departamento getDepartamento(String dep){
        return this.departamentos.get(dep); // si no se encuentra retorna null
    }
}