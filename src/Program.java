public class Program {
    public static void main(String[] args) {
        Scania s = new Scania(2, 2, AbstractMovable.Direction.NORTH);

        Volvo240 volvo = new Volvo240(0, 0, AbstractMovable.Direction.NORTH);
        Saab95 saab = new Saab95(0, 0, AbstractMovable.Direction.NORTH);
        Transporter t = new Transporter(0 , 0, AbstractMovable.Direction.NORTH);
        t.loadCar(saab);

        Workshop<Volvo240> volvo240Workshop = new Workshop<>(10);

        volvo240Workshop.storeCar(volvo);

        Volvo240 f = volvo240Workshop.retrieveCar();

        System.out.println(f == volvo);
    }
}
