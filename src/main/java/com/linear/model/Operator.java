package com.linear.model;

public enum Operator {

	ADD("add"  ,"+"),
	SUBTRACT("subtract" , "-"),
	MULTIPLY("multiply" , "*"),
	DIVIDE("divide" , "/"),
	EQUAL("equal" , "=");
	
	private String name;
	private String displayName;

	private Operator(String name, String displayName){
		this.name = name;
		this.displayName = displayName;
	}
	public String getName() {
		return name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public static Operator getOperatorFromName(String name){
		for(Operator operator:Operator.values()){
			if(operator.getName().equals(name)){
				return operator;
			}
		}
		return null;
	}
}
