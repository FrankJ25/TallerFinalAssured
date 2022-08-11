package basicJunit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicJunit {

    @BeforeEach
    public void before(){
        System.out.println("setup");
    }

    @AfterEach
    public void after(){
        System.out.println("cleanup");
    }


    @Test
    public void verifySomeThing(){

        System.out.println("este mi test");

    }

    @Test
    public void verifySomeThing1(){

        System.out.println("este mi test");

    }

}
