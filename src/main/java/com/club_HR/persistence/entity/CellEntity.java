package com.club_HR.persistence.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @NotEmpty(message = "cell's name cannot be empty.")
    @Size(min = 5, max = 20)
    @Column(name = "cell_name")
    private String cellName;

    @NotEmpty(message = "cell's description cannot be empty.")
    @Column(name = "cell_description")
    private String cellDescription;

    //attributs d'association

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.REMOVE, CascadeType.PERSIST })
    @JoinTable(name = "cell_member",
            joinColumns = @JoinColumn(name = "cell_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<MemberEntity> memberEntityList = new ArrayList<>() ;

}
