package au.com.member.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonPropertyOrder({
    "memberId",
    "firstName",
    "lastName",
    "dateOfBirth",
    "dateOfJoining"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member implements Serializable {

  @JsonCreator
  public Member(
      @JsonProperty("firstName") String firstName,
      @JsonProperty("lastName") String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }

  @JsonProperty(access = Access.READ_ONLY)
  private Long memberId;


  private String firstName;

  private String lastName;

  @JsonProperty(access = Access.READ_ONLY)
  private LocalDate dateOfBirth;

  @JsonProperty(access = Access.READ_ONLY)
  private LocalDate dateOfJoining;

  @JsonProperty(access = Access.READ_ONLY)
  private List<MemberTransaction> memberTransaction;

}
