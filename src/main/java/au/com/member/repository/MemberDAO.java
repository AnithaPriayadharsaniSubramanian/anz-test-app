package au.com.member.repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Member")
@SequenceGenerator(name="memberIdGenerator", initialValue=5400021, allocationSize=100)
public class MemberDAO implements Serializable {
  @Id
  @GeneratedValue(generator = "memberIdGenerator")
  @Column(name = "memberId", updatable = false, nullable = false)
  @NotNull
  private Long memberId;

  @NotNull
  @Column(name = "dateOfBirth", nullable = false)
  private LocalDate dateOfBirth;

  @NotNull
  @Column(name = "dateOfJoining", nullable = false)
  private LocalDate dateOfJoining;

  @NotNull
  @Column(name = "firstName", nullable = false)
  private String firstName;

  @NotNull
  @Column(name = "lastName", nullable = false)
  private String lastName;


  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "MEMBER_ID")
  private List<MemberTransactionDAO> comments = new ArrayList<>();



}
