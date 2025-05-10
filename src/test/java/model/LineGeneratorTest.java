package model;

import model.ladder.HorizontalLine;
import model.ladder.LineGenerator;
import model.ladder.Link;
import model.ladder.LinkGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

class LineGeneratorTest {

    private final int width = 5;

    @Test
    public void LinkGenerator가_항상_UNLINKED를_반환할_때_생성되는_모든_가로라인은_UNLINKED여야_한다() {
        LinkGenerator unlinkedGenerator = new UnLinkedGenerator();
        HorizontalLine generatedLine = LineGenerator.generateHorizontalLine(width, unlinkedGenerator);
        generatedLine.getPoints().forEach(point ->
                assertThat(point).isEqualTo(Link.UNLINKED)
        );
    }

    @Test
    public void LinkGenerator가_항상_LINKED를_반환해도_가로라인이_두_번_연속_LINKED이면_안_된다() {
        LinkGenerator linkedGenerator = new LinkedGenerator();
        HorizontalLine generatedLine = LineGenerator.generateHorizontalLine(width, linkedGenerator);

        List<Link> links = generatedLine.getPoints();
        boolean result = IntStream.range(0, links.size() - 1)
                .anyMatch(i -> links.get(i).isLinked() && links.get(i + 1).isLinked());


        assertThat(result).isFalse();
    }

    @Test
    public void 생성되는_가로_링크의_개수는_사다리의_넓이와_같아야한다() {
        LinkGenerator unlinkedGenerator = new UnLinkedGenerator();
        HorizontalLine generatedLine = LineGenerator.generateHorizontalLine(width, unlinkedGenerator);
        assertThat(generatedLine.size()).isEqualTo(width);
    }
}
