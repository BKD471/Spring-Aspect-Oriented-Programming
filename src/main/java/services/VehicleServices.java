package services;


import interfaces.LogAspect;
import interfaces.Speakers;
import interfaces.Tyres;
import model.Song;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;
import java.util.logging.Level;
import java.util.logging.Logger;


@Component
public class VehicleServices {

    private final Speakers speaker;
    private final Tyres tyre;

    private Logger logger= Logger.getLogger(VehicleServices.class.getName());

    @Autowired
    public VehicleServices(Speakers speaker,Tyres tyre){
       this.speaker=speaker;
       this.tyre=tyre;
    }

    @LogAspect
    public  String playMusic(boolean  vehicleStarted,Song song){
//        Instant start= Instant.now();
//        logger.info("Method execution starts for playMusic...");
//        String music=null;
//
//        if(vehicleStarted){
//            music=speaker.makeSound(song);
//        }else{
//           logger.log(Level.SEVERE,"Vehicle not started to perform the operation...");
//        }
//        logger.info("Method execution ends for playMusic...");
//        Instant finish=Instant.now();
//        long timeElapsed= Duration.between(start,finish).toMillis();
//        System.out.println("Time elapsed to perform playMusic "+timeElapsed);
        return speaker.makeSound(song);
    }

    public String moveVehicle(boolean vehicleStarted){
//        Instant start= Instant.now();
//        logger.info("Method execution starts for moveVehicle...");
//        String status=null;
//
//        if(vehicleStarted){
//            status=tyre.rotate();
//        }else{
//            logger.log(Level.SEVERE,"Vehicle not started to perform the operation...");
//        }
//        logger.info("Method execution ends for moveVehicle...");
//        Instant finish=Instant.now();
//        long timeElapsed= Duration.between(start,finish).toMillis();
//        System.out.println("Time elapsed to start vehicle "+timeElapsed);
        return tyre.rotate();
    }

     public  String applyBrake(boolean vehicleStarted){
//         Instant start= Instant.now();
//         logger.info("Method execution starts for applyBrake...");
//         String status=null;
//
//         if(vehicleStarted){
//             status=tyre.stop();
//         }else{
//             logger.log(Level.SEVERE,"Vehicle not started to perform the operation...");
//         }
//         logger.info("Method execution ends for applyBrake...");
//         Instant finish=Instant.now();
//         long timeElapsed= Duration.between(start,finish).toMillis();
//         System.out.println("Time elapsed to stop the vehicle"+timeElapsed);
         return tyre.stop();
     }



    public Tyres getTyre() {
        return tyre;
    }

    public Speakers getSpeaker() {
        return speaker;
    }
}
