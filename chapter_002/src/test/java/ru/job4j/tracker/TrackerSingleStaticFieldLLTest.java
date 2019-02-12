package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class TrackerSingleStaticFieldLLTest {

    @Test
    public void whenTrackerSingleStaticFieldLLThenOnlyOneObjectHas() {
        TrackerSingleStaticFieldLL tracker1 = TrackerSingleStaticFieldLL.getInstance();
        TrackerSingleStaticFieldLL tracker2 = TrackerSingleStaticFieldLL.getInstance();
        assertThat(tracker1, is(tracker2));
    }
}
