package thiagodnf.jmetal.restful.beans;

public class Entry {
	
	protected Population paretoFront;
	
	protected Population population;
	
	public Entry(){
		
	}

	public Population getParetoFront() {
		return paretoFront;
	}

	public void setParetoFront(Population paretoFront) {
		this.paretoFront = paretoFront;
	}

	public Population getPopulation() {
		return population;
	}

	public void setPopulation(Population population) {
		this.population = population;
	}

	@Override
	public String toString() {
		return "Entry [paretoFront=" + paretoFront + ", population=" + population + "]";
	}

}
