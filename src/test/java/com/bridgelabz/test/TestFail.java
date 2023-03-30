package com.bridgelabz.test;

import com.bridgelabz.baseclass.BaseClass;
import com.bridgelabz.baseclass.ReporterListener;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ReporterListener.class)
public class TestFail extends BaseClass {

        @Test
        public void testPassed() {
            Assert.assertTrue(true);
        }

        @Test
        public void testFailed() {
            Assert.assertFalse(false);
        }

        @Test
        public void testDepend() {
            Assert.assertTrue(true);
        }
}
