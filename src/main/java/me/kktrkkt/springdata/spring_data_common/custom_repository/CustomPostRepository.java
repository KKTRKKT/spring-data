package me.kktrkkt.springdata.spring_data_common.custom_repository;

import java.util.List;

public interface CustomPostRepository {

    List<Post> findByMyPost(Account account);

    void delete(Post post);
}
