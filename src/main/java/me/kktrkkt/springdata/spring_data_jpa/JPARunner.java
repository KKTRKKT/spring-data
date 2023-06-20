package me.kktrkkt.springdata.spring_data_jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Order(1)
@Component
@Transactional
public class JPARunner implements ApplicationRunner {

    /*
        @EnableJpaRepositories의 JpaRepositoriesRegistrar를 통해 repository를 가져오고,
        ImportBeanDefinitionRegistrar를 통해 repository를 정의해 빈으로 등록해준다
     */
    @Autowired
    private SampleEntityRepository entityRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        entityRepository.findAll().forEach(System.out::println);
    }
}
