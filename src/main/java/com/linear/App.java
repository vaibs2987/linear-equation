package com.linear;

import com.linear.model.Expression;
import com.linear.model.MapKeys;
import com.linear.service.FileReaderService;
import com.linear.service.ExpressionService;
import com.linear.service.ExpersionServiceImpl;
import com.linear.util.HelperService;

public class App {
	public static void main(String[] args) {
		FileReaderService fileReaderService = new FileReaderService();
		String json = fileReaderService.readFile("/home/vaibhav/clear/test.txt");
		if (json.length() == 0) {
			System.out.println(MapKeys.FILE_PARSING_ERROR);
			return;
		}
		Expression exp = HelperService.getJsonAsClass(json, Expression.class);
		if (exp == null) {
			System.out.println(MapKeys.INCORRECT_JSON);
			return;
		}
		ExpressionService parsingService = new ExpersionServiceImpl();
		System.out.println(parsingService.getActualExpression(exp));
		System.out.println(parsingService.getTransformedExpression(exp));
		System.out.println(parsingService.solveExpression(exp));
	}
}
