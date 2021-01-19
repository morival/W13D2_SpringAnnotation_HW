package com.example.SpringAnnotation.components;

import com.example.SpringAnnotation.models.File;
import com.example.SpringAnnotation.models.Folder;
import com.example.SpringAnnotation.models.User;
import com.example.SpringAnnotation.repositories.FileRepository;
import com.example.SpringAnnotation.repositories.FolderRepository;
import com.example.SpringAnnotation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    FolderRepository folderRepository;

    @Autowired
    FileRepository fileRepository;


    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        User ryoko = new User("Ryoko");
        userRepository.save(ryoko);

        Folder pictures = new Folder("Pictures", ryoko);
        folderRepository.save(pictures);

        Folder projects = new Folder("Projects", ryoko);
        folderRepository.save(projects);

        File sunset = new File("Sunset", "JPEG", 5, pictures);
        fileRepository.save(sunset);

        File sunrise = new File("Sunrise", "JPEG", 4, pictures);
        fileRepository.save(sunrise);

        File springAnnotation = new File("Spring Annotation", "java", 1, projects);
        fileRepository.save(springAnnotation);
    }
}
