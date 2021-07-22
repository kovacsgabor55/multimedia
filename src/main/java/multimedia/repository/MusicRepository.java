package multimedia.repository;

import multimedia.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MusicRepository extends JpaRepository<Music, Integer> {

    /*@Query("update Music m set m.performer = :performer, m.title = :title, m.genre = :gerne where m.id = :id")
    void updateById(int id, String performer, String title, String genre);*/
}
