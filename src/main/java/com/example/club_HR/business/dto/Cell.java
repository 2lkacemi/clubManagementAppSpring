package com.example.club_HR.business.dto;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private String cellRef;
    private String cellName;
    private String cellDescription;
    private List<Member> members = new ArrayList<>() ;

    public Cell() {
    }

    public String getCellRef() {
        return cellRef;
    }

    public void setCellRef(String cellRef) {
        this.cellRef = cellRef;
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

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
