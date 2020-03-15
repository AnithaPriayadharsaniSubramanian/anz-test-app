package au.com.member.repository;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Member_Transaction")
//@SequenceGenerator(name="transactionIdGenerator", initialValue=10, allocationSize=100)
public class MemberTransactionDAO implements Serializable {

  @Id
  @Column(name = "transactionId")
  private Long transactionId;

  @Column(name = "amount")
  private Long amount;

  @Column(name = "description")
  private String description;

  @Column(name = "type")
  private String type;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "MEMBER_ID", nullable = false)
  private MemberDAO memberDAO;



}
