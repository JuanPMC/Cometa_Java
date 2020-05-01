public class Director extends Cargo {
    public Director() {
        super(5, /*String info,*/ 0, -1, 20, -1);
    }
    
    public String mostrarRequisitos() {
        return "Minimo de experiencia:"+getMinExp()+" Maximo de Percel:"+getMaxPercel();
    }    
    public String getNombre(){
        return "Director";
    }
}