package com.club_HR.presentation;


import com.club_HR.business.ICellService;
import com.club_HR.business.IMemberService;
import com.club_HR.business.dto.MemberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;

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

    @GetMapping(value={"/", ""})
    public String homeDash(Model model){
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
    public String addMember(){
        return "addMemberDashPage";
    }

    @GetMapping("/addCell")
    public String addCell(){
        return "addCellDashPage";
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

    @PostMapping("/")
    public ResponseEntity<MemberDto> create(@RequestBody MemberDto member) throws URISyntaxException {
        MemberDto createdMember = iMemberService.addMember(member);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{email}")
                .buildAndExpand(createdMember.getEmail())
                .toUri();

        return ResponseEntity.created(uri)
                .body(createdMember);
    }

    @PutMapping("/{email}")
    public ResponseEntity<MemberDto> update(@RequestBody MemberDto member, @PathVariable String email) {
        MemberDto updatedMember = iMemberService.updateMemberByEmail(email, member);
        if (updatedMember == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(updatedMember);
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Object> deleteStudent(@PathVariable String email) {
        iMemberService.removeMemberByEmail(email);
        return ResponseEntity.noContent().build();
    }
}
