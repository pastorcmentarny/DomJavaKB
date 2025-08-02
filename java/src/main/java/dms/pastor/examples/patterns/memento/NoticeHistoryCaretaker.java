package dms.pastor.examples.patterns.memento;

import dms.pastor.domain.exception.SomethingWentWrongException;

import java.util.ArrayList;
import java.util.List;

// I don't call it Caretaker in my project but history
public class NoticeHistoryCaretaker {
    final List<NoticeBoard> noticeHistory = new ArrayList<>();

    public void add(NoticeBoard notice) {
        noticeHistory.add(NoticeBoard.withMessageAndPriority(notice.getMessage(), notice.isPriority()));
    }

    public NoticeBoard undo() {
        System.out.println("Notice History: " + noticeHistory.isEmpty());
        throwExceptionIfNotFound(noticeHistory.isEmpty());

        int index = noticeHistory.size() - 1;

        return noticeHistory.get(index);

    }

    public NoticeBoard redo(NoticeBoard noticeBoard) {
        throwExceptionIfNotFound(noticeBoard == null);

        final int currentIndex = noticeHistory.indexOf(noticeBoard);

        throwExceptionIfNotFound(currentIndex == -1);

        if (currentIndex + 1 < noticeHistory.size()) {
            return noticeHistory.get(currentIndex + 1);
        } else {
            throwExceptionIfNotFound(currentIndex + 1 >= noticeHistory.size());
        }

        return noticeHistory.get(currentIndex);

    }

    private void throwExceptionIfNotFound(boolean isNotFound) {
        if (isNotFound) {
            throw new SomethingWentWrongException("No previous state saved");
        }
    }


}
