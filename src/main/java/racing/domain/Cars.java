package racing.domain;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Cars {

    private static final int BOUND = 10;
    private static final int CRITERION = 4;
    private static final int STEPS = 1;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public void moveCars() {
        for (Car car : this.cars) {
            int randomValue = ThreadLocalRandom.current().nextInt(BOUND);
            if (CRITERION <= randomValue) {
                car.move(STEPS);
            }
        }
    }

    public List<String> findWinnerNames() {
        int maxPosition = getMaxPosition();
        return this.cars.stream()
                        .filter(cur -> cur.isWinner(maxPosition))
                        .map(Car::getName)
                        .collect(Collectors.toList());
    }

    private int getMaxPosition() {
        return this.cars.stream()
                        .mapToInt(Car::getPosition)
                        .max()
                        .orElseThrow(RuntimeException::new);
    }

}
