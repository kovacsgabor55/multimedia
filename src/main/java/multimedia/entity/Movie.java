package multimedia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(nullable = false, length = 50)
    private String director;
    @Column(name = "film_studio", nullable = false, length = 30)
    private String filmStudio;

    public Movie(String title, String director, String filmStudio) {
        this.title = title;
        this.director = director;
        this.filmStudio = filmStudio;
    }
}
