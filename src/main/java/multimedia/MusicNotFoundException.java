package multimedia;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class MusicNotFoundException extends AbstractThrowableProblem {
    public MusicNotFoundException(long id) {
        super(URI.create("musics/not-found"),
                "Not Found",
                Status.NOT_FOUND,
                "Music not found: " + id
        );
    }
}
