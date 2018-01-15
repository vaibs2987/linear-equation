package com.pack;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.linear.model.Expression;
import com.linear.service.FileReaderService;
import com.linear.service.ExpressionService;
import com.linear.service.ExpersionServiceImpl;
import com.linear.util.HelperService;

public class ExpressionServiceTest {

	private ExpressionService parsingService = new ExpersionServiceImpl();
	private FileReaderService fileReader = new FileReaderService();
	private Expression exp;

	@Before
	public void setUpStreams() {
		String path = "/home/vaibhav/clear/test.txt";
		String content = fileReader.readFile(path);
		exp = HelperService.getJsonAsClass(content, Expression.class);
	}

	@Test
	public void testGetActualExpression() {
		assertTrue(parsingService.getActualExpression(exp).equalsIgnoreCase("1 + (x * 10) = 21"));
	}

	@Test
	public void testGetTransformedExpression() {
		assertTrue(parsingService.getTransformedExpression(exp).equalsIgnoreCase("x = (21 - 1)/ 10"));
	}

	@Test
	public void testSolveExpression() {
		assertTrue(parsingService.solveExpression(exp) == 2.0);
	}

}
