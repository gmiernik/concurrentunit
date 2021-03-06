package org.jodah.concurrentunit.junit;

import org.jodah.concurrentunit.AbstractConcurrentTestCase;
import org.junit.Assert;


/**
 * Concurrent JUnit test case.
 * 
 * <p>
 * Call {@link #sleep(long)}, {@link #sleep(long, int)}, {@link #threadWait(long)} or
 * {@link #threadWait(long, int)} from the main unit test thread to wait for some other thread to
 * perform assertions. These operations will block until {@link #resume()} is called, the operation
 * times out, or a threadAssert call fails.
 * 
 * <p>
 * The threadAssert methods can be used from any thread to perform concurrent assertions. Assertion
 * failures will result in the main thread being interrupted and the failure thrown.
 * 
 * <p>
 * Usage:
 * 
 * <pre>
 * @Test
 * public void assertAndResume() throws Throwable {
 *   new Thread(new Runnable() {
 *     public void run() {
 *       threadAssertTrue(true);
 *       resume();
 *     }
 *   }).start();
 *   
 *   sleep(500);
 * }
 * </pre>
 * 
 * @author Jonathan Halterman
 */
public abstract class ConcurrentTestCase extends AbstractConcurrentTestCase {
  @Override
  protected void assertEquals(Object actual, Object expected) {
    Assert.assertEquals(expected, actual);
  }

  @Override
  protected void assertFalse(boolean condition) {
    Assert.assertFalse(condition);
  }

  @Override
  protected void assertNotNull(Object o) {
    Assert.assertNotNull(o);
  }

  @Override
  protected void assertNull(Object o) {
    Assert.assertNull(o);
  }

  @Override
  protected void assertTrue(boolean condition) {
    Assert.assertTrue(condition);
  }

  @Override
  protected void fail(String message) {
    Assert.fail(message);
  }
}
