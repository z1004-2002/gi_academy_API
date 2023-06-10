package com.vetrix.GI_ACADEMY.file;

import com.vetrix.GI_ACADEMY.lecon.LeconRepository;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@Slf4j
@NoArgsConstructor
public class FileService {
    private FileRepository repository;
    private Path fileStorageLocation;
    private LeconRepository leconRepository;
    @Autowired
    public FileService(
            FileRepository repository,
            FileStorageProperties fileStorageProperties,
            LeconRepository leconRepository
    ){
        super();
        this.repository = repository;
        this.fileStorageLocation = Paths
                .get(System.getProperty("user.dir") + fileStorageProperties.getFileDir())
                .toAbsolutePath();
        this.leconRepository = leconRepository;
        log.info("========>Image Path = {}<========", fileStorageLocation);
        try{
            Files.createDirectories(this.fileStorageLocation);
        }catch (Exception ex){
            throw new RuntimeException("Could not create the directory to upload.");
        }
    }

    public List<File> getAll(){
        return repository.findAll();
    }
    public File getImageById(UUID id) {
        log.info("Service: Fetching Image {}", id);
        return repository.findById(id).get();
    }

    public File addFile(UUID idLecon,MultipartFile file){
        String completeName = "abe";
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder s = new StringBuilder(50);
        for (int i = 0; i < 50; i++) {
            int index = (int)(str.length() * Math.random());
            s.append(str.charAt(index));
        }
        completeName = String.valueOf(s);

        log.info("Image Name = {}", file.getOriginalFilename());
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try{
            Path targetLocation = this.fileStorageLocation.resolve(completeName+fileName);
            Files.copy(file.getInputStream(),targetLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                    .path(System.getProperty("user.dir")+"/src/main/resources/static/file/")
                    .path(completeName+fileName)
                    .toUriString();
            return repository.save(new File(
                    completeName+fileName,
                    file.getContentType(),
                    fileDownloadUri,
                    leconRepository.findById(idLecon).get()
            ));
        }catch (IOException ex){
            throw new RuntimeException("Could not store file " + completeName+fileName + ". Please try again!", ex);
        }
    }

    public Resource loadFile(String fileName){
        log.info("Load File = {} Successfully", fileName);
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists()){
                return resource;
            }else {
                throw new RuntimeException("Le fichier: " + fileName + " est introuvable");
            }
        }catch (MalformedURLException e){
            throw new RuntimeException("Le fichier: " + fileName + " est introuvable");
        }
    }

}