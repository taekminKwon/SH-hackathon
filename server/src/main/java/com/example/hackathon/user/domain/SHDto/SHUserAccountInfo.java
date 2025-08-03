package com.example.hackathon.user.domain.SHDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SHUserAccountInfo {
    private String userId;
    private String userName;
    private String institutionCode;
    private String userKey;
    private String created;
    private String modified;

    @Builder
    public SHUserAccountInfo(
            String userId,
            String userName,
            String institutionCode,
            String userKey,
            String created,
            String modified
    ) {
        this.userId = userId;
        this.userName = userName;
        this.institutionCode = institutionCode;
        this.userKey = userKey;
        this.created = created;
        this.modified = modified;
    }
}
