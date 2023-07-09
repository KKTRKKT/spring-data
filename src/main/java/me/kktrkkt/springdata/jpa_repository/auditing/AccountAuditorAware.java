package me.kktrkkt.springdata.jpa_repository.auditing;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountAuditorAware implements AuditorAware<Account> {

    @Override
    public Optional<Account> getCurrentAuditor() {
        // 시큐리티 컨텍스트에서 현재 접속한 유저 정보를 가져와서 반환하면 된다.
//        return Optional.ofNullable(SecurityContextHolder.getContext())
//                .map(SecurityContext::getAuthentication)
//                .filter(Authentication::isAuthenticated)
//                .map(Authentication::getPrincipal)
//                .map(Account.class::cast);
        System.out.println("getCurrentAuditor");
        return Optional.empty();
    }
}
