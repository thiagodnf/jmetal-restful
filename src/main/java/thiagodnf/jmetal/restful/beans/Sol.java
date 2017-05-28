package thiagodnf.jmetal.restful.beans;

import java.util.Arrays;

public class Sol {

	private int[] objectives;

	private String[] variables;

	public Sol() {
		
	}

	public Sol(int[] objectives, String[] variables) {
		this.objectives = objectives;
		this.variables = variables;
	}

	public int[] getObjectives() {
		return objectives;
	}

	public String[] getVariables() {
		return variables;
	}

	public void setObjectives(int[] objectives) {
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
