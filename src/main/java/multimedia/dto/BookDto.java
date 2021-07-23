package multimedia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookDto {
    private int id;
    private String author;
    private String title;
    private LocalDate releaseDate;
}
