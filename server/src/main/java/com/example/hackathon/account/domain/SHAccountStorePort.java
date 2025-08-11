package com.example.hackathon.account.domain;

import com.example.hackathon.account.domain.shResponse.SHAccountCreationREC;
import com.example.hackathon.account.domain.shResponse.SHAccountDeletionREC;
import com.example.hackathon.account.domain.shResponse.SHAccountREC;

public interface SHAccountStorePort {
    SHAccountCreationREC createAccountSummary(AccountCreationCommand command);

    SHAccountDeletionREC deleteAccountSummary(SHAccountREC shAccountREC, String refundAccountNo, String userKey);
}
