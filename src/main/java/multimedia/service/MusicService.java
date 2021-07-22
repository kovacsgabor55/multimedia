package multimedia.service;

import lombok.AllArgsConstructor;
import multimedia.command.CreateMusicCommand;
import multimedia.command.UpdateMusicCommand;
import multimedia.dto.MusicDto;
import multimedia.entity.Music;
import multimedia.repository.MusicRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MusicService {

    private final ModelMapper modelMapper;

    private final MusicRepository repository;

    public MusicDto saveMusic(CreateMusicCommand command) {
        Music music = new Music(command.getPerformer(), command.getTitle(), command.getGenre());
        repository.save(music);
        return modelMapper.map(music, MusicDto.class);
    }

    public List<MusicDto> listAllMusic() {
        return repository.findAll().stream().map(m -> modelMapper.map(m, MusicDto.class))
                .collect(Collectors.toList());
    }

    public MusicDto findMusicById(int id) {
        return modelMapper.map(repository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException("Music not fount: " + id)),
                MusicDto.class);
    }

    //TODO
    public MusicDto updateMusicById(int id, UpdateMusicCommand command) {
        Music music = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Music not found: " + id));
        music.setPerformer(command.getPerformer());
        music.setTitle(command.getTitle());
        music.setGenre(command.getGenre());
        String performer = music.getPerformer();
        String title = music.getTitle();
        String genre = music.getGenre();

        /*repository.updateById(id, performer, title, genre);*/
        return modelMapper.map(music, MusicDto.class);
    }

    public void deleteMusicById(int id) {
        repository.deleteById(id);
    }

    public void deleteAllMusic() {
        repository.deleteAll();
    }
}
