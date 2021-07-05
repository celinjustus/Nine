package com.nine.test.runAJar;

import org.testng.TestNG;
import org.testng.collections.Lists;
import java.io.IOException;
import java.util.List;

public class mainClassToRunJar {
static TestNG testNg;
    public static void main(String args[]) throws IOException {
        testNg=new TestNG();
        List<String> suites = Lists.newArrayList();
        suites.add(".//testng.xml");
        testNg.setTestSuites(suites);
        testNg.run();

    }
}
