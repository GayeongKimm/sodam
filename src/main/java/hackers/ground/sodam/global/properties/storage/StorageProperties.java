package hackers.ground.sodam.global.properties.storage;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties("cloud.azure.storage.blob")
public class StorageProperties {
    private String accountName;
    private String endpoint;
}
