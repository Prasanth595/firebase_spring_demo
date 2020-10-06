package com.ravi.firebase.demo.service;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FBInitialize {
    @Autowired
    ResourceLoader resourceLoader;

    @PostConstruct
    public void init() {
        try {
            Resource resource = resourceLoader.getResource(
                    "classpath:choco-bar-firebase-adminsdk-jgg47-4c4b2a2814.json");
            FileInputStream serviceAccount =
                    new FileInputStream(resource.getFile());

            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://choco-bar.firebaseio.com")
                    .build();

            FirebaseApp.initializeApp(options);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
