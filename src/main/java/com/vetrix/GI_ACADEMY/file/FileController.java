package com.vetrix.GI_ACADEMY.file;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
@Tag(name = "File")
@CrossOrigin("*")
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class FileController {
    @Autowired
    private FileService service;

    @PostMapping(path = "/file/{idLecon}")
    @Operation(summary = "Add New File")
    public File addFile(
            @RequestParam("file") MultipartFile file,
            @PathVariable UUID idLecon
            ){
        log.info("Controller save File ({})", file);
        return service.addFile(idLecon, file);
    }
    @GetMapping(path = "/unsecure/file")
    public List<File> getAllInfo(){
        return service.getAll();
    }
    @GetMapping(path = "/unsecure/file/{id}")
    public File getById(@PathVariable UUID id){
        return service.getImageById(id);
    }
    @GetMapping(path = "/unsecure/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(
            @PathVariable String fileName,
            HttpServletRequest request
    ){
        Resource resource = service.loadFile(fileName);
        String contentType = null;
        try{
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        }catch (IOException e) {
            System.out.println("Could Not Determine file ");
        }
        if (contentType == null){
            contentType = "application/octet-stream";
        }
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+fileName+"\"")
                .contentType(MediaType.parseMediaType(contentType))
                .body(resource);
    }
}
