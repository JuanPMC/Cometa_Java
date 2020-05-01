// Esta clase contiene toda la informacion de un miembro
public class  Miembro {
    
    private String nombre;
    private String apellidos;
    private Cargo cargo;
    private int experiencia;
    private int nacimiento;  
    private double habilidad;
    private Departamento departamento;
    private boolean percel;
    
    
    public Miembro(String nombre, String apellidos, Cargo cargo, int experiencia, int nacimiento, double habilidad, Departamento departamento, boolean percel) throws TooManyPercelEx, TooManyCargoEx, NoRequisitosEx{
        
        this.nombre = String.valueOf(nombre);
        this.apellidos = String.valueOf(apellidos);
        this.experiencia = experiencia;
        this.nacimiento = nacimiento;
        this.habilidad = habilidad;
        this.percel = percel;
        setCargo(cargo);
        this.setDepartamento(departamento);
    }
    
    public void setNombre(String nombre){
        this.nombre = String.valueOf(nombre);
    }
    
    public void setApellidos(String apellidos){
        this.apellidos = String.valueOf(apellidos);
    }
    
    public void setCargo(Cargo cargo) throws NoRequisitosEx {  // el percel se mira en departamento
        int edad = 2061 - nacimiento;
        int min_exp = cargo.getMinExp();
        int min_edad = cargo.getMinEdad();
        int min_habilidad = cargo.getMinSkill();
    // comprueba si cumple los requisitos
    if(experiencia > min_exp && edad > min_edad && habilidad > min_habilidad) 
        this.cargo = cargo;
    else
        throw new NoRequisitosEx();
    }
    
    public void setDepartamento(Departamento departamento) throws TooManyPercelEx, TooManyCargoEx{ 
        //aniade al departamento y coloca la info
        if(departamento.aniadirMiembro(this)){
            //funciona
        }else{
            System.out.println("Miembro no se puede aniadir");//si da error ( ahora lanza una excepcion )
        }
    }
    
    public void setExperiencia(int experiencia){        
        this.experiencia = experiencia;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public String getApellidos(){
        return apellidos;
    }
    
    public Cargo getCargo(){
        return cargo;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public int getNacimiento(){         
        return nacimiento;
    }
    
    public int getEdad() {
        return 2061-nacimiento;
    }
    
    public double getHabilidad(){
        return habilidad;
    }
    
    public Departamento getDepartamento(){
        return departamento;
    }
    public boolean getPercel(){
       return this.percel;
    }
}