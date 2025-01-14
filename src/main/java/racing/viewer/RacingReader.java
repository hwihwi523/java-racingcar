package racing.viewer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import racing.domain.GameInfo;
import racing.domain.RaceCount;

public class RacingReader {

    private static final String CAR_NAMES_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_COUNT_INPUT_GUIDE = "시도할 횟수는 몇 회인가요?";

    public GameInfo inputForReady() {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String carNames = inputCarNames(br);
            RaceCount raceCount = inputRaceCount(br);
            return new GameInfo(carNames, raceCount.toInt());
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private String inputCarNames(BufferedReader input) throws IOException {
        System.out.println(CAR_NAMES_INPUT_GUIDE);
        return input.readLine();
    }

    private RaceCount inputRaceCount(BufferedReader input) throws IOException {
        System.out.println(RACE_COUNT_INPUT_GUIDE);
        return new RaceCount(input.readLine());
    }

}
