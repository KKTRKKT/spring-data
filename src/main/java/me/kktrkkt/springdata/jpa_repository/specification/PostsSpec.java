package me.kktrkkt.springdata.jpa_repository.specification;

import org.springframework.data.jpa.domain.Specification;

public class PostsSpec {

    public static Specification<Post> isBest() {
        return (root, query, builder) -> builder.greaterThan(root.get("viewCount"), 100);
    }

    public static Specification<Post> isPublic() {
        return (root, query, builder) -> builder.isFalse(root.get("isPrivate"));
    }
}
