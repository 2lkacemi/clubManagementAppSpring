package com.club_HR.business.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @ToString

public class CellDto {

    private String cellRef;
    private String cellName;
    private String cellDescription;
    private List<MemberDto> memberDtos = new ArrayList<>();


}