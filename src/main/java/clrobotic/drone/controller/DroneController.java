package clrobotic.drone.controller;

import java.io.IOException;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeminders.ardrone.ARDrone;

import clrobotic.drone.vo.ResultVO;


@RestController
@RequestMapping("/identificarReferencia")
// @PropertySources({ @PropertySource("classpath:validacion.properties"),
// @PropertySource("classpath:bot.properties") })
public class DroneController {

	private final Logger log = LoggerFactory.getLogger(DroneController.class);
	
	private final static Integer CONNECT_TIMEOUT = 3000;
	
	@RequestMapping(value = "/lista", method = { RequestMethod.GET,
			RequestMethod.POST }, produces = "application/json; charset=UTF-8")
	public HttpEntity<ResultVO> obtenerReferencia(@RequestParam(value = "tiempoVuelo") Long tiempoVuelo) {

		ResultVO resultVO = new ResultVO();
		resultVO.setCodigo("VUELO");

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
			log.info("elevandose por:"+tiempoVuelo);
			// Fly a little :)
			Thread.sleep(tiempoVuelo);

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
		
		
		
		return new ResponseEntity<>(resultVO, HttpStatus.OK);
	}

}
