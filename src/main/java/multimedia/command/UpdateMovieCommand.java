package multimedia.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateMovieCommand {
    private String title;
    private String director;
    private String filmStudio;
}
