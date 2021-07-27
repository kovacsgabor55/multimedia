package multimedia;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class MovieNotFoundException extends AbstractThrowableProblem {
    public MovieNotFoundException(long id) {
        super(URI.create("movies/not-found"),
                "Not Found",
                Status.NOT_FOUND,
                "Movie not found: " + id
        );
    }
}
