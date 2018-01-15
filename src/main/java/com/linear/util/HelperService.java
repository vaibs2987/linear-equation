package com.linear.util;

import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import com.linear.model.Expression;
import com.linear.model.LeftHandSide;
import com.linear.model.RightHandSide;

public class HelperService {

	public static <T> T getJsonAsClass(String json, Class<T> clazz) {
		if (json == null || json.trim().length() == 0) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(json, clazz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}


	public static boolean objectCheck(Expression exp) {
		LeftHandSide lhs = exp.getLhs();
		if (lhs == null) {
			return false;
		}
		RightHandSide rhs = lhs.getRhs();
		if (rhs == null) {
			return false;
		}
		return true;
	}
}
