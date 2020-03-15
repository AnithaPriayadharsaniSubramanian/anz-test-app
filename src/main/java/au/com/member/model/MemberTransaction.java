package au.com.member.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({
    "description",
    "type",
    "amount"
})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MemberTransaction implements Serializable {

  @NotNull
  private Long memberId;

  @NotBlank
  private String description;

  private String type;

  private Long amount;




}
