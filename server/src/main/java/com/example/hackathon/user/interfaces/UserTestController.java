package com.example.hackathon.user.interfaces;

import com.example.hackathon.user.domain.SHDto.SHUserAccountCommand;
import com.example.hackathon.user.domain.SHDto.SHUserAccountCriteria;
import com.example.hackathon.user.domain.SHDto.SHUserAccountInfo;
import com.example.hackathon.user.domain.SHUserAccountPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/test/users")
public class UserTestController {
    private final SHUserAccountPort port;

    @PostMapping
    public ResponseEntity<SHUserAccountInfo> createUserInfo(@RequestBody SHUserAccountCommand command) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(port.createUserAccount(command));
    }

    @GetMapping
    public ResponseEntity<SHUserAccountInfo> getUserInfo(@RequestBody SHUserAccountCriteria criteria) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(port.getUserAccount(criteria));
    }
}
