package test.drone;

import java.io.IOException;
import java.net.UnknownHostException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codeminders.ardrone.ARDrone;
import com.codeminders.ardrone.ARDrone.State;
import com.codeminders.ardrone.NavData;
import com.codeminders.ardrone.data.decoder.ardrone10.navdata.ARDrone10NavData;


public class TestDespegar {

	private final Logger log = LoggerFactory.getLogger(TestDespegar.class);
	private final static Integer CONNECT_TIMEOUT = 3000;
	
	@Test
	public void test(){
		log.info("Tests basic");
		ARDrone drone;		
		try {
			drone = new ARDrone();
			drone.connect();
			drone.clearEmergencySignal();
			log.info("conectando con el DRON");
			
			// Wait until drone is ready
			drone.waitForReady(CONNECT_TIMEOUT);
			// do TRIM operation
			drone.trim();
			log.info("conectado");
			// Take off
			System.err.println("Taking off");
			drone.takeOff();
			log.info("elevandose");
			// Fly a little :)
			Thread.sleep(5000);

			// Land
			System.err.println("Landing");
			drone.land();
			log.info("aterrizando");

			// Give it some time to land
			Thread.sleep(2000);			
			
			// Disconnect from the done
			drone.disconnect();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
