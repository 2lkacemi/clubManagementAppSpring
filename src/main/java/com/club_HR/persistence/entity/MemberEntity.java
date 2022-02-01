package com.club_HR.persistence.entity;
import com.club_HR.business.enums.Gender;
import com.club_HR.business.enums.MemberType;
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

    @Column(name = "member_password", nullable = false)
    private String password;

    @Column(name = "member_tel", nullable = false)
    private String tel;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Column(name = "promo", nullable = false)
    private String promo;

    @Enumerated(EnumType.STRING)
    @Column(name = "member_type", nullable = false, columnDefinition = "varchar(20) default 'member'")
    private MemberType memberType;

    @ManyToMany
    @JoinTable(name = "cell_member",
            joinColumns = @JoinColumn(name = "member_id"),
            inverseJoinColumns = @JoinColumn(name = "cell_id")
    )
    private List<CellEntity> cellEntities = new ArrayList<>() ;




}



