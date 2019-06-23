//basic metric interface
package KNN;

import com.softultra.almamater.models.Survey;
import com.softultra.almamater.models.University;

public interface Metric {
	double getDistance(University s, Survey e);
}
