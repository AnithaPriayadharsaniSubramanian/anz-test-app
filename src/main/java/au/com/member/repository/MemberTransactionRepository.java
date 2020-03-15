package au.com.member.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface MemberTransactionRepository extends CrudRepository<MemberTransactionDAO, Long> {


  @Query("SELECT mp FROM MemberTransactionDAO mp WHERE mp.memberDAO.memberId = :memberId")
  List<MemberTransactionDAO> findTransactionsByMemberId(@Param("memberId") final Long memberId);



}
