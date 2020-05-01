// Esta clase representa un cargo
public class GrupoMiembros
{
    private String funcion; // descripcion del cargo (especifica del departamento)
    private int cantidadMiembros, nPercel, idCargo, maxMiembros; // distintos requisitos del cargo
    private Miembro dep[]; // array de miembros del cargo
    
    GrupoMiembros(String funcion, int idCargo, int maxMiembros){
        // inicializar atributos
        this.funcion = funcion;
        this.cantidadMiembros = 0;
        this.nPercel = 0;
        this.idCargo = idCargo;
        this.maxMiembros = maxMiembros;
        this.dep = new Miembro[maxMiembros];
        
    }
    
    public int getCargoId(){
        return this.idCargo;
    }
    
    public String getFuncion(){
        return (this.funcion);
    }
    
    public boolean aniadirMiembro(Miembro aniadido) throws TooManyPercelEx { // Precondicion: El cargo debe ser el correcto de este contenedor
        // compruava las condiciones parase aniadido
        if(this.cantidadMiembros < this.maxMiembros){
            if(aniadido.getPercel()){
                if(aniadido.getCargo().getMaxPercel() < this.nPercel ){
                    //aniade le miembro como percel
                    this.nPercel++;
                }else{
                    throw new TooManyPercelEx(); // Salta excepcion
                }
            }
            // aniade miembro como miembro
            this.dep[this.cantidadMiembros] = aniadido; // copia la referencia
            this.cantidadMiembros++;
            
            aniadido.getCargo().setInfo(this.funcion);
            return true;
        }
        return false;
    }
    
    public Miembro getMiembro(int id){ // precondicion el miembro existe
        return this.dep[id];
    }
    
    public int getCantidadMiembros(){
        return this.cantidadMiembros;
    }
}
