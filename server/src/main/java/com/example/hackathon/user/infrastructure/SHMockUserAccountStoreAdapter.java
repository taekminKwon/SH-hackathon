package com.example.hackathon.user.infrastructure;

import com.example.hackathon.user.domain.SHDto.SHUserAccountCommand;
import com.example.hackathon.user.domain.SHDto.SHUserAccountInfo;
import com.example.hackathon.user.domain.SHUserAccountStorePort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class SHMockUserAccountStoreAdapter implements SHUserAccountStorePort {

    @Override
    public SHUserAccountInfo createUserAccount(SHUserAccountCommand command) {
        return SHUserAccountInfo.builder()
                .userId(command.getUserId())
                .userName(command.getUserId().substring(0, command.getUserId().indexOf("@")))
                .institutionCode("00100")
                .userKey(UUID.randomUUID().toString())
                .created(LocalDateTime.now().toString())
                .modified(LocalDateTime.now().toString())
                .build();
    }
}
