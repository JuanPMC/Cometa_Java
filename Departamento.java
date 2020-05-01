
// El instante de esta clase accede a todos los miembros de un unico departamento
public class Departamento {
    // constantes para identificar los distintos cargos
    final int ID_OPERARIO = 1;
    final int ID_COORDINADOR = 2;
    final int ID_RESPONSABLE = 3;
    final int ID_SUBDIRECTOR = 4;
    final int ID_DIRECTOR = 5;
    
    final int NUMERO_DE_CARGOS = 5; // la cantidad de cargos
    
    private GrupoMiembros[] grupos = new GrupoMiembros[NUMERO_DE_CARGOS]; // Array con los cargos para mejor administracion
    
    
    private Miembro[] miembros = new Miembro[41]; // maximo numero de miembros por dep
    
    private int numMiembros; // cuenta de los miembros totales
    
    Departamento(String funOperario, String funCoordinador, String funSubDirector, String funResponsable , String funDirector){
        // cra los distintos grupos de miemberos ( 1 por cargo)
        this.grupos[0] = new GrupoMiembros(funOperario, ID_OPERARIO, 27);
        this.grupos[1] = new GrupoMiembros(funCoordinador, ID_COORDINADOR, 9);
        this.grupos[2] = new GrupoMiembros(funResponsable, ID_RESPONSABLE, 3);
        this.grupos[3] = new GrupoMiembros(funSubDirector, ID_SUBDIRECTOR, 1);
        this.grupos[4] = new GrupoMiembros(funDirector, ID_DIRECTOR, 1);
                
        this.numMiembros = 0; // por defecto hay 0 miembros
    }
    
    
    public boolean aniadirMiembro(Miembro sujetoNuevo) throws TooManyPercelEx, TooManyCargoEx { // intenta aniadir un miembro al departamento
        for(int i = 0; i < NUMERO_DE_CARGOS; i++){
            if(sujetoNuevo.getCargo().getCargoId() == grupos[i].getCargoId()){
                if(grupos[i].aniadirMiembro(sujetoNuevo)){
                    this.miembros[this.numMiembros] = sujetoNuevo; // tambien se aniade la referencia al grupo de miembros
                    this.numMiembros++;
                    return true;
                }
            }
        }
        throw new TooManyCargoEx(sujetoNuevo.getCargo().getCargoId());
    }
    
    public Miembro getMiembro(int numMiembro){
        return this.miembros[numMiembro];
    }
    public int getnumMiembros(){
        return this.numMiembros;
    }
    public GrupoMiembros getGrupoMiembros(int cargoId){ // precondicion GrupoMiembros existe
        return this.grupos[cargoId - 1];
    }
}