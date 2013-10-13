package name.tupitsky.filequeue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;


public class BasicOperationsTest {

    private final static DataObject SOME_OBJECT = new DataObject();
    private FileQueue<DataObject> queue;

    @Before
    public void setUp() {
        queue = new LockingFileQueue<DataObject>(new LinkedListFileQueue<DataObject>());
    }

    @After
    public void tearDown() {
        queue = null;
    }

    @Test
    public void shouldBeNotEmptyWhenContainingAtLeastOneElement() throws IOException {
        // given
        assertThat(queue.isEmpty(), is(true));

        // when
        queue.enqueue(SOME_OBJECT);

        // then
        assertThat(queue.isEmpty(), is(false));
    }

    @Test
    public void shouldBeEmptyWhenNoElementsLeftInQueue() throws IOException {
        // given
        queue.enqueue(SOME_OBJECT);

        // when
        queue.dequeue();

        // then
        assertThat(queue.isEmpty(), is(true));
    }

    @Test
    public void shouldActAsFIFO() throws IOException {
        // given
        DataObject elements[] = DataObject.createArrayOf(5);
        DataObject firstElementQueued = elements[0];

        for (DataObject element : elements) {
            queue.enqueue(element);
        }

        // when
        DataObject withdrawnElement = queue.dequeue();

        // then
        assertThat(withdrawnElement, is(equalTo(firstElementQueued)));
    }

    @Test
    public void shouldReturnTheSameElementOnPeekAsOnDequeue() throws IOException {
        // given
        queue.enqueue(SOME_OBJECT);

        // when
        DataObject elementOnTop = queue.peek();

        // then
        assertThat(elementOnTop, is(sameInstance(queue.dequeue())));
    }

    @Test
    public void shouldBeEmptyWhenPurged() throws IOException {
        // given
        DataObject elements[] = DataObject.createArrayOf(5);

        for (DataObject element : elements) {
            queue.enqueue(element);
        }

        // when
        queue.purge();

        // then
        assertThat(queue.isEmpty(), is(true));
    }

    @Ignore
    @Test
    public void shouldXXX() throws IOException {
        // given

        // when

        // then

    }

}
