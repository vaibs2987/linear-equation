package com.linear.model;

import java.util.HashMap;
import java.util.Map;

public class Expression {

	private String op;
	private LeftHandSide lhs;
	private int rhs;


	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public LeftHandSide getLhs() {
		return lhs;
	}

	public void setLhs(LeftHandSide lhs) {
		this.lhs = lhs;
	}

	public int getRhs() {
		return rhs;
	}

	public void setRhs(int rhs) {
		this.rhs = rhs;
	}


	public Operator getReverseOperator(Operator resverseOperator) {
		switch (resverseOperator) {
		case MULTIPLY:
			return Operator.DIVIDE;
		case DIVIDE:
			return Operator.MULTIPLY;
		case ADD:
			return Operator.SUBTRACT;
		case SUBTRACT:
			return Operator.ADD;
		default:
			break;
		}
		return null;
	}

	public Map<String, Operator> getOperatorMap() {
		Map<String, Operator> map = new HashMap<String, Operator>();
		LeftHandSide lhs = getLhs();
		RightHandSide rhs = lhs.getRhs();
		Operator leftOperator = Operator.getOperatorFromName(lhs.getOp());
		map.put(MapKeys.LEFT, leftOperator);
		Operator rifhtOperator = Operator.getOperatorFromName(rhs.getOp());
		map.put(MapKeys.RIGHT, rifhtOperator);
		Operator equalOperator = Operator.getOperatorFromName(getOp());
		map.put(MapKeys.EQUAL, equalOperator);
		return map;
	}
}
