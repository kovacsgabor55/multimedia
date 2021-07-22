package multimedia.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, length = 50)
    private String author;
    @Column(nullable = false, length = 100)
    private String title;
    @Column(name = "release_date", nullable = false)
    private LocalDate releaseDate;

    public Book(String author, String title, LocalDate releaseDate) {
        this.author = author;
        this.title = title;
        this.releaseDate = releaseDate;
    }
}
