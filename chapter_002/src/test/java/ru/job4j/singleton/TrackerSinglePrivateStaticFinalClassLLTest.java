package ru.job4j.singleton;

import org.junit.Test;
import ru.job4j.singleton.TrackerSinglePrivateStaticFinalClassLL;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSinglePrivateStaticFinalClassLLTest {

    @Test
    public void whenTrackerSinglePrivateStaticFinalClassLLThenOnlyOneObjectHas() {
        TrackerSinglePrivateStaticFinalClassLL tracker1 = TrackerSinglePrivateStaticFinalClassLL.getInstance();
        TrackerSinglePrivateStaticFinalClassLL tracker2 = TrackerSinglePrivateStaticFinalClassLL.getInstance();
        assertThat(tracker1, is(tracker2));
    }
}
