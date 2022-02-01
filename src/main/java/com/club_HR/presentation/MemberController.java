//package com.club_HR.presentation;
//
//import com.club_HR.business.IMemberService;
//import com.club_HR.business.ICellService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//
//@Controller
//public class MemberController {
//
//    ICellService iCellService;
//    IMemberService iMemberService;
//
//    @Autowired
//    public MemberController(ICellService iCellService, IMemberService iMemberService) {
//        this.iCellService = iCellService;
//        this.iMemberService = iMemberService;
//    }
//
//
//    //Check for Credentials
////    @PostMapping("/submitLogin")
////    public String login(@ModelAttribute(name = "loginForm") MemberLoginForm memberLoginForm) {
////        String password = memberLoginForm.getPassword();
////        Member memberFound = iMemberService.getMemberByEmail(memberLoginForm.getEmail());
////        if (!(memberFound == null)) {
////            if (password.equals(memberFound.getPassword())) {
////                return "home";
////            }
////        } else
////            return "redirect:/loginForm";
////        return null;
////    }
//
////    @GetMapping("/registration")
////    public String registration( ) {
////        return "registration";
////    }
//
////    @PostMapping(value = "/registration")
////    public String registerMember(@ModelAttribute("memberForm") MemberDetailForm memberForm, Model model) {
////        iMemberService.addMember(formMapper.mapFromMemberFormToMember(memberForm));
////        model.addAttribute("message", "Member " + memberForm.getFirstName() + " registered successfully. Please login.");
////        return "login";
////    }
////
////    @GetMapping(value = "/registration")
////    public String registration(Model model) {
////        model.addAttribute("memberForm", new MemberDetailForm());
////        return "registration";
////    }
////
//
////
////    @GetMapping("/submitLogin")
////    public String submitLoginForm(@RequestBody MemberLoginForm memberLoginForm) {
//////        memberLoginForm.setEmail();
//////        memberLoginForm.setPassword();
////        Member memberFound = iMemberService.getMemberByEmail(memberLoginForm.getEmail());
////        if (memberFound == null) {
////            return "redirect:/loginForm";
////        } else if (Objects.equals(memberFound.getPassword(), memberLoginForm.getPassword())) {
////            return "/login";
////        }
////        return null;
////    }
//
////    @GetMapping(value = "/logout")
////    public String logoutPage (HttpServletRequest request, HttpServletResponse response){
////        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
////        if (auth != null){
////            persistentTokenBasedRememberMeServices.logout(request, response, auth);
////            SecurityContextHolder.getContext().setAuthentication(null);
////        }
////        return "redirect:/login?logout";
////    }
//
////    @PostMapping("/addMmeber")
////    public String addUser(Member member, BindingResult result, Model model) {
////
////    }
//
////
////    @RequestMapping(value = "/register-member", method = RequestMethod.POST)
////    public ResponseEntity addMember(@RequestBody RegistrationForm registrationForm) {
////
////        Member memberFound = iMemberService.getMemberByEmail(registrationForm.getEmail());
////        if (memberFound == null) {
////            Member member = new Member();
////            member.setFirstName(registrationForm.getFirstName());
////            member.setLastName(registrationForm.getLastName());
////            member.setEmail(registrationForm.getEmail());
////            member.setGender(registrationForm.getGender());
////            member.setPassword(registrationForm.getPassword());
////            member.setTel(registrationForm.getTel());
////            member.setPromo(registrationForm.getPromo());
////            iMemberService.addMember(member);
////            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
////        } else
////            return ResponseEntity.status(HttpStatus.FOUND).body("dsl");
////    }
////
////    @RequestMapping(value = "/add-cell", method = RequestMethod.POST)
////    public void addCell(@RequestBody Cell cell) {
////        iCellService.addCell(cell);
////    }
////
//////    @GetMapping("/delete-member-email/{email}")
////    @RequestMapping(value = "/delete-member-email/{email}", method = RequestMethod.DELETE)
////    public String deleteMemberByEmail(@PathVariable String email) {
////        iMemberService.deleteMember(email);
////        return "redirect:/list";
////    }
////

////
////    @PostMapping("/add-to-cell")
////    public ResponseEntity addMemberToCell(@RequestBody Adhesion adhesion) {
////        if (adhesion != null) {
////            iCellService.addMemberToCell(adhesion.getEmail(), adhesion.getCellRef());
////            return ResponseEntity.status(HttpStatus.CREATED).body("OK");
////        } else
////            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Member Added succ");
////    }
////
////

////
////    //----------------------validé----------------------------------------
////    @GetMapping("/get-all-cellDtos")
////    public List<Cell> getAllCells() {
////        List<Cell> cellsList = iCellService.getAllCells();
////        return cellsList;
////    }
////
////    //--------------------validé----------------------------------------------------
////    @RequestMapping(value = "/get-cell-ref/{cellRef}", method = RequestMethod.GET)
////    public Cell getCellByCellRef(@PathVariable String cellRef) {
////        return iCellService.getCellByCellRef(cellRef);
////    }
////
////
////    @RequestMapping(value = "/delete-member-from-cell", method = RequestMethod.POST)
////    public ResponseEntity deleteMemberFromCell(@RequestBody Member member, @RequestBody Cell cell) {
////        Member memberFound = iMemberService.getMemberByEmail(member.getEmail());
////        Cell cellFound = iCellService.getCellByCellRef(cell.getCellRef());
////        if ((memberFound == null) & (cellFound == null)) {
////            iCellService.deleteMemberFromCell(member.getEmail(), cell.getCellRef());
////            return ResponseEntity.status(HttpStatus.ACCEPTED).body("member removed from cell successfully");
////        } else
////            return ResponseEntity.status(HttpStatus.FOUND).body("cell or member not found");
////    }
////
//
//}
//
//
