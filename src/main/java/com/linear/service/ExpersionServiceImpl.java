package com.linear.service;

import java.util.Map;

import com.linear.model.Expression;
import com.linear.model.LeftHandSide;
import com.linear.model.MapKeys;
import com.linear.model.Operator;
import com.linear.model.RightHandSide;
import com.linear.util.HelperService;

public class ExpersionServiceImpl implements ExpressionService {

	public String getActualExpression(Expression exp) {
		if (!HelperService.objectCheck(exp)) {
			return MapKeys.ERROR;
		}
		LeftHandSide lhs = exp.getLhs();
		RightHandSide rhs = lhs.getRhs();
		Map<String, Operator> map = exp.getOperatorMap();
		Operator leftOperator = map.get(MapKeys.LEFT);
		Operator rifhtOperator = map.get(MapKeys.RIGHT);
		Operator equalOperator = map.get(MapKeys.EQUAL);
		if (leftOperator == null || rifhtOperator == null || equalOperator == null) {
			return MapKeys.ERROR;
		}
		String result = lhs.getLhs() + " " + leftOperator.getDisplayName() + " (" + rhs.getLhs() + " "
				+ rifhtOperator.getDisplayName() + " " + rhs.getRhs() + ") " + equalOperator.getDisplayName() + " "
				+ exp.getRhs();
		return result;
	}

	public String getTransformedExpression(Expression exp) {
		if (!HelperService.objectCheck(exp)) {
			return MapKeys.ERROR;
		}
		LeftHandSide lhs = exp.getLhs();
		RightHandSide rhs = lhs.getRhs();
		Map<String, Operator> map = exp.getOperatorMap();
		Operator rifhtOperator = exp.getReverseOperator(map.get(MapKeys.RIGHT));
		if (rifhtOperator == null) {
			return MapKeys.ERROR;
		}
		String leftNo = (lhs.getLhs() < 0) ? " + " + lhs.getLhs() : " - " + lhs.getLhs();
		String result = rhs.getLhs() + " " + Operator.EQUAL.getDisplayName() + " (" + exp.getRhs() + leftNo + ")"
				+ rifhtOperator.getDisplayName() + " " + rhs.getRhs();
		return result;
	}

	public double solveExpression(Expression exp) {
		if (!HelperService.objectCheck(exp)) {
			return 0;
		}
		LeftHandSide lhs = exp.getLhs();
		RightHandSide rhs = lhs.getRhs();
		Map<String, Operator> map = exp.getOperatorMap();
		int rightSide = 0;
		if (lhs.getLhs() > 0) {
			rightSide = exp.getRhs() - lhs.getLhs();
		} else {
			rightSide = exp.getRhs() + lhs.getLhs();
		}
		Operator rifhtOperator = exp.getReverseOperator(map.get(MapKeys.RIGHT));
		switch (rifhtOperator) {
		case ADD:
			return rightSide + rhs.getRhs();
		case SUBTRACT:
			return rightSide - rhs.getRhs();
		case DIVIDE:
			return rightSide / rhs.getRhs();
		case MULTIPLY:
			return rightSide * rhs.getRhs();

		default:
			break;
		}
		return 0;
	}

}
