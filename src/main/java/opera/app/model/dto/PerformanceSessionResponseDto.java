package opera.app.model.dto;

import java.time.LocalDateTime;

public class PerformanceSessionResponseDto {
    private Long performanceSessionId;
    private LocalDateTime showTime;
    private String performanceTitle;
    private Long performanceId;
    private Long cinemaHallId;

    public Long getPerformanceSessionId() {
        return performanceSessionId;
    }

    public void setPerformanceSessionId(Long performanceSessionId) {
        this.performanceSessionId = performanceSessionId;
    }

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
