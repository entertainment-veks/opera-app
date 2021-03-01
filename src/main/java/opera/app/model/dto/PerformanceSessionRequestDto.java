package opera.app.model.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class PerformanceSessionRequestDto {
    @NotNull
    private LocalDateTime showTime;
    @NotNull
    private String performanceTitle;
    @NotNull
    private Long performanceId;
    @NotNull
    private Long cinemaHallId;

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    public String getPerformanceTitle() {
        return performanceTitle;
    }

    public void setPerformanceTitle(String performanceTitle) {
        this.performanceTitle = performanceTitle;
    }

    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public Long getCinemaHallId() {
        return cinemaHallId;
    }

    public void setCinemaHallId(Long cinemaHallId) {
        this.cinemaHallId = cinemaHallId;
    }
}
