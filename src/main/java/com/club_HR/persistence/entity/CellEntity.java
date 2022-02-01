package com.club_HR.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data @NoArgsConstructor @ToString
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

}
