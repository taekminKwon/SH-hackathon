package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountDeletionREC;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class DeletedAccountInfo {
    private String accountNo;
    private String refundAccountNo;

    public static DeletedAccountInfo of(SHAccountDeletionREC shAccountDeletionREC) {
        DeletedAccountInfo deletedAccountInfo = new DeletedAccountInfo();
        deletedAccountInfo.accountNo = shAccountDeletionREC.getAccountNo();
        deletedAccountInfo.refundAccountNo = shAccountDeletionREC.getRefundAccountNo();
        return deletedAccountInfo;
    }
}
