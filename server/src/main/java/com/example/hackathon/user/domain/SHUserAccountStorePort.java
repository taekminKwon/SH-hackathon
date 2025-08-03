package com.example.hackathon.user.domain;

import com.example.hackathon.user.domain.SHDto.SHUserAccountCommand;
import com.example.hackathon.user.domain.SHDto.SHUserAccountInfo;

public interface SHUserAccountStorePort {
    /**
     * 사용자의 계정을 생성합니다
     */
    SHUserAccountInfo createUserAccount(SHUserAccountCommand command);
}
