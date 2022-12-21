//
//  JUnitTests.java
//  Class to test FetchCSV Class.
//
//  Created by f0xb17 on 12/21/2022.
//  Copyright © 2022 f0xb17. All rights reserved.
//


package org.foxbit;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public final class JUnitTests {
    @Test
    public void testExceptions() {
        try {

            FetchCSV fetchCSV = new FetchCSV();
            assertDoesNotThrow(() -> fetchCSV.fetchContent());

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void testValues() {
        try {

            FetchCSV fetchCSV = new FetchCSV();
            assertEquals("test1", fetchCSV.getValue(1));
            assertEquals("test2", fetchCSV.getValue(2));
            assertEquals("test3", fetchCSV.getValue(3));
            assertNotEquals("test4", fetchCSV.getValue(5));

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
