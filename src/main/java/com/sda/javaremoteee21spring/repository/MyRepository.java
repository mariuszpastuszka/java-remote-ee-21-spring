package com.sda.javaremoteee21spring.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class MyRepository {

    public List<String> shareMySecrets() {
        log.info("getting secrets from data source");
        return List.of("secret1", "secret2");
    }
}
