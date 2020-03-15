package au.com.member.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import au.com.member.model.Member;
import au.com.member.service.MemberService;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MemberControllerTest {

  @InjectMocks
  private MemberController memberController;

  @Mock
  private MemberService memberService;

@Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    this.memberController = new MemberController(memberService);

  }

  @Test
  public void getMemberTestSuccess(){

    Member member = Member.builder().memberId(5400001L)
    .firstName("Fred")
    .lastName("Flintstone")
    .dateOfBirth(LocalDate.of(1985,8,12))
    .dateOfJoining(LocalDate.now())
           .build();
    when(memberService.checkMember(anyLong())).thenReturn(member);
    Member member1= memberController.getMember(5400001L);
    assertEquals(member,member1);

  }

  @Test
  public void getMemberTestFail(){

    Member member1=memberController.getMember(5400000L);
    assertNull(member1);
  }

}