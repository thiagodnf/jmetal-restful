package thiagodnf.jmetal.restful.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.uma.jmetal.util.SolutionListUtils;

import thiagodnf.jmetal.restful.beans.Population;
import thiagodnf.jmetal.restful.jmetal.solution.DumbSolution;
import thiagodnf.jmetal.restful.utils.ConvertUtils;

@RestController
public class ParetoFrontController {

	private final Logger LOGGER = LoggerFactory.getLogger(ParetoFrontController.class);

	@CrossOrigin
	@PostMapping(value = "/generator/pareto-front")
	public Population greeting(@RequestBody Population population) {

		LOGGER.info("Converting for a list of dumb solutions");

		List<DumbSolution> newPopulation = ConvertUtils.toListOfDumbSolutions(population);

		LOGGER.info("Generating the pareto-front set");

		List<DumbSolution> paretoFront = SolutionListUtils.getNondominatedSolutions(newPopulation);

		LOGGER.info("Converting for a population object instance");

		Population pParetoFront = ConvertUtils.toPopulation(paretoFront);

		LOGGER.info("Sending");

		return pParetoFront;
	}
}
