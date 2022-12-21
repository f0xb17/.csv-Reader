//
//  JUnitTests.java
//  Class to test FetchCSV Class.
//
//  Created by f0xb17 on 12/21/2022.
//  Copyright © 2022 f0xb17. All rights reserved.
//


package org.foxbit;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;
public final class JUnitTests {

    @Test
    public void testException() {
        assertDoesNotThrow(() -> FetchCSV.fetchContent("src/main/java/org/foxbit/test.csv"));
    }

    @Test
    public void testValues() {
        try {
            FetchCSV.fetchContent("src/main/java/org/foxbit/test.csv");

            assertEquals("test1", FetchCSV.getValue(1));
            assertEquals("test2", FetchCSV.getValue(2));
            assertEquals("test3", FetchCSV.getValue(3));
            assertNotEquals("test1", FetchCSV.getValue(0));
            assertNotEquals("test5", FetchCSV.getValue(4));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
