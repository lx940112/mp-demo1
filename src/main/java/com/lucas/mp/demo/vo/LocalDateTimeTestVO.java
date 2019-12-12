package com.lucas.mp.demo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @author Lucas
 */
public class LocalDateTimeTestVO {
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime dateTimes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDateTimes() {
        return dateTimes;
    }

    public void setDateTimes(LocalDateTime dateTimes) {
        this.dateTimes = dateTimes;
    }

    @Override
    public String toString() {
        return "LocalDateTimeTestVO{" +
                "name='" + name + '\'' +
                ", dateTimes=" + dateTimes +
                '}';
    }
}
