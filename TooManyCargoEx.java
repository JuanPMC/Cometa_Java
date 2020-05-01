public class TooManyCargoEx extends Exception // thrown when more than the max number of people in the mission
{   
    private int cargoId;
    TooManyCargoEx( int cargoId ){
        this.cargoId = cargoId;
    }
    public String toString(){
        return "Too many People in cargo ID: " + this.cargoId ;
    }
}
