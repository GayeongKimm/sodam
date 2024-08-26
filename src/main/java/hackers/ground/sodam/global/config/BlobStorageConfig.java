package hackers.ground.sodam.global.config;

import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import hackers.ground.sodam.global.properties.storage.StorageProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BlobStorageConfig {

    private final StorageProperties storageProperties;

    public BlobStorageConfig(StorageProperties storageProperties) {
        this.storageProperties = storageProperties;
    }

    @Bean
    public BlobContainerAsyncClient blobContainerAsyncClient() {
        return new BlobContainerClientBuilder()
                .connectionString(storageProperties.getEndpoint())
                .containerName(storageProperties.getAccountName())
                .buildAsyncClient();
    }
}
