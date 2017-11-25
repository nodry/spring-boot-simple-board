package com.ohn.simpleboard.domain.board;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class BoardPredicate {

    public static Predicate search(String s1, String s2){
        QBoard board = QBoard.board;
        BooleanBuilder builder = new BooleanBuilder();

        if(s1 != null){
            builder.and(board.title.like("%"+s1+"%"));
        }
        if(s2 != null){
            builder.and(board.contents.like("%"+s2+"%"));
        }

        return builder;
    }
}
