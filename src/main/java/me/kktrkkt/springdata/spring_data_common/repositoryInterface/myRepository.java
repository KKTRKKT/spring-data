package me.kktrkkt.springdata.spring_data_common.repositoryInterface;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface myRepository<T, Id extends Serializable> extends Repository<T, Id> {
    T save(T t);

    List<T> findAll();
}
