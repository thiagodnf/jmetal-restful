package thiagodnf.jmetal.restful.solution;

import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.solution.impl.AbstractGenericSolution;

import thiagodnf.jmetal.restful.problem.DumbProblem;

public class DumbSolution extends AbstractGenericSolution<String, DumbProblem> {

	private static final long serialVersionUID = 6406921194725070152L;

	public DumbSolution(DumbProblem problem) {
		super(problem);
	}

	@Override
	public String getVariableValueString(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Solution<String> copy() {
		// TODO Auto-generated method stub
		return null;
	}

}
