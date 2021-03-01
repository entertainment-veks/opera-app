package opera.app.service.impl;

import java.util.List;
import opera.app.dao.StageDao;
import opera.app.model.Stage;
import opera.app.service.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StageServiceImpl implements StageService {
    private StageDao stageDao;

    @Autowired
    public StageServiceImpl(StageDao stageDao) {
        this.stageDao = stageDao;
    }

    @Override
    public Stage add(Stage stage) {
        return stageDao.add(stage);
    }

    @Override
    public List<Stage> getAll() {
        return stageDao.getAll();
    }

    @Override
    public Stage get(Long id) {
        return stageDao.get(id);
    }
}
