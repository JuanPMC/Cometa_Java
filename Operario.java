public class Operario extends Cargo {
    public Operario() {
        super(1, /*String info,*/ 14 , 20,-1,-1);
    }
    public String mostrarRequisitos(){
        return "Edad minima: " + getMinEdad();
    }
    public String getNombre(){
        return "Operario";
    }
}