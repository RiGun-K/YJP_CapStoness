package com.example.capstone.repository.Board;

import com.example.capstone.domain.Board.Writer;
import com.example.capstone.domain.Member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Writer, Integer> {
}

