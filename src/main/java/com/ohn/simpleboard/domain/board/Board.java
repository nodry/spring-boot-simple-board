package com.ohn.simpleboard.domain.board;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.AUTO;

@Data
@Entity
@Table(name = "board")
public class Board implements Serializable {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "board_index", insertable = false)
    private Long board_index;

    @Column(name = "title", length = 100)
    private String title;

    @Column(name = "contents", length = 1000)
    private String contents;

    @Column(name = "name", length = 10)
    private String name;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date date;

    @PrePersist
    protected void onCreate() {
        date = new Date();
    }

}