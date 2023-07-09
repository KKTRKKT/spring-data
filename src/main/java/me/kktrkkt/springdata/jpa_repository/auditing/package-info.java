package me.kktrkkt.springdata.jpa_repository.auditing;

/*
엔티티가 생성되거나 변경되는 시점과 사람을 추적할 수 있는 기능을 제공하는 auditing에 대해 알아본다.

1. @EnableJpaAuditing 설정을 추가한다.
2. 엔티티에 @EntityListeners(AuditingEntityListener.class)를 추가한다.
3. 사용자를 추적하기 위해서 AuditorAware<T>를 구현해 빈으로 등록한다.

 */