package implementations;

import interfaces.Tyres;
import org.springframework.stereotype.Component;

@Component
public class BridgeStoneTyres implements Tyres {
    /**
     * @return 
     */
    @Override
    public String rotate() {
        return "The Car has been started with BridgeStone Tyres";
    }

    /**
     * @return 
     */
    @Override
    public String stop() {
        return "The Car has been stopped with BridgeStone Tyres";
    }
}
