package implementations;
import interfaces.Tyres;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MichelinTyres implements Tyres{
    /**
     * @return 
     */
    @Override
    public String rotate() {
        return "The Car has been started with Michelin Tyres";
    }

    /**
     * @return 
     */
    @Override
    public String stop() {
        return  "The Car has been stopped with Michelin Tyres";
    }
}
