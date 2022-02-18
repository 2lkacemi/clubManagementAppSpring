package com.club_HR.presentation;


import com.club_HR.business.ICellService;
import com.club_HR.business.IMemberService;
import com.club_HR.business.dto.CellDto;
import com.club_HR.business.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

@RequestMapping("/dash")
public class ClubController {

    IMemberService iMemberService;
    ICellService iCellService;

    @Autowired
    public ClubController(IMemberService iMemberService, ICellService iCellService) {
        this.iMemberService = iMemberService;
        this.iCellService = iCellService;
    }

    @GetMapping(value = {""})
    public String homeDash(Model model) {
        model.addAttribute("members", iMemberService.getAllMembers());
        model.addAttribute("cells", iCellService.getAllCells());
        model.addAttribute("nbCells", iCellService.getAllCells().size());
        model.addAttribute("nbMembers", iMemberService.getAllMembers().size());
        return "homeDashPage";
    }

    @GetMapping("/allMembers")
    public String listAllMembers(Model model) {
        model.addAttribute("members", iMemberService.getAllMembers());
        return "allMembersDashPage";
    }

    @GetMapping("/allCells")
    public String listAllCells(Model model) {
        model.addAttribute("cells", iCellService.getAllCells());
        return "allCellsDashPage";
    }

    @GetMapping("/addMember")
    public String addMember() {
        return "addMemberDashPage";
    }

    @PostMapping("/addMember")
    public String addMember(@ModelAttribute(name = "member") MemberDto member) {
        iMemberService.addMember(member);
        return "redirect:allMembers";
    }

    @GetMapping("/addCell")
    public String addCell() {
        return "addCellDashPage";
    }

    @PostMapping("/addCell")
    public String addCell(@ModelAttribute(name = "cell") CellDto cell) {
        iCellService.addCell(cell);
        return "redirect:allCells";
    }

    @GetMapping("/profileMember")
    public String profileMember(String email, Model model) {
        MemberDto member = iMemberService.getMemberByEmail(email);
        model.addAttribute("member", member);
        return "profileMemberDashPage";
    }

    @GetMapping("/profileCell")
    public String profileCell(String cellRef, Model model) {
        CellDto cell = iCellService.getCellByCellRef(cellRef);
        List<MemberDto> listMembersInCell = cell.getMemberDtoList();
        List<MemberDto> listMembers =  iMemberService.getAllMembers();
        List<MemberDto> listMembersNotInCell = new ArrayList<>();

        model.addAttribute("listMembers",listMembers);
        model.addAttribute("cell", cell);
        model.addAttribute("nbAdherents", cell.getMemberDtoList().size());
        model.addAttribute("listMembersInCell", listMembersInCell);

        for (MemberDto member : listMembers) {
            if (!listMembersInCell.contains(member)){
                listMembersNotInCell.add(member);
            }
        }
        model.addAttribute("listMembersNotInCell", listMembersNotInCell);
        return "profileCellDashPage";
    }

    @GetMapping("/{email}")
    public ResponseEntity<MemberDto> getMemberByEmail(@PathVariable("email") String email) {
        MemberDto foundMember = iMemberService.getMemberByEmail(email);
        if (foundMember == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(foundMember);
        }
    }

    @RequestMapping("/deleteMember")
    public String deleteMember(String email) {
        iMemberService.removeMemberByEmail(email);
        return "redirect:allMembers";
    }

    @RequestMapping("/deleteCell")
    public String deleteCell(String cellRef) {
        iCellService.removeCellByCellRef(cellRef);
        return "redirect:allCells";
    }

    @RequestMapping("/updateMember")
    public String updateMember(String email, Model model) {
        MemberDto member = iMemberService.getMemberByEmail(email);
        model.addAttribute("member", member);
        return "updateMemberDashPage";
    }

    @PostMapping("/updateMember")
    public String updateCell(@ModelAttribute(name = "member") MemberDto member) {
        iMemberService.updateMember(member);
        return "redirect:allMembers";
    }

    @GetMapping("/updateCell")
    public String updateCell(String cellRef, Model model) {
        CellDto cell = iCellService.getCellByCellRef(cellRef);
        model.addAttribute("cell", cell);
        return "updateCellDashPage";
    }

    @PostMapping("/updateCell")
    public String updateCell(@ModelAttribute(name = "cell") CellDto cell) {
        iCellService.updateCell(cell);
        return "redirect:allCells";
    }

    @RequestMapping("/addMemberToCell")
    public String addMemberToCell(String email, String cellRef, Model model){
        iCellService.addMemberToCell(email, cellRef);
        model.addAttribute("cellRef", cellRef);
        return "redirect:profileCell?cellRef="+cellRef;
    }

    @RequestMapping("/removeMemberFromCell")
    public String removeMemberFromCell(String email, String cellRef, Model model){
        iCellService.removeMemberFromCell(email, cellRef);
        model.addAttribute("cellRef", cellRef);
        return "redirect:profileCell?cellRef="+cellRef;
    }
}