package com.sda.javaremoteee21spring.service;

import com.sda.javaremoteee21spring.repository.MyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MyService {
    private final MyRepository repository;

    public MyService(MyRepository repository) {
        this.repository = repository;
    }

    public String shareOneSecret() {
        log.info("share one secret");
        return repository.shareMySecrets().get(0);
    }
}
