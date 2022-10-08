package implementations;

import interfaces.Speakers;
import model.Song;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BoatSpeakers implements Speakers {
    public String makeSound(Song song) {
        return song.getTitle()+" song sung by "+song.getSingerName()+" is playing from Boat Speakers";
    }
}
