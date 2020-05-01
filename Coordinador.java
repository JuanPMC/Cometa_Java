public class Coordinador extends Cargo {
    public Coordinador() {
        super(2, /*String info,*/ 5,-1,-1,80);
    }
    public String mostrarRequisitos() {
        return "Minimo de cociente de habilidad espacial:"+getMinSkill()+" Maximo de Percel:"+getMaxPercel();
    }
    public String getNombre(){
        return "Coordinador";
    }
}