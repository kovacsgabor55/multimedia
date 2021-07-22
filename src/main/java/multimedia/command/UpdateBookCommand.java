package multimedia.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateBookCommand {
    private String author;
    private String title;
    private LocalDate releaseDate;
}
