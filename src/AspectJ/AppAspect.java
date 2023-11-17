package AspectJ;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class AppAspect {

    /* Read as -- do this *before* any *call* to the function
     * *java.io.PrintStream.println* that takes a *String*
     * and returns *void*
     */
    @Before("call(void java.io.PrintStream.println(String))")
    public void beforePrintCall() {
        System.out.println("AspectJ - Before making print call");
    }

    @After("call(void java.io.PrintStream.println(String))")
    public void afterPrintCall() {
        System.out.println("AspectJ - After making print call");
    }

}