package Order.miniproject.domain.dto;

import Order.miniproject.domain.Address;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDto {
  Long id;
  String name;
  Address address;
}
