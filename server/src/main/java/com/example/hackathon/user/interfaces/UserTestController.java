package com.example.hackathon.user.interfaces;

import com.example.hackathon.user.domain.SHDto.SHUserAccountCommand;
import com.example.hackathon.user.domain.SHDto.SHUserAccountInfo;
import com.example.hackathon.user.domain.SHUserAccountStorePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test/users")
public class UserTestController {
    private final SHUserAccountStorePort port;

    @PostMapping
    public ResponseEntity<SHUserAccountInfo> createUserInfo(@RequestBody SHUserAccountCommand command) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(port.createUserAccount(command));
    }
}
