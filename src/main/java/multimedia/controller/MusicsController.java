package multimedia.controller;

import lombok.AllArgsConstructor;
import multimedia.command.CreateMusicCommand;
import multimedia.command.UpdateMusicCommand;
import multimedia.dto.MusicDto;
import multimedia.service.MusicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("music/")
public class MusicsController {

    private final MusicService service;

    @GetMapping("all")
    public List<MusicDto> getMusics() {
        return service.listAllMusic();
    }

    @GetMapping("{id}")
    public MusicDto findMusicById(@PathVariable("id") int id) {
        return service.findMusicById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MusicDto createMusic(@RequestBody CreateMusicCommand command) {
        return service.saveMusic(command);
    }

    @PutMapping("{id}")
    public MusicDto updateMusic(@PathVariable("id") int id, @RequestBody UpdateMusicCommand command) {
        return service.updateMusicById(id, command);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMusic(@PathVariable("id") int id) {
        service.deleteMusicById(id);
    }

    @DeleteMapping("deleteall")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllMusic() {
        service.deleteAllMusic();
    }
}
