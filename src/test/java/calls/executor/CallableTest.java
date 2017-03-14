package calls.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redtogreen.rpa.vo.ResultVO;

public class CallableTest {

	
	
	public static void main(String args[]) throws Exception {
		Logger log = LoggerFactory.getLogger(ExecutorTest.class);
		ExecutorService pool = Executors.newFixedThreadPool(3);
		
		log.info("Antes del pool submit");
		Future<ResultVO> future = pool.submit(new CallableExample());
		log.info("Despues del pool submit");
		
//		ResultVO resultVO = future.get();
//		log.info("Obteniendo resultVO");
//		if(resultVO != null){
//			log.info(resultVO.getDescripcion());
//		}
		
		log.info("Fin");
		pool.shutdown();
		
	}
	
}
