package au.com.member.api;

import au.com.member.model.Member;
import au.com.member.model.MemberTransaction;
import au.com.member.service.MemberService;
import java.util.List;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

  private final MemberService memberService;


  @Autowired
  MemberController(final MemberService memberService) {
    this.memberService = memberService;
    }

  @GetMapping(value = "/{memberId}")
  public Member getMember(@NotNull @PathVariable final Long memberId) {
    final Member foundMember = memberService.checkMember(memberId);
    return foundMember;
  }

  @GetMapping(value = "/list")
  public List<Member> getMembers() {
   return memberService.getAllMembers();
  }


  @GetMapping(value = "/{memberId}/transactions")
  public List<MemberTransaction> getMemberTransaction(@PathVariable final Long memberId) {
    final Member foundMember = memberService.checkMember(memberId);
    final List<MemberTransaction> memberTransactionList=memberService.getMemberTransaction(memberId);
    return memberTransactionList;
  }

}
