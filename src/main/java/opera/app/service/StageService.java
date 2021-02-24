package opera.app.service;

import opera.app.model.Stage;

import java.util.List;

public interface StageService {
    Stage add(Stage stage);

    List<Stage> getAll();

    Stage get(Long id);
}
