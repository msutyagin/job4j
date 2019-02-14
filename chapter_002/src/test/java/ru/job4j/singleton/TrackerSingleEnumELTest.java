package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.singleton.TrackerSingleEnumEL;

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
