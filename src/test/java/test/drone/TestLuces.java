package test.drone;

import java.io.IOException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.codeminders.ardrone.ARDrone;

import clrobotic.drone.listener.NavDataBasicListenerImpl;

public class TestLuces {

	private final Logger log = LoggerFactory.getLogger(TestLuces.class);
	private final static Integer CONNECT_TIMEOUT = 3000;
	@Test
	public void encenderYApagar() {
		log.info("Encender y apagar");

		NavDataBasicListenerImpl navDataListener = new NavDataBasicListenerImpl();
		
		ARDrone drone ;
		try {
			drone = new ARDrone();
			drone.connect();
			drone.clearEmergencySignal();
			drone.addNavDataListener(navDataListener);
			
			log.info("conectando con el DRON");
			// Wait until drone is ready
			drone.waitForReady(CONNECT_TIMEOUT);
			// do TRIM operation
			drone.trim();
			log.info("conectado");
			int i = 0;
			System.err.println("Taking off");			
			//drone.takeOff();
			while(i <= 5){
				i++;
				Thread.sleep(1000);
				log.info("Bater:"+String.valueOf(navDataListener.getNavData().getBattery()));
				log.info("Altitud:" + String.valueOf(navDataListener.getNavData().getAltitude()));
			}
			
			drone.disconnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
