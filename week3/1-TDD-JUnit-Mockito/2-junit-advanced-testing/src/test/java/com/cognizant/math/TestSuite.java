package com.cognizant.math;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses(MathUtilsTest.class)
public class TestSuite {
    // This class remains empty. It's used merely as a holder for the above annotations
    // to group and run multiple test classes together.
}
