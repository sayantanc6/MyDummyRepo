package dummy.utilities;

import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.Calendar;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
public class LoggingAspect {
	 
    private final static Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Around("execution(*  dummy.*.*.*(..))")
	public void LoggingDetails(ProceedingJoinPoint pjp) throws Throwable { 
		
		logger.info(Calendar.getInstance().getTime()+" "+pjp.getKind()+" "+pjp.getSignature().getDeclaringTypeName());
		logger.info("===Parameters===");
		Object[] args = pjp.getArgs();
		Parameter[] parameters =  MethodSignature.class.cast(pjp.getSignature()).getMethod().getParameters();
		Class<?>[] parameterTypes =  MethodSignature.class.cast(pjp.getSignature()).getMethod().getParameterTypes();
		for(int i=0,j=0,k=0;i <= args.length && j<= parameters.length && k<= parameterTypes.length;i++,j++,k++) 
			logger.info(parameterTypes[k]+" "+parameters[j]+" "+args[i]); 
		logger.info("===Return Data===");
		Type returnType = ((MethodSignature) pjp.getSignature()).getMethod().getGenericReturnType();
		Object retval = pjp.proceed();
		logger.info("type = " + returnType);
		logger.info("Value = " + retval); 
		logger.info("Details = "+ retval.toString()); 
		
	}

}