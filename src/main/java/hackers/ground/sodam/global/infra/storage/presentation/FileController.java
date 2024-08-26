package hackers.ground.sodam.global.infra.storage.presentation;

import hackers.ground.sodam.global.infra.storage.BlobStorageService;
import hackers.ground.sodam.global.response.ResponseData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/file")
public class FileController {
    private final BlobStorageService blobStorageService;

    @PostMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseData<String> handleFileUpload(
            @RequestPart("file") MultipartFile multipartFile) throws IOException {
        return blobStorageService.upload(multipartFile, "file");
    }
}