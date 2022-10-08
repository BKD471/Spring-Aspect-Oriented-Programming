package implementations;

import interfaces.Speakers;
import model.Song;
import org.springframework.stereotype.Component;

@Component
public class JblSpeakers implements Speakers {
    /**
     * @param song 
     * @return
     */
    public String makeSound(Song song) {
        return song.getTitle()+" song sung by "+song.getSingerName()+" is playing from JBL Speakers";
    }
}
