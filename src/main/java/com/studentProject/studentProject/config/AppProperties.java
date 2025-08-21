package com.studentProject.studentProject.config;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix = "app")  // Binds values under "app" in YAML
@Validated  // Ensures validation annotations are enforced
public class AppProperties {

    @NotBlank(message = "App name must not be blank")
    private String name;

    @NotBlank(message = "Version must be at least 1")
    private String version;

    // Example of a feature toggle
    private boolean enableFeatureX;

    // --- Getters and Setters ---

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isEnableFeatureX() {
        return enableFeatureX;
    }

    public void setEnableFeatureX(boolean enableFeatureX) {
        this.enableFeatureX = enableFeatureX;
    }
}
