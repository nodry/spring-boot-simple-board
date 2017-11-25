package com.ohn.simpleboard.domain.board;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

public interface BoardRepository extends JpaRepository<Board, Long>, QueryDslPredicateExecutor<Board> {

}