package com.mz.b2b.webchatclone.config.security;

import com.mz.b2b.webchatclone.app.member.service.MemberService;
import com.mz.b2b.webchatclone.model.member.Member;
import com.mz.b2b.webchatclone.model.member.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/system")
public class SecurityController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/login")
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "exception", required = false) String exception, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "/system/login";
    }

    @GetMapping("/join")
    public String memberJoin(Member member) {
        return "/system/join";
    }

    @GetMapping("/find")
    public String memberFind() {
        return "/system/find";
    }


    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "/system/accessDenied";
    }

    @PostMapping("/joinProc")
    public String memberJoinProc(Member member) {

        for (Member member_db : memberService.listMember()) {
            if (member_db.getMemberId().equals(member.getMemberId())) {
                return "/system/joinFail";
            }
        }

        member.setRole(Role.ROLE_USER);

        memberService.insertMember(member);

        return "redirect:/system/login";
    }


}