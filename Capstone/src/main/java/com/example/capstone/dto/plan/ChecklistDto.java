package com.example.capstone.dto.plan;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

public class ChecklistDto {


    private Long teamCode;

    private String teamName;

    private char teamState;


    private String teamMaster;

    private List<ChecklistDto> checkList = new ArrayList<>();



}
