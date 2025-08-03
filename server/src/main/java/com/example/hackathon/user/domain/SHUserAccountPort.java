package com.example.hackathon.user.domain;

import com.example.hackathon.user.domain.SHDto.SHUserAccountCommand;
import com.example.hackathon.user.domain.SHDto.SHUserAccountCriteria;
import com.example.hackathon.user.domain.SHDto.SHUserAccountInfo;

public interface SHUserAccountPort {
    /**
     * 사용자의 계정을 생성합니다
     */
    SHUserAccountInfo createUserAccount(SHUserAccountCommand command);

    /**
     * 사용자의 계정을 조회합니다
     */
    SHUserAccountInfo getUserAccount(SHUserAccountCriteria criteria);
}
