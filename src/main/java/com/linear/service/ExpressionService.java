package com.linear.service;

import com.linear.model.Expression;

public interface ExpressionService {

	String getActualExpression(Expression exp);

	String getTransformedExpression(Expression exp);

	double solveExpression(Expression exp);
}
