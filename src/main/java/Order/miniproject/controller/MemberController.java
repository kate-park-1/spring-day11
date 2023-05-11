package Order.miniproject.controller;

import Order.miniproject.Service.MemberService;
import Order.miniproject.domain.dto.LoginDto;
import Order.miniproject.domain.dto.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
  private final MemberService memberService;

  @GetMapping("/addMember")
  public String addMember(Model model){
    MemberDto member = new MemberDto();
    model.addAttribute("member", member);
    return "members/addMember";
  }

  @PostMapping("/addMember")
  public String addMembersProcess(@ModelAttribute("member") MemberDto memberDto){
    Long id = memberService.join(memberDto);
    System.out.println(memberDto);
    return "redirect:/members/login";
  }

  @GetMapping("/login")
  public String login(Model model){
    LoginDto login = new LoginDto();
    model.addAttribute("login", login);
    return "members/login";
  }

  @PostMapping("/login")
  public String loginProcess(@ModelAttribute("login") LoginDto loginDto){
    //memberService.
    System.out.println(loginDto);
    return "redirect:/home";
  }
}
