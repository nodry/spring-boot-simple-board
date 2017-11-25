package com.ohn.simpleboard.domain.board;

import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.Date;

@StaticMetamodel(Board.class)
public class Board_ {

    public static volatile SingularAttribute<Board, Long> board_index;
    public static volatile SingularAttribute<Board, String> title;
    public static volatile SingularAttribute<Board, String> contents;
    public static volatile SingularAttribute<Board, String> name;
    public static volatile SingularAttribute<Board, Date> date;

}