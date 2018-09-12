package br.com.github.timeto.service;

import br.com.github.timeto.model.TimeTo;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

@Service
public class TimeToService {

    public TimeTo timeTo(Integer hour, Integer minute, String zone) {

        if (Objects.isNull(zone)) {
            zone = ZoneId.systemDefault().getId();
        }

        final ZoneId zoneId = ZoneId.of(zone);

        return TimeTo.builder()
                .currentTime(LocalDateTime.now(zoneId))
                .timeTo(LocalTime.MIN.plus(Duration.ofMinutes(LocalTime.now(zoneId)
                .until(LocalTime.of(hour, minute), ChronoUnit.MINUTES)))
                .toString())
                .zoneId(zone)
                .build();

    }

}
