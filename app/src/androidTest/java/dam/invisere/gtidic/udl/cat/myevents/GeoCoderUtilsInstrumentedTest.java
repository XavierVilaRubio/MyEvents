package dam.invisere.gtidic.udl.cat.myevents;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

@RunWith(AndroidJUnit4.class)
public class GeoCoderUtilsInstrumentedTest {

    private GeoCoderUtils geoCoderUtils;

    @Before
    public void setUp(){
        Context context = InstrumentationRegistry.getInstrumentation().getTargetContext();
        geoCoderUtils = new GeoCoderUtils(context);
    }

    @Test
    public void testSpainThatShouldPassWithIncorrectCoordinates() throws IOException {
        //Torre Eiffel
        String countryName = geoCoderUtils.getCountry(48.858296, 2.294479);
        assertNotEquals("Spain", countryName);
        assertEquals("France", countryName);
    }

    @Test
    public void testSpainThatShouldPassWithCorrectCoordinates() throws IOException {
        //Torre Eiffel
        String countryName = geoCoderUtils.getCountry(41.591635, 1.614240);
        assertEquals("Spain", countryName);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThatShouldThrowIllegalArgumentException() throws IOException {
        geoCoderUtils.getCountry(-100, -100);
    }

    @Test
    public void testThatShouldReturnNull() throws IOException {
        assertNull(geoCoderUtils.getCountryOrNull(0,0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatShouldThrowIndexOutOfBoundsException() throws IOException {
        geoCoderUtils.getCountry(0, 0);
    }

}
