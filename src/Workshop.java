import java.util.Deque;
import java.util.LinkedList;


public class Workshop <T extends Car> {
    private final int capacity;

    Deque<T> cars = new LinkedList<>();

    public Workshop(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void storeCar (T car){//ger statiskt fel när man lämnar in annan sorts bil än Volvo
        if (cars.size() < capacity) {
            cars.push(car);
        }
    }

    public T retrieveCar() { // Returnerar Class information hos bilarna i verkstaden
        return cars.pop();
    }

}
