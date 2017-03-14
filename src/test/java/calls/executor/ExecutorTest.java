package calls.executor;

import java.net.URISyntaxException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.redtogreen.rpa.vo.ResultVO;

public class ExecutorTest {
	

	public static void main( String[] args ) throws URISyntaxException, InterruptedException {
	
		Logger log = LoggerFactory.getLogger(ExecutorTest.class);
		
		log.info("Executor Tests");
		
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		
		Runnable task = () -> {
			
			ResultVO resultVO = new ResultVO();
		    try {
		        TimeUnit.SECONDS.sleep(2);
		        log.info("fecha task: " + new Date());
		        resultVO.setCodigo("OK");
		    }
		    catch (InterruptedException e) {
		    	log.info("task interrupted");
		    	resultVO.setCodigo("NOK");
		    }
		    //return resultVO;

		};
		
		executorService.execute(task);				
		log.info("Revisando si termino");
		
		while(!executorService.isTerminated()){
			log.info("Esperando termino");
			executorService.shutdown();
			TimeUnit.SECONDS.sleep(1);
		}
		
		log.info("Fin XD");		
		
		//executorService.scheduleWithFixedDelay(task, 0, 1, TimeUnit.SECONDS);
		
	}
}