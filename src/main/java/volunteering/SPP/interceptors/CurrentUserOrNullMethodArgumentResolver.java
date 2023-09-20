package volunteering.SPP.interceptors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import volunteering.SPP.Repository.UserRepository;
import volunteering.SPP.Services.UserService;
import volunteering.SPP.annotations.CurrentUser;

@Service
public class CurrentUserOrNullMethodArgumentResolver implements HandlerMethodArgumentResolver {
    /*@Autowired
    JwtService jwtService;*/

    @Autowired
    UserService userService;

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class);
    }

    /*@Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String authorization = webRequest.getHeader("Authorization");
        if (!StringUtils.hasLength(authorization) || !authorization.startsWith("Bearer ")) {
            return null;
        }
        return jwtService.extractUsername(authorization.substring(7));
    }*/

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        String id = webRequest.getHeader("ID");
        if (!StringUtils.hasLength(id) ) {
            throw new UsernameNotFoundException(" Header ID not found");
        }
        return userService.getById(Long.parseLong(id)) ;
    }
}