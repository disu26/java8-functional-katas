package co.com.sofka.katas;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;


public class Kata8Test {

    @Test
    public void testExecute() {
        Assert.assertThat(Kata8.execute().size(), equalTo(3));
    }
}
