package model;

import model.ladder.HorizontalLine;
import model.ladder.Link;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HorizontalLineTest {

    private final HorizontalLine horizontalLine = new HorizontalLine(List.of(Link.UNLINKED, Link.LINKED, Link.UNLINKED));

    @Test
    public void 오른쪽_사다리와_연결되면_오른쪽으로_움직여야_한다() {
        int position = 1;
        int afterMove = horizontalLine.move(position);
        assertThat(afterMove).isEqualTo(position + 1);
    }

    @Test
    public void 왼쪽_사다리와_연결되면_왼쪽으로_움직여야_한다() {
        int position = 2;
        int afterMove = horizontalLine.move(position);
        assertThat(afterMove).isEqualTo(position - 1);
    }

    @Test
    public void 사다리가_연결되지_않으면_제자리를_유지해햐_한다() {
        int position = 0;
        int afterMove = horizontalLine.move(position);
        assertThat(afterMove).isEqualTo(position);
    }
}
