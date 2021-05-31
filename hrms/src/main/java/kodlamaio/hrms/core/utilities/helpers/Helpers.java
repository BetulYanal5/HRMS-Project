package kodlamaio.hrms.core.utilities.helpers;

import java.util.UUID;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class Helpers {
	
	public static class BusinessEngine {
		
		public static Result run(Result... logics) {
			for (Result logic : logics) {
				if (!logic.isSuccess()) {
					return logic;
				}
				
			}
			return new SuccessResult();
		}

	}
	
	public static class CodeGenerator {
		
		public static String  generateUUIDCode() {
			return UUID.randomUUID().toString();
		}

	}

}
