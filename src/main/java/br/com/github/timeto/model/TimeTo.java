package br.com.github.timeto.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class TimeTo {

    private String zoneId;
    private String timeTo;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime currentTime;

}
