package multimedia;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class BookNotFoundException extends AbstractThrowableProblem {
    public BookNotFoundException(long id) {
        super(URI.create("books/not-found"),
                "Not Found",
                Status.NOT_FOUND,
                "Book not found: " + id
        );
    }
}
