package com.example.club_HR.persistence.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "t_cell")
public class CellEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "cell_ref")
    private String cellRef;
    @Column(name = "cell_name")
    private String cellName;
    @Column(name = "cell_description")
    private String cellDescription;
    //attributs d'association

    @ManyToMany(mappedBy = "cellEntities",cascade = CascadeType.MERGE)
    private List<MemberEntity> memberEntities = new ArrayList<>() ;

    public CellEntity() {
    }

    public String getCellRef() {
        return cellRef;
    }

    public void setCellRef(String cellRef) {
        this.cellRef = cellRef;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<MemberEntity> getMemberEntities() {
        return memberEntities;
    }

    public void setMemberEntities(List<MemberEntity> memberEntities) {
        this.memberEntities = memberEntities;
    }

    public CellEntity(String cellName, String cellDescription) {
        this.cellName = cellName;
        this.cellDescription = cellDescription;
    }


    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public String getCellDescription() {
        return cellDescription;
    }

    public void setCellDescription(String cellDescription) {
        this.cellDescription = cellDescription;
    }

    public List<MemberEntity> getMembers() {
        return memberEntities;
    }

    public void setMembers(List<MemberEntity> memberEntities) {
        this.memberEntities = memberEntities;
    }   

    @Override
    public String toString() {
        return "CellEntity{" +
                "cellName='" + cellName + '\'' +
                ", cellDescription='" + cellDescription + '\'' +
                '}';
    }
}
