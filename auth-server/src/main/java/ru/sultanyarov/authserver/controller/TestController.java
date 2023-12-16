package ru.sultanyarov.authserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sultanyarov.authserver.exception.NotFoundException;

@RestController
public class TestController {
    @GetMapping("/")
    public void test() {
        throw new NotFoundException();
    }
}
