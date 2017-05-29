package thiagodnf.jmetal.restful.utils;

import java.util.List;

import org.uma.jmetal.qualityindicator.impl.Epsilon;
import org.uma.jmetal.qualityindicator.impl.ErrorRatio;
import org.uma.jmetal.qualityindicator.impl.GenerationalDistance;
import org.uma.jmetal.qualityindicator.impl.InvertedGenerationalDistance;
import org.uma.jmetal.qualityindicator.impl.InvertedGenerationalDistancePlus;
import org.uma.jmetal.qualityindicator.impl.Spread;
import org.uma.jmetal.qualityindicator.impl.hypervolume.PISAHypervolume;
import org.uma.jmetal.solution.Solution;
import org.uma.jmetal.util.front.Front;
import org.uma.jmetal.util.front.imp.ArrayFront;
import org.uma.jmetal.util.front.util.FrontNormalizer;
import org.uma.jmetal.util.front.util.FrontUtils;
import org.uma.jmetal.util.point.util.PointSolution;

import thiagodnf.jmetal.restful.beans.QualityIndicator;

public class QualityIndicatorsUtils {

	public static <S extends Solution<?>> QualityIndicator calculate(List<S> paretoFront, List<S> population){
		
		Front referenceFront = new ArrayFront(paretoFront);
	    FrontNormalizer frontNormalizer = new FrontNormalizer(referenceFront) ;

	    Front normalizedReferenceFront = frontNormalizer.normalize(referenceFront) ;
	    Front normalizedFront = frontNormalizer.normalize(new ArrayFront(population)) ;
	    List<PointSolution> normalizedPopulation = FrontUtils.convertFrontToSolutionList(normalizedFront) ;

	    QualityIndicator qi = new QualityIndicator();
	    
	    qi.getNormalizedMetrics().put("hypervolume", new PISAHypervolume<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation));
	    qi.getNormalizedMetrics().put("epsilon",new Epsilon<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation));
	    qi.getNormalizedMetrics().put("gd", new GenerationalDistance<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation));
	    qi.getNormalizedMetrics().put("igd", new InvertedGenerationalDistance<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation));
	    qi.getNormalizedMetrics().put("igd_plus", new InvertedGenerationalDistancePlus<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation));
	    qi.getNormalizedMetrics().put("spread", new Spread<PointSolution>(normalizedReferenceFront).evaluate(normalizedPopulation));
	    
		qi.getMetrics().put("hypervolume", new PISAHypervolume<S>(referenceFront).evaluate(population));
	    qi.getMetrics().put("epsilon", new Epsilon<S>(referenceFront).evaluate(population));
	    qi.getMetrics().put("gd", new GenerationalDistance<S>(referenceFront).evaluate(population));
	    qi.getMetrics().put("igd", new InvertedGenerationalDistance<S>(referenceFront).evaluate(population));
	    qi.getMetrics().put("igd_plus", new InvertedGenerationalDistancePlus<S>(referenceFront).evaluate(population));
	    qi.getMetrics().put("spread", new Spread<S>(referenceFront).evaluate(population));
	    qi.getMetrics().put("error_ratio", new ErrorRatio<List<? extends Solution<?>>>(referenceFront).evaluate(population));
	    
	    return qi;
	}
}
