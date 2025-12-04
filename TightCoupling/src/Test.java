public class Test {
    public static void main(String[] args) {
        Engine engine=EngineFactory.getEngine("diesel");
        Car car=new Car(engine);
        car.drive();
    }
}
