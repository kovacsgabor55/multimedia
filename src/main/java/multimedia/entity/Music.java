package multimedia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String performer;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 15)
    private String genre;

    public Music(String performer, String title, String genre) {
        this.performer = performer;
        this.title = title;
        this.genre = genre;
    }
}
