package com.sparta.jn.apitesting.pojo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class RatesPojoTest {
    private static RatesPojo ratesPojo;

    @BeforeAll
    static void initAll(TestInfo testInfo) {
        ObjectMapper mapper = new ObjectMapper();
        try {
             ratesPojo = mapper.readValue(new File("src/test/resources/rates.json")
                    , RatesPojo.class);
//            System.out.println(Arrays.toString(ratesPojo.getClass().getDeclaredFields()));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    @DisplayName("Test ratesPojo success field is mapped properly")
    void testRatesPojoSuccessFieldIsMappedProperly() {
        Assertions.assertTrue(ratesPojo.isSuccess());
    }

    @Test
    @DisplayName("Check timestamp is mapped correctly")
    void checkTimestampIsMappedCorrectly() {
        Assertions.assertEquals(ratesPojo.getTimestamp(),1539182646);
    }

    @Test
    @DisplayName("Check **success** field is of true")
    void checkSuccessFieldIsOfTrue() {
        Assertions.assertNotNull(ratesPojo.isSuccess());
        Assertions.assertTrue(ratesPojo.isSuccess());
    }

    @Test
    @DisplayName("Check **success** field is of false")
    void checkSuccessFieldIsOfFalse() {
        RatesPojo spyRatesPojo = Mockito.spy(ratesPojo);
        Mockito.doReturn(false).when(spyRatesPojo).isSuccess();
        Assertions.assertNotNull(spyRatesPojo.isSuccess());
        Assertions.assertFalse(spyRatesPojo.isSuccess());
    }

}
