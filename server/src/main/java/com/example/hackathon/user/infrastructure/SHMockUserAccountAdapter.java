package com.example.hackathon.user.infrastructure;

import com.example.hackathon.user.domain.SHDto.SHUserAccountCommand;
import com.example.hackathon.user.domain.SHDto.SHUserAccountInfo;
import com.example.hackathon.user.domain.SHUserAccountPort;
import com.example.hackathon.user.domain.SHUserAccountStorePort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SHMockUserAccountAdapter implements SHUserAccountPort {
    private static final Map<String, String> db = new ConcurrentHashMap<>();

    @Override
    public SHUserAccountInfo createUserAccount(SHUserAccountCommand command) {
        String userUUID = UUID.randomUUID().toString();
        db.put(command.getUserId(), userUUID);
        return SHUserAccountInfo.builder()
                .userId(command.getUserId())
                .userName(command.getUserId().substring(0, command.getUserId().indexOf("@")))
                .institutionCode("00100")
                .userKey(userUUID)
                .created(LocalDateTime.now().toString())
                .modified(LocalDateTime.now().toString())
                .build();
    }
}
