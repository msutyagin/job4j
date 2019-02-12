package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleEnumELTest {

    @Test
    public void whenTrackerSingleEnumThenOnlyOneObjectHas() {
        TrackerSingleEnumEL tracker1 = TrackerSingleEnumEL.INSTANCE;
        TrackerSingleEnumEL tracker2 = TrackerSingleEnumEL.INSTANCE;
        assertThat(tracker1, is(tracker2));
    }
}
