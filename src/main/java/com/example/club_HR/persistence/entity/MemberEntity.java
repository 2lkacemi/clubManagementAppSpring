package com.example.club_HR.persistence.entity;
import com.example.club_HR.business.enums.Gender;
import com.example.club_HR.business.enums.MemberType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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


    public MemberEntity() {
    }

    public MemberEntity(String firstName, String lastName, String email, String password, String tel, Gender gender, String promo, MemberType memberType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.tel = tel;
        this.gender = gender;
        this.promo = promo;
        this.memberType = memberType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public MemberType getMemberType() {
        return memberType;
    }

    public void setMemberType(MemberType memberType) {
        this.memberType = memberType;
    }

    public List<CellEntity> getCells() {
        return cellEntities;
    }

    public void setCells(List<CellEntity> cellEntities) {
        this.cellEntities = cellEntities;
    }

    @Override
    public String toString() {
        return "MemberEntity{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", gender=" + gender +
                ", promo='" + promo + '\'' +
                ", memberType=" + memberType +
                '}';
    }
}



