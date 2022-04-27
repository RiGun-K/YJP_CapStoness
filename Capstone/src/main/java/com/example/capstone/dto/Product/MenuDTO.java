package com.example.capstone.dto.Product;

import com.example.capstone.domain.Member.Member;
import com.example.capstone.domain.Product.Kind;
import com.example.capstone.domain.Product.Menu;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class MenuDTO {

    private String menuname;
    private int price;
    private String ex;
    private LocalDateTime savedTime;
    private int stock;
    private String origFilename;
    private String filename;
    private String filePath;

    private int kindid;
    private String mid;

}
