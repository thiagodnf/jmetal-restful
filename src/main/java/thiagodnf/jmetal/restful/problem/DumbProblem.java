package thiagodnf.jmetal.restful.problem;

import org.uma.jmetal.problem.impl.AbstractGenericProblem;

import thiagodnf.jmetal.restful.solution.DumbSolution;

public class DumbProblem extends AbstractGenericProblem<DumbSolution> {

	private static final long serialVersionUID = 8038599262443013400L;

	public DumbProblem(int numberOfObjectives, int numberOfVariables) {
		setNumberOfVariables(numberOfVariables);
		setNumberOfObjectives(numberOfObjectives);
		setName(DumbProblem.class.getSimpleName());
	}

	@Override
	public void evaluate(DumbSolution solution) {
		
		
	}

	@Override
	public DumbSolution createSolution() {
		return null;
	}
}
