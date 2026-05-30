package com.example.memberproject.controller;

import com.example.memberproject.dto.MemberForm;
import com.example.memberproject.dto.MemberUpdateForm;
import com.example.memberproject.entity.Member;
import com.example.memberproject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
@Slf4j
public class MemberController {
    private final MemberRepository memberRepository;

    // 회원 가입 페이지 요청
    @GetMapping("/new")
    public String newMember() {
        return "members/new";
    }

    // 회원 가입 처리
    @PostMapping("/create")
    public String createMember(MemberForm memberForm) {

        memberForm.logInfo();

        Member member = memberForm.toEntity();
        member.logInfo();

        Member saved = memberRepository.save(member);
        saved.logInfo();

        return "redirect:/members/" + saved.getId();
    }

    // 특정 회원 조회
    @GetMapping("/{id}")
    public String getMember(@PathVariable Long id, Model model) {

        Member member = memberRepository.findById(id).orElse(null);

        model.addAttribute("member", member);

        return "members/show";
    }

    // 전체 회원 목록 조회
    @GetMapping("")
    public String index(Model model) {

        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);

        return "members/index";
    }

    // 회원 수정 페이지 요청
    @GetMapping("/{id}/edit")
    public String editMember(@PathVariable Long id, Model model) {

        Member member = memberRepository.findById(id).orElse(null);

        model.addAttribute("member", member);

        return "members/edit";
    }

    // 회원 수정 처리
    @PostMapping("/update")
    public String updateMember(MemberUpdateForm memberUpdateForm) {

        Member target = memberRepository.findById(memberUpdateForm.getId()).orElse(null);

        if (target != null) {
            target.patch(memberUpdateForm);
            memberRepository.save(target);
            log.info("수정 완료: {}", target);
        } else {
            log.info("수정 실패: 대상 Entity가 없습니다. ID = {}", memberUpdateForm.getId());
        }

        return "redirect:/members/" + memberUpdateForm.getId();
    }

    // 회원 삭제 처리
    @GetMapping("/{id}/delete")
    public String deleteMember(@PathVariable Long id, RedirectAttributes rttr) {

        // 1. 삭제할 대상 회원을 조회한다.
        Member target = memberRepository.findById(id).orElse(null);

        // 2. 대상 회원이 존재하면 삭제한다.
        if (target != null) {
            memberRepository.delete(target);
            rttr.addFlashAttribute("msg", "삭제되었습니다.");
            log.info("삭제 완료: {}", target);
        } else {
            rttr.addFlashAttribute("msg", "삭제할 회원이 없습니다.");
            log.info("삭제 실패: 대상 Entity가 없습니다. ID = {}", id);
        }

        // 3. 삭제 후 회원 목록 페이지로 이동한다.
        return "redirect:/members";
    }
}
