package com.comb.commons.utils.result;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import com.comb.commons.utils.json.JsonUtil;
import org.apache.log4j.Logger;

/**
 *<p>Description:默认返回方式</p> 
 * @2016-4-13下午4:23:47
 *
 */
public class DefaultViewResult {
//	private static Logger logger = LogManager.getLogger(DefaultViewResult.class.getName());
	private static Logger logger = Logger.getLogger(DefaultViewResult.class);
	public static void defaultResult(HttpServletResponse response,Object resultObj) {
		
		if (resultObj == null) {
			resultObj = "success";
		}
		if (resultObj instanceof String) {
			
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/plain");
				response.getWriter().write((String) resultObj);
				logger.info("Response: " + (String) resultObj);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
			String string = JsonUtil.objectToJson(resultObj);
			if (string == null) {
				string = "";
			}
			try {
				response.setCharacterEncoding("UTF-8");
				response.setContentType("text/json");
				response.getWriter().write(string);
//				logger.info("Response: " + string);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
