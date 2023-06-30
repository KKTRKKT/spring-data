package me.kktrkkt.springdata.spring_data_common.query_dsl;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class AccountRepositoryTest {
    
    @Autowired
    private AccountRepository accountRepository;

    @Test
    void findOne() {
        Account account = new Account();
        account.setUsername("leesh");
        account.setNickname("kktrkkt");

        accountRepository.save(account);

        QAccount qAccount = QAccount.account;
        BooleanExpression expression = qAccount.nickname.containsIgnoreCase("trk")
                .and(qAccount.username.startsWithIgnoreCase("lee"));

        Optional<Account> one = accountRepository.findOne(expression);
        assertTrue(one.isPresent());
    }
}