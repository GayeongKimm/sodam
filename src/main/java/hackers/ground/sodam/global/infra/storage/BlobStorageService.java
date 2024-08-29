package hackers.ground.sodam.global.infra.storage;

import com.azure.storage.blob.BlobAsyncClient;
import com.azure.storage.blob.BlobContainerAsyncClient;
import com.azure.storage.blob.BlobContainerClient;
import com.azure.storage.blob.BlobContainerClientBuilder;
import com.azure.storage.blob.models.ParallelTransferOptions;
import hackers.ground.sodam.global.properties.storage.StorageProperties;
import hackers.ground.sodam.global.response.ResponseData;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.UUID;
//
//@RequiredArgsConstructor
//@Service
//public class BlobStorageService {
//    private final BlobContainerAsyncClient blobContainerAsyncClient;
//    int blockSize = 10 * 1024;
//    int numBuffers = 5;
//
//    public ResponseData<String> upload(MultipartFile multipartFile, String dirName) throws IOException {
//        String originFileName = multipartFile.getOriginalFilename();
//
//        String uuid = UUID.randomUUID().toString();
//        assert originFileName!= null;
//        String uniqueFileName = uuid + "_" + originFileName.replaceAll("\\s", "_");
//
//        String fileName = dirName + "/" + uniqueFileName;
//
//        BlobAsyncClient blobAsyncClient = blobContainerAsyncClient.getBlobAsyncClient(fileName);
//        Flux<ByteBuffer> data = Flux.just(ByteBuffer.wrap(multipartFile.getInputStream().readAllBytes()));
//        ParallelTransferOptions parallelTransferOptions = new ParallelTransferOptions(numBuffers, blockSize, null);
//        blobAsyncClient.upload(data,parallelTransferOptions, true).block();
//
//        return ResponseData.of(HttpStatus.OK, "성공", blobAsyncClient.getBlobUrl());
//    }
//
//}