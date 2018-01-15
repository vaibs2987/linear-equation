package com.linear.model;

public class LeftHandSide {

	private String op;
	private int lhs;
	private RightHandSide rhs;

	public String getOp() {
		return op;
	}

	public void setOp(String op) {
		this.op = op;
	}

	public int getLhs() {
		return lhs;
	}

	public void setLhs(int lhs) {
		this.lhs = lhs;
	}

	public RightHandSide getRhs() {
		return rhs;
	}

	public void setRhs(RightHandSide rhs) {
		this.rhs = rhs;
	}
}
