package com.example.club_HR.presentation;

import com.example.club_HR.business.IMemberService;
import com.example.club_HR.business.dto.Adhesion;
import com.example.club_HR.business.dto.Cell;
import com.example.club_HR.business.dto.Member;
import com.example.club_HR.business.ICellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClubController {

    ICellService iCellService;
    IMemberService iMemberService;

    @Autowired
    public ClubController(ICellService iCellService, IMemberService iMemberService) {
        this.iCellService = iCellService;
        this.iMemberService = iMemberService;
    }

    // End point / api rest / web service / ... etc

//    @GetMapping(value = "/")
//    public String index(Model model) {
//        model.addAttribute("message","Hello world");
//        return "index";
//    }

    @RequestMapping("/invoice-home")
    public  String displayHome(){
        System.out.println("la methode est invoquée");
        return "index";
    }

    @RequestMapping(value = "/register-member", method = RequestMethod.POST)
    public ResponseEntity addMember(@RequestBody Member member) {

        Member memberFound = iMemberService.getMemberByEmail(member.getEmail());
        if (memberFound == null) {
            iMemberService.addMember(member);
            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
        } else
            return ResponseEntity.status(HttpStatus.FOUND).body("dsl");
    }

    @RequestMapping(value = "/add-cell", method = RequestMethod.POST)
    public void addCell(@RequestBody Cell cell) {
        iCellService.addCell(cell);
    }

//    @GetMapping("/delete-member-email/{email}")
    @RequestMapping(value = "/delete-member-email/{email}", method = RequestMethod.DELETE)
    public void deleteMemberByEmail(@PathVariable String email) {
        iMemberService.deleteMember(email);
    }

    //----------- validé-----------
    @GetMapping("/get-all-members")
    public List<Member> findAllMembers() {
        List<Member> userList = iMemberService.getAllMembers();
        return userList;
    }

    @PostMapping("/add-to-cell")
    public ResponseEntity addMemberToCell(@RequestBody Adhesion adhesion) {
        if (adhesion != null) {
            iCellService.addMemberToCell(adhesion.getEmail(), adhesion.getCellRef());
            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
        } else
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Member Added succ");
    }


    @RequestMapping(value = "/get-member-by-email/{email}", method = RequestMethod.GET)
    public Member getMemberByEmail(@PathVariable String email) {
        return iMemberService.getMemberByEmail(email);
    }

    //----------------------validé----------------------------------------
    @GetMapping("/get-all-cells")
    public List<Cell> getAllCells() {
        List<Cell> cellsList = iCellService.getAllCells();
        return cellsList;
    }

    //--------------------validé----------------------------------------------------
    @RequestMapping(value = "/get-cell-ref/{cellRef}", method = RequestMethod.GET)
    public Cell getCellByCellRef(@PathVariable String cellRef) {
        return iCellService.getCellByCellRef(cellRef);
    }


    @RequestMapping(value = "/delete-member-from-cell", method = RequestMethod.POST)
    public ResponseEntity deleteMemberFromCell(@RequestBody Member member, @RequestBody Cell cell) {
        Member memberFound = iMemberService.getMemberByEmail(member.getEmail());
        Cell cellFound = iCellService.getCellByCellRef(cell.getCellRef());
        if ((memberFound == null) & (cellFound == null)) {
            iCellService.deleteMemberFromCell(member.getEmail(), cell.getCellRef());
            return ResponseEntity.status(HttpStatus.ACCEPTED).body("member removed from cell successfully");
        } else
            return ResponseEntity.status(HttpStatus.FOUND).body("cell or member not found");
    }


}


