package thiagodnf.jmetal.restful.beans;

import java.util.HashMap;
import java.util.Map;

public class QualityIndicator {

	protected Map<String, Double> metrics;

	protected Map<String, Double> normalizedMetrics;

	public QualityIndicator() {
		this.metrics = new HashMap<String, Double>();
		this.normalizedMetrics = new HashMap<String, Double>();
	}

	public Map<String, Double> getMetrics() {
		return metrics;
	}

	public void setMetrics(Map<String, Double> metrics) {
		this.metrics = metrics;
	}

	public Map<String, Double> getNormalizedMetrics() {
		return normalizedMetrics;
	}

	public void setNormalizedMetrics(Map<String, Double> normalizedMetrics) {
		this.normalizedMetrics = normalizedMetrics;
	}

	@Override
	public String toString() {
		return "QualityIndicator [metrics=" + metrics + ", normalizedMetrics=" + normalizedMetrics + "]";
	}
}
