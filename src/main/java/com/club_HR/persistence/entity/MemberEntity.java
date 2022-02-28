package com.club_HR.persistence.entity;
import com.club_HR.business.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @ToString
@Table(name = "t_member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "member's first name cannot be empty.")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "member's last name cannot be empty.")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "member's email cannot be empty.")
    @Column(name = "member_email", nullable = false)
    private String email;

    @Column(name = "member_tel", nullable = false)
    private String tel;

    @Column(name = "city")
    private String city;

    @Column(name = "age")
    private int age;

    @Column(name = "level")
    private String level;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "promo", nullable = false)
    private String promo;

    @ManyToMany(mappedBy = "memberEntityList",fetch = FetchType.LAZY)
    private List<CellEntity> cellEntityList = new ArrayList<>() ;

}