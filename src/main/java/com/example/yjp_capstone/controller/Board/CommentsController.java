package com.example.yjp_capstone.controller.Board;

import com.example.yjp_capstone.domain.Board.Comments;
import com.example.yjp_capstone.domain.Board.Writer;
import com.example.yjp_capstone.repository.Board.CommentsRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@NoArgsConstructor
@RequestMapping("/api")
public class CommentsController {

    @Autowired
    private CommentsRepository commentsRepository;

    @GetMapping("/commentsList")
    public List<Comments> commentList() {
        List<Comments> commentList = commentsRepository.findAll();
        System.out.println(commentList);
        return commentList;
    }


}
