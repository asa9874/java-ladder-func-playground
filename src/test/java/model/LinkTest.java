package model;

import model.ladder.Link;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LinkTest {

    @Test
    public void 연결상태가_false이면__UNLINKED가_생성_되어야_한다() {
        Link link = Link.from(false);
        assertThat(link).isEqualTo(Link.UNLINKED);
    }

    @Test
    public void 연결상태가_true이면_LINKED가_생성_되어야_한다() {
        Link link = Link.from(true);
        assertThat(link).isEqualTo(Link.LINKED);
    }

    @Test
    public void 현재_연결상태라면_true가_반환되어야_한다() {
        Link link = Link.from(true);
        assertThat(link.isLinked()).isTrue();
    }

    @Test
    public void 현재_연결상태가_아니라면_false가_반환되어야_한다() {
        Link link = Link.from(false);
        assertThat(link.isLinked()).isFalse();
    }
}
