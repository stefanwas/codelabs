package com.stefan.handythings.resources;

import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

public class ClasspathResourceExample {
    private static final String CONFIG_FILE = "component_config.yml";  //to jest względem resource root folderu

    public static void main(String[] args) throws IOException {

        // tego nie stestowałem
        ClassPathResource classPathResource = new ClassPathResource(CONFIG_FILE);
        InputStream inputStream1 = classPathResource.getInputStream();

        // to działało zawsze
        InputStream inputStream2 = new ClasspathResourceExample().getClass().getClassLoader().getResourceAsStream(CONFIG_FILE);

        // to działało tylko lokalnie na Win7 ale już nie na linuxie
        InputStream inputStream3 = ClassLoader.getSystemResourceAsStream(CONFIG_FILE);

    }

}
