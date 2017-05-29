package thiagodnf.jmetal.restful.jmetal.solution;

import java.util.HashMap;

import org.uma.jmetal.solution.impl.AbstractGenericSolution;

import thiagodnf.jmetal.restful.jmetal.problem.DumbProblem;

public class DumbSolution extends AbstractGenericSolution<String, DumbProblem> {

	private static final long serialVersionUID = 6406921194725070152L;

	public DumbSolution(DumbProblem problem) {
		super(problem);
	}
	
	/** Copy constructor */
	public DumbSolution(DumbSolution solution) {
		super(solution.problem);

		for (int i = 0; i < problem.getNumberOfVariables(); i++) {
			setVariableValue(i, solution.getVariableValue(i));
		}

		for (int i = 0; i < problem.getNumberOfObjectives(); i++) {
			setObjective(i, solution.getObjective(i));
		}

		attributes = new HashMap<Object, Object>(solution.attributes);
	}

	@Override
	public String getVariableValueString(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DumbSolution copy() {
		return new DumbSolution(this);
	}
}
