package thiagodnf.jmetal.restful.utils;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import thiagodnf.jmetal.restful.beans.Population;
import thiagodnf.jmetal.restful.beans.Solution;
import thiagodnf.jmetal.restful.jmetal.problem.DumbProblem;
import thiagodnf.jmetal.restful.jmetal.solution.DumbSolution;

/**
 * This utility class is used for converting some object instances into other ones. For example,
 * you can convert from Population instance to a list of DumbSolution instances.
 * 
 * @author Thiago N. Ferreira
 * @version 1.0.0
 * @since 2017-05-28
 */
public class ConvertUtils {

	/**
	 * Convert from {@link Population} to a list of {@link DumbSolution}. The population parameter
	 * cannot be null
	 * 
	 * @param population The population that should be converted
	 * @return a list of {@link DumbSolution}
	 */
	public static List<DumbSolution> toListOfDumbSolutions(Population population) {

		checkNotNull(population, "The population object cannot be null");
		checkArgument(population.getSolutions().size() != 0, "The population has not solutions");

		int numberOfObjectives = PopulationUtils.getNumberOfObjectives(population);
		int numberOfVariables = PopulationUtils.getNumberOfVariables(population);

		DumbProblem problem = new DumbProblem(numberOfObjectives, numberOfVariables);

		List<DumbSolution> list = new ArrayList<DumbSolution>();

		for (Solution solution : population.getSolutions()) {

			DumbSolution dumb = new DumbSolution(problem);

			for (int i = 0; i < numberOfObjectives; i++) {
				dumb.setObjective(i, solution.getObjectives()[i]);
			}

			for (int i = 0; i < numberOfVariables; i++) {
				dumb.setVariableValue(i, solution.getVariables()[i]);
			}

			list.add(dumb);
		}

		return list;
	}

	/**
	 * Convert from a list of {@link DumbSolution} to {@link Population}. The list parameter
	 * cannot be null
	 * 
	 * @param id the unique identifier
	 * @param list the list of dumb solutions that should be converted
	 * @return an instance of Population class
	 */
	public static Population toPopulation(String id, List<DumbSolution> list) {

		checkNotNull(list, "The list of dumb solutions cannot be null");

		Population population = new Population();

		population.setId(id);

		for (DumbSolution dumbSolution : list) {
			population.getSolutions().add(ConvertUtils.toSolution(dumbSolution));
		}

		return population;
	}
	
	/**
	 * Convert from a {@link DumbSolution} to {@link Solution}. The dumbSolution parameter
	 * cannot be null
	 * 
	 * @param dumbSolution the dumb solution that should be converted
	 * @return an instance of Solution class
	 */
	public static Solution toSolution(DumbSolution dumbSolution) {

		checkNotNull(dumbSolution, "The dumb solution cannot be null");

		double[] objectives = new double[dumbSolution.getNumberOfObjectives()];

		for (int i = 0; i < dumbSolution.getNumberOfObjectives(); i++) {
			objectives[i] = dumbSolution.getObjective(i);
		}

		String[] variables = new String[dumbSolution.getNumberOfVariables()];

		for (int i = 0; i < dumbSolution.getNumberOfVariables(); i++) {
			variables[i] = dumbSolution.getVariableValue(i);
		}

		Solution solution = new Solution();

		solution.setObjectives(objectives);
		solution.setVariables(variables);

		return solution;
	}

}
