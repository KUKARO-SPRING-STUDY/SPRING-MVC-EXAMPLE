package org.example.springmvcexample.dto;

import java.time.LocalDateTime;

public class InfoDto {
    private final String version;
    private final String appName;
    private final LocalDateTime startTime;

    public InfoDto(
            String version,
            String appName,
            LocalDateTime startTime
    ) {
        this.version = version;
        this.appName = appName;
        this.startTime = startTime;
    }

    public String getVersion() {
        return version;
    }

    public String getAppName() {
        return appName;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }
}
