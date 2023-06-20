package me.kktrkkt.springdata.spring_data_jpa;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository 생략가능
public interface SampleEntityRepository extends JpaRepository<SampleEntity, Long> {
}
