package RacingCar;

import RacingCar.domain.Car;
import RacingCar.domain.MoveNumber;
import RacingCar.domain.Winner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinnerTest {

    @Test
    @DisplayName("우승자 테스트")
    void winnerTest() {
        Winner winner = new Winner();
        MoveNumber randomNumber = new MoveNumber();
        List<Car> list = new ArrayList<>();

        list.add(new Car("tom", 1));
        list.add(new Car("jason", 2));
        list.add(new Car("jenny", 3));

        List<Car> result = winner.findWinners(list);

        assertThat(result.get(0).getName()).isEqualTo("jenny");
    }
}
