package com.ohn.simpleboard;

import com.ohn.simpleboard.domain.board.Board;
import com.ohn.simpleboard.domain.board.BoardPredicate;
import com.ohn.simpleboard.domain.board.BoardRepository;
import com.ohn.simpleboard.domain.board.QBoard;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BoardCRUDTest {

    final String    NAME           = "meditator";
    final String    TITLE          = "test hibernate title";
    final String    UPDATED_TITLE  = "test hibernate Updated title";
    final String    CONTENTS       = "test hibernate contents";
    final String    SEARCH         = "hibernate";
    final Long      ID             = 1L;

    @Autowired
    private BoardRepository boardRepository;
    @Autowired
    private SessionFactory sessionFactory;

    @Before
    public void shouldHaveASessionFactory() {
        assertNotNull(sessionFactory);
    }

    @Test
    public void test01_insert() {
        Board board = new Board();

        board.setName(NAME);
        board.setTitle(TITLE);
        board.setContents(CONTENTS);

        boardRepository.save(board);
    }

    @Test
    public void test02_findAll() {
        List<Board> boards = boardRepository.findAll();

        assertEquals(boards.get(0).getName(), NAME);
        assertEquals(boards.get(0).getTitle(), TITLE);
        assertEquals(boards.get(0).getContents(), CONTENTS);
    }

    @Test
    public void test02_update() {
        Board board = new Board();

        board.setBoard_index(ID);
        board.setName(NAME);
        board.setTitle(UPDATED_TITLE);
        board.setContents(CONTENTS);

        boardRepository.save(board);
    }

    @Test
    public void test03_findOne() {
        Board board = boardRepository.findOne(ID);

        assertEquals(board.getName(), NAME);
        assertEquals(board.getTitle(), UPDATED_TITLE);
        assertEquals(board.getContents(), CONTENTS);
    }

    @Test
    public void test04_search() {
        List<Board> boards = (List<Board>) boardRepository.findAll(BoardPredicate.search(null, SEARCH));

        assertEquals(boards.get(0).getName(), NAME);
        assertEquals(boards.get(0).getTitle(), UPDATED_TITLE);
        assertEquals(boards.get(0).getContents(), CONTENTS);
    }

    @Test
    public void test05_delete() {
        boardRepository.delete(ID);

        Board board = boardRepository.findOne(ID);
        assertNull(board);
    }

}