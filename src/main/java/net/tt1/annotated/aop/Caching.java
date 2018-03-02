package net.tt1.annotated.aop;

import net.tt1.aop.CachingModule;
import net.tt1.model.Type;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class Caching {

    private static final Logger log = LoggerFactory.getLogger(CachingModule.class);
    private static final Map<String, Object> cache = new HashMap<>();

    @Around("execution(* net.net.service.SearchEngine.*(..))")
    public Object caching(ProceedingJoinPoint pjp) throws Throwable {
        Object result;
        Type documentType;

        log.debug("@@@(Caching) review if this call is cacheable..");

        if ("findByType".equals(pjp.getSignature().getName()) &&
                pjp.getArgs().length == 1 &&
                pjp.getArgs()[0] instanceof Type) {
            documentType = (Type)pjp.getArgs()[0];
            log.debug("@@@(Caching) Is cacheable!!");
            if (cache.containsKey(documentType.getName())) {
                log.debug("@@@(Caching) Found in Cache!");
                return cache.get(documentType.getName());
            }

            log.debug("@@@(Caching) Not Found! but is cacheble!");
            result = pjp.proceed();
            cache.put(documentType.getName(), result);
            return result;
        }

        return pjp.proceed();
    }

}
