package dam.invisere.gtidic.udl.cat.myevents;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

import dam.invisere.gtidic.udl.cat.myevents.models.Event;
import dam.invisere.gtidic.udl.cat.myevents.models.EventStatus;

import static org.junit.Assert.*;

public class EventTest {

    private Event e;

    @Before
    public void setUp() throws Exception {
        this.e = new Event();
    }

    @Test
    public void getStatusNewEvent(){
        Calendar c = Calendar.getInstance();
        c.set(2022, 2, 5);
        this.e.setStartDate(c.getTime());
        this.e.setEndDate(c.getTime());
        assertEquals(EventStatus.NEW, e.getStatus());
    }

    @Test
    public void getStatusOngoingEvent(){
        this.e.setStartDate(new Date());
        assertEquals(EventStatus.ONGOING, e.getStatus());
    }

    @Test
    public void getStatusFinishedEvent(){
        Calendar c = Calendar.getInstance();
        c.set(2021, 2, 4);
        this.e.setEndDate(c.getTime());
        assertEquals(EventStatus.FINISHED, e.getStatus());
    }
}
