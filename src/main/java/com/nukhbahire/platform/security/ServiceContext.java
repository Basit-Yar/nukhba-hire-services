package com.nukhbahire.platform.security;

import com.nukhbahire.platform.dto.UserDetailsVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceContext {

    private String userId;
    //    private String host;
    private UserDetailsVO userDetailsVO;

    public static ServiceContext getInstance(HttpServletRequest request) {
        ServiceContext ctx = new ServiceContext();
        if (request == null) {
            throw new RuntimeException("HttpServletRequest cannot be null");
        } else {

            try {
                ctx.initialize(request);
                return ctx;
            } catch (Throwable var3) {
//                throw new BusinessException("Error in initializing the context : " + var3.getMessage());
                throw new RuntimeException("Error in initializing the context: " + var3.getMessage());
            }
        }
    }

    private void initialize(HttpServletRequest request) throws Throwable {
//        String host = request.getHeader("x-p-host");
//        Objects.requireNonNull(host, "host is required");
//        this.host = host;
        this.userId = (String) request.getAttribute("userId");

        String username = (String) request.getAttribute("username");
        String email = (String) request.getAttribute("email");

//        @SuppressWarnings("unchecked")
        Collection<? extends GrantedAuthority> roles =
                (Collection<? extends GrantedAuthority>) request.getAttribute("roles");

        UserDetailsVO userDetailsVO = new UserDetailsVO(userId, username, email, roles);
        this.userDetailsVO = userDetailsVO;

    }
}
