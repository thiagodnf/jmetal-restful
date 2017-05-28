package thiagodnf.jmetal.restful.beans;

import java.util.ArrayList;
import java.util.List;

public class Population {
	
	private String id;
	
	private List<Sol> solutions;
	
	public Population() {
		this.solutions = new ArrayList<>();
	}

	public Population(String id, List<Sol> solutions) {
		this.id = id;
		this.solutions = solutions;
	}

	public List<Sol> getSolutions() {
		return solutions;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setSolutions(List<Sol> solutions) {
		this.solutions = solutions;
	}

	@Override
	public String toString() {
		return "Population [id=" + id + ", solutions=" + solutions + "]";
	}
	
}
