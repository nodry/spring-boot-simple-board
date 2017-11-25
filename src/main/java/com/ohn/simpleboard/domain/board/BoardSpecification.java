package com.ohn.simpleboard.domain.board;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class BoardSpecification {

    public static Specification<Board> searchTtile(final String searchString) {
        if (searchString == null) {
            return null;
        } else {
            return new Specification<Board>() {
                @Override
                public Predicate toPredicate(Root<Board> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                    return cb.like(root.get(Board_.title), "%"+searchString+"%");
                }
            };
        }
    }

    public static Specification<Board> searchContents(final String searchString) {
        if (searchString == null) {
            return null;
        } else {
            //lamda
            return (root, query, cb) -> cb.like(root.get(Board_.contents), "%"+searchString+"%");
        }
    }

}
