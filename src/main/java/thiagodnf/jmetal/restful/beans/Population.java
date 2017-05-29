package thiagodnf.jmetal.restful.beans;

import java.util.ArrayList;
import java.util.List;

public class Population {
	
	private List<Solution> solutions;
	
	public Population() {
		this.solutions = new ArrayList<>();
	}

	public Population(List<Solution> solutions) {
		this.solutions = solutions;
	}

	public List<Solution> getSolutions() {
		return solutions;
	}

	public void setSolutions(List<Solution> solutions) {
		this.solutions = solutions;
	}

	@Override
	public String toString() {
		return "Population [solutions=" + solutions + "]";
	}	
}
