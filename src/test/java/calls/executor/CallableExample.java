package calls.executor;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.redtogreen.rpa.vo.ResultVO;

public class CallableExample implements Callable<ResultVO>{

	Logger log = LoggerFactory.getLogger(CallableExample.class);
	
	@Override
	public ResultVO call() throws Exception {
		log.info("Ingresando al call");
		ResultVO resultVO = new ResultVO();
		resultVO.setCodigo("OK");
		resultVO.setDescripcion("Description call result VO");
		TimeUnit.SECONDS.sleep(3);
		log.info("Saliendo del call");
		return resultVO;
	}

	
	
}
