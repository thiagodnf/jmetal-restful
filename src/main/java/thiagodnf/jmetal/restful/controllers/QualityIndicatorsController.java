package thiagodnf.jmetal.restful.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import thiagodnf.jmetal.restful.beans.Entry;
import thiagodnf.jmetal.restful.beans.QualityIndicator;
import thiagodnf.jmetal.restful.jmetal.solution.DumbSolution;
import thiagodnf.jmetal.restful.utils.ConvertUtils;
import thiagodnf.jmetal.restful.utils.QualityIndicatorsUtils;

@RestController
public class QualityIndicatorsController {

	private final Logger LOGGER = LoggerFactory.getLogger(QualityIndicatorsController.class);

	@CrossOrigin
	@PostMapping(value = "/calculate/quality-indicators")
	public QualityIndicator greeting(@RequestBody Entry entry) {

		LOGGER.info("Converting to a list of dumb solutions");

		List<DumbSolution> paretoFront = ConvertUtils.toListOfDumbSolutions(entry.getParetoFront());
		List<DumbSolution> population = ConvertUtils.toListOfDumbSolutions(entry.getPopulation());

		LOGGER.info("Calculating the quality indicators");
		
		QualityIndicator qi = QualityIndicatorsUtils.calculate(paretoFront, population);

		LOGGER.info("Sending");

		return qi;
	}
}
