package net.jw;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@SuperBuilder(toBuilder=true)
@NoArgsConstructor
public class User {
    private Long userId;
    private String userLoginId;
    private String userNm;
    private String userPwd;
}
