package multimedia.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateMusicCommand {
    private String performer;
    private String title;
    private String genre;
}
