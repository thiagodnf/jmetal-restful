package thiagodnf.jmetal.restful.utils;

import java.util.ArrayList;
import java.util.List;

import thiagodnf.jmetal.restful.beans.Population;
import thiagodnf.jmetal.restful.beans.Sol;
import thiagodnf.jmetal.restful.problem.DumbProblem;
import thiagodnf.jmetal.restful.solution.DumbSolution;

public class ConvertUtils {

	public static List<DumbSolution> toListOfDumbSolutions(Population population) {

		int numberOfObjectives = PopulationUtils.getNumberOfObjectives(population);
		int numberOfVariables = PopulationUtils.getNumberOfVariables(population);

		DumbProblem problem = new DumbProblem(numberOfObjectives, numberOfVariables);

		List<DumbSolution> newPopulation = new ArrayList<DumbSolution>();

		for (Sol solution : population.getSolutions()) {

			DumbSolution dumb = new DumbSolution(problem);

			for (int i = 0; i < numberOfObjectives; i++) {
				dumb.setObjective(i, solution.getObjectives()[i]);
			}

			for (int i = 0; i < numberOfVariables; i++) {
				dumb.setVariableValue(i, solution.getVariables()[i]);
			}

			newPopulation.add(dumb);
		}

		return newPopulation;
	}
	
	public static Population toPopulation(List<DumbSolution> list) {
		return null;
	}

}
