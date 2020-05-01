public class Responsable extends Cargo {
    public Responsable() {
        super(3, /*String info,*/ 2, 25, -1, 70);
    }
    
    public String mostrarRequisitos() {
        return "Minimo de edad:"+getMinEdad()+" Maximo de Percel:"+getMaxPercel();
    }
    public String getNombre(){
        return "Responsable";
    }
}