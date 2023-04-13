package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.application.Car;
import racingcar.application.RandomMoveStrategy;

public class CarTest {

  @Test
  @DisplayName("4 이상의 값이 들어오면 전진한다")
  void goTest() {
    // given
    Car car = new Car();
    int beforeLocation = car.location();

    // when
    car.go(new RandomMoveStrategy(() -> 4));

    // then
    assertThat(beforeLocation + 1).isEqualTo(car.location());
  }

  @Test
  @DisplayName("3 이하의 값이 들어오면 정지한다")
  void goFailTest() {
    // given
    Car car = new Car();
    int beforeLocation = car.location();

    // when
    car.go(new RandomMoveStrategy(() -> 3));

    // then
    assertThat(beforeLocation).isEqualTo(car.location());
  }
}