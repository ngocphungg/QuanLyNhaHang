package Model;

import org.jfree.data.category.DefaultCategoryDataset;
import java.util.ArrayList;

public class ChartModel {

    public DefaultCategoryDataset fetchDataForYear(String year) {
        // This method is now simpler and just returns a dataset for a given year
        // The actual database retrieval is handled in the controller
        return new DefaultCategoryDataset();
    }
    public ArrayList<String> fetchYears() {
        // This method is now simpler and just returns a list of available years
        // The actual database retrieval is handled in the controller
        return new ArrayList<String>();
    }
}
