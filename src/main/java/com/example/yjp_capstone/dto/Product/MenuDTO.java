package com.example.yjp_capstone.dto.Product;

import com.example.yjp_capstone.domain.Member.Member;
import com.example.yjp_capstone.domain.Product.Kind;
import com.example.yjp_capstone.domain.Product.Menu;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
public class MenuDTO {

    private int menuid;
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
