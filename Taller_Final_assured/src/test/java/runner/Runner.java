package runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class Runner {
    @Before
    public void beforeScenario(){
        System.out.println("hook before");
    }
    @After
    public void afterScenario(){
        System.out.println("hook after");
    }




}
