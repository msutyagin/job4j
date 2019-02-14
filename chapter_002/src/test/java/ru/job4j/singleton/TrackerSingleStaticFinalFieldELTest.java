package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.singleton.TrackerSingleStaticFieldLL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingleStaticFinalFieldELTest {

    @Test
    public void whenTrackerSingleStaticFinalFieldELThenOnlyOneObjectHas() {
        TrackerSingleStaticFieldLL tracker1 = TrackerSingleStaticFieldLL.getInstance();
        TrackerSingleStaticFieldLL tracker2 = TrackerSingleStaticFieldLL.getInstance();
        assertThat(tracker1, is(tracker2));
    }
}
