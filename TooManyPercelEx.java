public class TooManyPercelEx extends Exception // thrown when more than the max number of people in the mission
{
    public String toString(){
        return "Too many percel in cargo.";
    }
}
