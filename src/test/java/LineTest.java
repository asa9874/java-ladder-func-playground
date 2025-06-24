import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import domain.Line;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LineTest {

    @Nested
    @DisplayName("hasConnection 동작 테스트")
    class HasConnectionTest {

        List<Boolean> input = Arrays.asList(true, false, true);
        Line line = new Line(input);

        @Test
        void hasConnection_가로선이있으면_true를반환한다() {

            assertTrue(line.hasConnection(0));
        }

        @Test
        void hasConnection_가로선이없으면_false를반환한다() {

            assertFalse(line.hasConnection(1));
        }
    }
}
