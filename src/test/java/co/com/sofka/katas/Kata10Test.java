package co.com.sofka.katas;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata10Test {

    @Test
    public void testExecute() {
        Assert.assertThat(Kata10.execute().size(), equalTo(2));
    }
}
