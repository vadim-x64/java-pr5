import com.project.State;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Testing {

    static Stream<Object[]> normalCases() {
        return Stream.of(
                new Object[]{"", State.S},
                new Object[]{"abc", State.S},
                new Object[]{"T", State.ONE},
                new Object[]{"TE", State.TWO},
                new Object[]{"TES", State.THREE},
                new Object[]{"TEST", State.F},
                new Object[]{"abcTESTabc", State.F},
                new Object[]{"abcTES", State.THREE}
        );
    }

    @ParameterizedTest
    @MethodSource("normalCases")
    void testNormalCases(String input, State expected) {
        assertEquals(expected, com.project.Test.process(input));
    }

    static Stream<String> trickyCases() {
        return Stream.of(
                "TESTTEST",
                "TETEST",
                "TTEST",
                "TESTSTEST",
                "aTESTb",
                "TESTEST"
        );
    }

    @ParameterizedTest
    @MethodSource("trickyCases")
    void testTrickyCases(String input) {
        assertEquals(State.F, com.project.Test.process(input));
    }
}