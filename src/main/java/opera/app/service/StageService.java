package opera.app.service;

import java.util.List;
import opera.app.model.Stage;

public interface StageService {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage get(Long id);
}
