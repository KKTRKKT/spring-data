package me.kktrkkt.springdata.spring_data_common.custom_repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class CustomPostRepositoryDefault implements CustomPostRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Post> findByMyPost(Account account) {
        TypedQuery<Post> query = entityManager.createQuery(
                "SELECT post " +
                        "FROM Post AS post " +
                        "WHERE post.account.id = " + account.getId(), Post.class);
        return query.getResultList();
    }

    @Override
    public void delete(Post post) {
        entityManager.detach(post);
    }
}
