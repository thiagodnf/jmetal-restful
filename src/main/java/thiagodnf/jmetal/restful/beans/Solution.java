package thiagodnf.jmetal.restful.beans;

import java.util.Arrays;

public class Solution {

	private double[] objectives;

	private String[] variables;

	public Solution() {
		
	}

	public Solution(double[] objectives, String[] variables) {
		this.objectives = objectives;
		this.variables = variables;
	}

	public double[] getObjectives() {
		return objectives;
	}

	public String[] getVariables() {
		return variables;
	}

	public void setObjectives(double[] objectives) {
		this.objectives = objectives;
	}

	public void setVariables(String[] variables) {
		this.variables = variables;
	}

	@Override
	public String toString() {
		return "Solution [objectives=" + Arrays.toString(objectives) + ", variables=" + Arrays.toString(variables) + "]";
	}	
}
