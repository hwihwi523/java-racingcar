package racing.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class CarFactory {

    private static final String DELIMITER = ",";
    private static final int CAR_NAME_MAX = 5;

    private static class CarFactoryHandler {

        private static final CarFactory INSTANCE = new CarFactory();

    }

    private CarFactory() {
    }

    public static CarFactory getInstance() {
        return CarFactoryHandler.INSTANCE;
    }

    public List<Car> manufactureCars(String text) {
        String[] carNames = text.split(DELIMITER);

        validate(carNames);

        return manufactureCars(carNames);
    }

    private List<Car> manufactureCars(String[] names) {
        return Arrays.stream(names)
                     .map(Car::new)
                     .collect(Collectors.toList());
    }

    private void validate(String[] carNames) {
        final boolean isInvalidCarName = Arrays.stream(carNames)
                                         .anyMatch(carName -> carName.isBlank() || isLongerThanMax(carName));

        if (isInvalidCarName || isDuplicated(carNames)) {
            throw new IllegalArgumentException("자동차 이름이 유효하지 않거나 중복된 자동차 이름이 존재합니다.");
        }
    }

    private boolean isLongerThanMax(String carName) {
        return carName.length() > CAR_NAME_MAX;
    }

    private boolean isDuplicated(String[] carNames) {
        return new HashSet<>(List.of(carNames)).size() != carNames.length;
    }

}
