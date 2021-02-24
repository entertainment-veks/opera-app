package opera.app.dao;

import opera.app.model.Stage;
import java.util.List;

public interface StageDao {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage get(Long id);
}
