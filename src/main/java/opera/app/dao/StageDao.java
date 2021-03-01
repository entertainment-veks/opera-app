package opera.app.dao;

import java.util.List;
import opera.app.model.Stage;

public interface StageDao {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage get(Long id);
}
