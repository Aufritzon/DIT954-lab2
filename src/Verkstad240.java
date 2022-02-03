import java.util.ArrayList;


public class Verkstad240 {

    private final static int CAPACITY = 10;

    ArrayList<Volvo240> volvoCars = new ArrayList<Volvo240>(CAPACITY);

    public Verkstad240(){

    }

    public int storeCar (Volvo240 car){//ger statiskt fel när man lämnar in annan sorts bil än Volvo
        if (volvoCars.size() < 10){
            volvoCars.add(car);
        }
        return volvoCars.lastIndexOf(car);
    }

    public String retrieveCar(int i) { // Returnerar Class information hos bilarna i verkstaden
        return volvoCars.remove(i).getClass().toString();
    }

}
