package opera.app.controller;

import opera.app.model.Stage;
import opera.app.model.dto.StageRequestDto;
import opera.app.model.dto.StageResponseDto;
import opera.app.service.StageService;
import opera.app.service.mapper.StageMapper;
import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stages")
public class StageController {
    private final StageService stageService;
    private final StageMapper stageMapper;

    @Autowired
    public StageController(StageService stageService,
                           StageMapper stageMapper) {
        this.stageService = stageService;
        this.stageMapper = stageMapper;
    }

    @PostMapping
    public void saveStage(@RequestBody @Valid StageRequestDto stageRequestDto) {
        Stage current = stageMapper.parseFromDto(stageRequestDto);
        stageService.add(current);
    }

    @GetMapping
    public List<StageResponseDto> getAllStages() {
        return stageService.getAll().stream()
                .map(stageMapper::parseToDto)
                .collect(Collectors.toList());
    }
}
