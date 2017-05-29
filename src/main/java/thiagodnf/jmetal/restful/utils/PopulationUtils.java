package thiagodnf.jmetal.restful.utils;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import thiagodnf.jmetal.restful.beans.Population;
import thiagodnf.jmetal.restful.beans.Solution;
import thiagodnf.jmetal.restful.jmetal.solution.DumbSolution;

/**
 * this utility class is for getting some information about the {@link Population}
 * class. For example, given a population object, you are able to get the number
 * of objectives and the number of variables
 * 
 * @author Thiago N. Ferreira
 * @version 1.0.0
 * @since 2017-05-28
 */
public class PopulationUtils {

	/**
	 * Return the number of objectives given a {@link Population} instance
	 * 
	 * @param population the population instance that we want the number of objectives
	 * @return the number of objectives
	 */
	public static int getNumberOfObjectives(Population population) {

		checkNotNull(population, "The population object cannot be null");
		checkArgument(population.getSolutions().size() != 0, "The population has not solutions");

		int numberOfObjectives = -1;

		for (Solution solution : population.getSolutions()) {

			if (numberOfObjectives == -1) {
				numberOfObjectives = solution.getObjectives().length;
			}

			// All solutions in the population should have the same number of objectives
			if (numberOfObjectives != solution.getObjectives().length) {
				throw new IllegalArgumentException("The number of objectives should not be different");
			}
		}

		return numberOfObjectives;
	}

	/**
	 * Return the number of variables given a {@link Population} instance
	 * 
	 * @param population the population instance that we want the number of variables
	 * @return the number of variables
	 */
	public static int getNumberOfVariables(Population population) {

		checkNotNull(population, "The population object cannot be null");
		checkArgument(population.getSolutions().size() != 0, "The population has not solutions");

		int numberOfVariables = -1;

		for (Solution solution : population.getSolutions()) {

			if (numberOfVariables == -1) {
				numberOfVariables = solution.getVariables().length;
			}

			// All solutions in the population should have the same number of variables
			if (numberOfVariables != solution.getVariables().length) {
				throw new IllegalArgumentException("The number of variables should not be different");
			}
		}

		return numberOfVariables;
	}

	public static List<DumbSolution> removeRepeatedSolutions(List<DumbSolution> population) {
		List<DumbSolution> newPopulation = new ArrayList<>();

		for (DumbSolution s : population) {

			if (!contains(newPopulation, s)) {
				newPopulation.add(s.copy());
			}
		}

		return newPopulation;
	}

	public static boolean contains(List<DumbSolution> population, DumbSolution s1) {

		checkNotNull(population, "The population object cannot be null");
		checkNotNull(s1, "The solution s1 object cannot be null");

		for (DumbSolution s2 : population) {

			if (isEqual(s1, s2)) {
				return true;
			}
		}

		return false;
	}

	public static boolean isEqual(DumbSolution s1, DumbSolution s2) {

		checkNotNull(s1, "The solution s1 object cannot be null");
		checkNotNull(s2, "The solution s2 object cannot be null");
		checkArgument(s1.getNumberOfObjectives() == s2.getNumberOfObjectives(),	"the number of objectives should be equal");

		for (int i = 0; i < s1.getNumberOfObjectives(); i++) {

			if (s1.getObjective(i) != s2.getObjective(i)) {
				return false;
			}
		}

		return true;
	}

}
