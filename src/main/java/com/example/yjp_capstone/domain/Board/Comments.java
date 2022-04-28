package com.example.yjp_capstone.domain.Board;


import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int writer_code;

    @Column()
    private String commenttext;
    @CreatedDate
    private LocalDateTime commentdate;

    public Comments(String commenttext, LocalDateTime commentdate){
        this.commenttext = commenttext;
        this.commentdate = commentdate;
    }

    public Comments() {

    }

    public int getWriter_code() {
        return writer_code;
    }

    public void setWriter_code(int writer_code) {
        this.writer_code = writer_code;
    }

    public String getCommenttext() {
        return commenttext;
    }

    public void setCommenttext(String commenttext) {
        this.commenttext = commenttext;
    }

    public LocalDateTime getCommentdate() {
        return commentdate;
    }

    public void setCommentdate(LocalDateTime commentdate) {
        this.commentdate = commentdate;
    }
}
