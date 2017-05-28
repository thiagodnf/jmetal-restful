package thiagodnf.jmetal.restful.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.uma.jmetal.util.SolutionListUtils;

import thiagodnf.jmetal.restful.beans.Population;
import thiagodnf.jmetal.restful.solution.DumbSolution;
import thiagodnf.jmetal.restful.utils.ConvertUtils;

@RestController
public class ParetoFrontController {

	@CrossOrigin
	@PostMapping(value = "/generator/pareto-front")
	public Population greeting(@RequestBody Population population) {

		System.out.println(population);

		List<DumbSolution> newPopulation = ConvertUtils.toListOfDumbSolutions(population);

		List<DumbSolution> paretoFront = SolutionListUtils.getNondominatedSolutions(newPopulation);

		System.out.println(paretoFront);
		return ConvertUtils.toPopulation(paretoFront);
	}
}
