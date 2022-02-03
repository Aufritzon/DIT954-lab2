import java.util.ArrayList;
import java.util.List;

public class Workshop <T extends Car>{
    private final int capacity;

    List<T> cars = new ArrayList<>();

    public Workshop(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<T> getCars() {
        return cars;
    }

    public loadCar()
}
