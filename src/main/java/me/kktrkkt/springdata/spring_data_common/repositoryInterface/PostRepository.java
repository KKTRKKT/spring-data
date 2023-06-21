package me.kktrkkt.springdata.spring_data_common.repositoryInterface;

import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

@RepositoryDefinition(domainClass = Post.class, idClass = Long.class)
public interface PostRepository {
    Post save(Post post);

    List<Post> findAll();
}
