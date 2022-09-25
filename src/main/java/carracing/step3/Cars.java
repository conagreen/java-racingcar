package carracing.step3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Cars {

    private static final int MOVABLE_THRESHOLD = 4;
    private final List<Car> cars;
    private final Supplier<Integer> numberGenerator;

    public Cars(int carCount, Supplier<Integer> numberGenerator) {
        cars = new ArrayList<>(carCount);
        for (int i = 0; i < carCount; i++) {
            cars.add(new Car());
        }
        this.numberGenerator = numberGenerator;
    }

    public void moveAllCars() {
        for (int i = 0; i < cars.size(); i++) {
            moveCar(i);
        }
    }

    private void moveCar(int carNum) {
        if (isMovable()) {
            cars.get(carNum).move();
        }
    }

    private boolean isMovable() {
        return numberGenerator.get() >= MOVABLE_THRESHOLD;
    }

    public String getAllCarsTrace() {
        StringBuilder allCarTrace = new StringBuilder();
        for (Car car : cars) {
            allCarTrace.append(car.moveTrace()).append("\n");
        }
        return allCarTrace.toString();
    }

}