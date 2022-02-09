package com.club_HR.presentation;


import com.club_HR.business.ICellService;
import com.club_HR.business.IMemberService;
import com.club_HR.business.dto.CellDto;
import com.club_HR.business.dto.MemberDto;
import com.club_HR.business.enums.MemberType;
import com.club_HR.presentation.dto.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

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

    @GetMapping(value = {"/", ""})
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
    public String addMember(Model model) {
//        model.addAttribute("member", MemberType.member);
//        model.addAttribute("admin", MemberType.admin);
//        model.addAttribute("superAdmin", MemberType.superAdmin);
//        model.addAttribute("memberType", MemberType.values());
        return "addMemberDashPage";
    }

    @GetMapping("/addCell")
    public String addCell() {
        return "addCellDashPage";
    }

    @GetMapping("/profile")
    public String profileMember() {
        return "memberProfile";
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

    @PostMapping("/addMember")
    public String addMember(@ModelAttribute(name = "member") MemberDto member) {
        iMemberService.addMember(member);
        return "redirect:allMembers";
    }

    @PostMapping("/addCell")
    public String addCell(@ModelAttribute(name = "cell") CellDto cell) {
        iCellService.addCell(cell);
        return "redirect:allCells";
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




//    @PutMapping("/{email}")
//    public ResponseEntity<MemberDto> update(@RequestBody MemberDto member, @PathVariable String email) {
//        MemberDto updatedMember = iMemberService.updateMemberByEmail(email, member);
//        if (updatedMember == null) {
//            return ResponseEntity.notFound().build();
//        } else {
//            return ResponseEntity.ok(updatedMember);
//        }
//    }


//    @GetMapping("/delete/{cellRef}")
//    public String deleteCell(@PathVariable String cellRef) {
//        iCellService.removeCellByCellRef(cellRef);
//        return "redirect:allCells";
//    }

}