package dms.pastor.examples.patterns.memento;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NoticeBoardTest {
    private static final String MESSAGE = "test";
    NoticeHistoryCaretaker noticeHistoryCaretaker;

    @BeforeEach
    public void setup() {
        noticeHistoryCaretaker = new NoticeHistoryCaretaker();
    }

    @Test
    void createNotice() {
        // when
        final NoticeBoard notice = NoticeBoard.createNotice(MESSAGE);

        // then
        assertThat(notice.getMessage()).isEqualTo(MESSAGE);
        assertThat(notice.isPriority()).isFalse();
    }

    @Test
    void createHighPriorityNotice() {
        // when
        final NoticeBoard notice = NoticeBoard.createHighPriorityNotice(MESSAGE);

        // then
        assertThat(notice.getMessage()).isEqualTo(MESSAGE);
        assertThat(notice.isPriority()).isTrue();
    }
}