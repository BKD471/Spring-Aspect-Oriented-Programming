package main;

import config.ProjectConfig;
import model.Song;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.VehicleServices;

public class Executor {
    public static void main(String[] args) {
        var context=new AnnotationConfigApplicationContext(ProjectConfig.class);
        var vehicleServices=context.getBean(VehicleServices.class);
        System.out.println(vehicleServices.getClass());
        Song song=new Song();
        song.setTitle("Somewhere I belong");
        song.setSingerName("Chester Benington");
        boolean vehicleStarted=true;
        String moveVehicle=vehicleServices.moveVehicle(vehicleStarted);
        String vehicleStart=vehicleServices.playMusic(vehicleStarted,song);
        String applyingBrake=vehicleServices.applyBrake(vehicleStarted);
        System.out.println(moveVehicle+"--->"+vehicleStart+"----->"+applyingBrake);
    }
}
