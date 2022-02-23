package com.club_HR.persistence.entity;
import com.club_HR.business.enums.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data @NoArgsConstructor @ToString
@Table(name = "t_member")
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

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