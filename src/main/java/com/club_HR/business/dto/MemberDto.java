package com.club_HR.business.dto;

import com.club_HR.business.enums.Gender;
import com.club_HR.business.enums.MemberType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data @NoArgsConstructor @ToString
public class MemberDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String tel;
    private Gender gender;
    private String promo;
    private MemberType memberType;
    private List<CellDto> cellDtoList = new ArrayList<>();

}
