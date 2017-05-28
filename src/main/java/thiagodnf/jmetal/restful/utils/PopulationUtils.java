package thiagodnf.jmetal.restful.utils;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkArgument;

import thiagodnf.jmetal.restful.beans.Population;
import thiagodnf.jmetal.restful.beans.Sol;

/**
 * The utility class for getting some information about the {@link Population}
 * class. For example, given a population object, you are able to get the number
 * of objectives and the number of variables
 * 
 * @author Thiago Ferreira
 * @version 1.0.0
 * @since 2017-05-28
 */
public class PopulationUtils {

	public static int getNumberOfObjectives(Population population) {

		checkNotNull(population, "The population object cannot be null");
		checkArgument(population.getSolutions().size() != 0, "The population has not solutions");

		int numberOfObjectives = -1;

		for (Sol solution : population.getSolutions()) {

			if (numberOfObjectives == -1) {
				numberOfObjectives = solution.getObjectives().length;
			}

			// All solutions in the population should have the same number
			// of objectives
			if (numberOfObjectives != solution.getObjectives().length) {
				throw new IllegalArgumentException("The number of objectives should not be different");
			}
		}

		return numberOfObjectives;
	}

	public static int getNumberOfVariables(Population population) {

		checkNotNull(population, "The population object cannot be null");
		checkArgument(population.getSolutions().size() != 0, "The population has not solutions");

		int numberOfVariables = -1;

		for (Sol solution : population.getSolutions()) {

			if (numberOfVariables == -1) {
				numberOfVariables = solution.getVariables().length;
			}

			// All solutions in the population should have the same number
			// of variables
			if (numberOfVariables != solution.getVariables().length) {
				throw new IllegalArgumentException("The number of variables should not be different");
			}
		}

		return numberOfVariables;
	}

}
