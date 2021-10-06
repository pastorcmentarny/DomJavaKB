package dms.pastor.examples.patterns.memento;

//Paint task in this project has an example in practice
public class MementoExampleRunner {
    private static NoticeBoard update(NoticeHistoryCaretaker historyCaretaker, NoticeBoard noticeBoard, String message) {
        final NoticeBoard updatedNoticeBoard = NoticeBoard.withMessageAndPriority(message, noticeBoard.isPriority());
        historyCaretaker.add(updatedNoticeBoard);
        return updatedNoticeBoard;
    }

    public static void main(String[] args) {
        NoticeHistoryCaretaker history = new NoticeHistoryCaretaker();
        NoticeBoard noticeBoard = NoticeBoard.createNotice("test message");
        history.add(noticeBoard);
        System.out.println(noticeBoard.getMessage());
        noticeBoard = MementoExampleRunner.update(history, noticeBoard, "new message");
        System.out.println(noticeBoard.getMessage());
        //history.redo();

    }
}
