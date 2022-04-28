package com.example.yjp_capstone.repository.Board;

import com.example.yjp_capstone.domain.Board.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, String> {
}
