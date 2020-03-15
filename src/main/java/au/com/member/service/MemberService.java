package au.com.member.service;

import au.com.member.api.ResourceNotFoundException;
import au.com.member.model.Member;
import au.com.member.model.MemberTransaction;
import au.com.member.repository.MemberDAO;
import au.com.member.repository.MemberRepository;
import au.com.member.repository.MemberTransactionRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MemberService {

  private static final String FREQUENT_FLYER_PROGRAM = "FF";

  private MemberRepository memberRepository;

  private MemberTransactionRepository memberTransactionRepository;


  @Autowired
  public MemberService(
      final MemberRepository memberRepository,
      final MemberTransactionRepository memberTransactionRepository) {

    this.memberRepository = memberRepository;
    this.memberTransactionRepository = memberTransactionRepository;

  }

  public List<Member> getAllMembers() {
    List<Member> members = new ArrayList<>();
     memberRepository.findAll().forEach(foundMemberDAO->
         members.add(Member.builder()
             .memberId(foundMemberDAO.getMemberId())
             .firstName(foundMemberDAO.getFirstName())
             .lastName(foundMemberDAO.getLastName())
             .dateOfBirth(foundMemberDAO.getDateOfBirth())
             .dateOfJoining(foundMemberDAO.getDateOfJoining())
             .build()));
     return members;
  }
  public Optional<Member> getMember(final Long memberId) {

    log.info("Finding a member by id '{}'", memberId);

    final Optional<MemberDAO> optionalFoundMemberDAO = memberRepository.findById(memberId);

    if (!optionalFoundMemberDAO.isPresent()) {
      return Optional.empty();
    }

    log.info("Found a member by id '{}'", memberId);

    final MemberDAO foundMemberDAO = optionalFoundMemberDAO.get();

    return Optional.of(Member.builder()
        .memberId(foundMemberDAO.getMemberId())
        .firstName(foundMemberDAO.getFirstName())
        .lastName(foundMemberDAO.getLastName())
        .dateOfBirth(foundMemberDAO.getDateOfBirth())
        .dateOfJoining(foundMemberDAO.getDateOfJoining())
        .build());
  }

  public List<MemberTransaction> getMemberTransaction(Long memberId) {

    List<MemberTransaction> transactions = new ArrayList<>();

     memberTransactionRepository.findTransactionsByMemberId(memberId)
         .forEach(memberTransactionDAO ->
        transactions.add(MemberTransaction.builder()
            .description(memberTransactionDAO.getDescription())
            .type(memberTransactionDAO.getType())
            .amount(memberTransactionDAO.getAmount())
            .build()));
    if(transactions.isEmpty()){
      throw new ResourceNotFoundException("No transactions exists for memberId=" + memberId);
    }
    return transactions;

  }

  public Member checkMember(Long memberId) {
    final Optional<Member> foundMember = getMember(memberId);

    if (!foundMember.isPresent()) {
      throw new ResourceNotFoundException("No member exists with memberId=" + memberId);
    }

    return foundMember.get();

  }
}
