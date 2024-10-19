public class LibrarySystem {
    private BorrowingRule borrowingRule;

    public LibrarySystem(BorrowingRule borrowingRule) {
        this.borrowingRule = borrowingRule;
    }

    public boolean borrowBook(Book book, Member member) {
        if (borrowingRule.canBorrow(book)) {
            System.out.println(member.getName() + " has borrowed the book: " + book.getTitle());
            book.setAvailable(false);
            return true;
        } else {
            System.out.println("Book is not available.");
            return false;
        }
    }

    public void returnBook(Book book, Member member) {
        book.setAvailable(true);
        System.out.println(member.getName() + " has returned the book: " + book.getTitle());
    }
}
