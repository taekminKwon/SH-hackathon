package com.example.hackathon.user.infrastructure;

import com.example.hackathon.user.domain.SHDto.SHUserAccountCommand;
import com.example.hackathon.user.domain.SHDto.SHUserAccountCriteria;
import com.example.hackathon.user.domain.SHDto.SHUserAccountInfo;
import com.example.hackathon.user.domain.SHUserAccountPort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SHMockUserAccountAdapter implements SHUserAccountPort {
    private static final Map<String, SHUserAccountInfo> db = new ConcurrentHashMap<>();

    @Override
    public SHUserAccountInfo createUserAccount(SHUserAccountCommand command) {
        String userUUID = UUID.randomUUID().toString();
        SHUserAccountInfo info = SHUserAccountInfo.builder()
                .userId(command.getUserId())
                .userName(command.getUserId().substring(0, command.getUserId().indexOf("@")))
                .institutionCode("00100")
                .userKey(userUUID)
                .created(LocalDateTime.now().toString())
                .modified(LocalDateTime.now().toString())
                .build();
        if (!db.containsKey(info.getUserId())) {
            db.put(command.getUserId(), info);
        } else {
            throw new IllegalArgumentException("이미 있는 사용자입니다");
        }

        return info;
    }

    @Override
    public SHUserAccountInfo getUserAccount(SHUserAccountCriteria criteria) {
        return db.get(criteria.getUserId());
    }
}
