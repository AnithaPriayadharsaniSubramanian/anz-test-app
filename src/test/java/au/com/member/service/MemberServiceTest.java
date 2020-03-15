package au.com.member.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import au.com.member.model.Member;
import au.com.member.repository.MemberDAO;
import au.com.member.repository.MemberRepository;
import au.com.member.repository.MemberTransactionRepository;
import java.time.LocalDate;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MemberServiceTest {


  @InjectMocks
  private MemberService memberService;

  @Mock
  private MemberRepository memberRepository;
  @Mock
  private MemberTransactionRepository memberTransactionRepository;

@Before
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    this.memberService = new MemberService(memberRepository,memberTransactionRepository);

  }

  @Test
  public void getMemberTestSuccess(){

    Member member = Member.builder().memberId(5400001L)
    .firstName("Fred")
    .lastName("Flintstone")
    .dateOfBirth(LocalDate.of(1985,8,12))
    .dateOfJoining(LocalDate.now())
           .build();

    MemberDAO memberDAO = MemberDAO.builder().memberId(5400001L)
        .firstName("Fred")
        .lastName("Flintstone")
        .dateOfBirth(LocalDate.of(1985,8,12))
        .dateOfJoining(LocalDate.now())
        .build();
    when(memberRepository.findById(ArgumentMatchers.anyLong())).thenReturn(Optional.of(memberDAO));
   Optional<Member>  member1= memberService.getMember(5400001L);
    assertEquals(member.getMemberId(),member1.get().getMemberId());

  }


}