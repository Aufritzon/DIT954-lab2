public class Program {
    public static void main(String[] args) {
        Scania s = new Scania(2, 2, AbstractMovable.Direction.NORTH);

        Car saab = new Saab95(0, 0, AbstractMovable.Direction.NORTH);
        Transporter t = new Transporter(0 , 0, AbstractMovable.Direction.NORTH);
        t.loadCar(saab);
    }
}
