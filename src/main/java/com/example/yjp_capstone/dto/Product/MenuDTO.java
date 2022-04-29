package com.example.yjp_capstone.dto.Product;

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
