package yash.example.WatherAPI.ServiceTests;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.internal.matchers.Equals;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
public class weatherServiceTests {


    @Disabled
    @Test
    public void add(){

        Assertions.assertEquals(4,2+2);
    }


    @ParameterizedTest
    @CsvSource({
            "5,5,10",
            "10,10,20",
            "1,3,4"
    })
    public void tests(int a,int b,int ans){

        Assertions.assertEquals(ans,a+b);

    }


}
