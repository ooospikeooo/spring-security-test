package net.jw;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Principal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SessionInfo {

    private String sessionId;
    private Principal principal;
    private Date lastRequest;
    private boolean expired;

    private Date sessionCreationTime;
    private Date sessionLastAccessedTime;
}
