package Jobs;

import Entity.Category;
import Entity.CategoryStatus;

import java.util.List;

public interface EntityBuilderInterface {
    List<Category> readEntity(CategoryStatus categoryStatus);
}
