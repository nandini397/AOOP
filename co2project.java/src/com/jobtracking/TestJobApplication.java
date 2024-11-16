package com.jobtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;

public class TestJobApplication {

    @Test
    void testClone() throws CloneNotSupportedException {
        JobApplication original = new JobApplication("Alice", 5, "Software Engineer");
        JobApplication cloned = (JobApplication) original.clone();
        
        assertEquals(original.getApplicantName(), cloned.getApplicantName());
        Assert.assertEquals(original.getExperienceYears(), cloned.getExperienceYears());
        assertEquals(original.getPositionApplied(), cloned.getPositionApplied());
        
        assertNotSame(original, cloned); // Ensure they are different objects
    }
    private void assertEquals(String string, String string2) {
		// TODO Auto-generated method stub
		
	}
	@Test
    void testComparable() {
        JobApplication app1 = new JobApplication("Alice", 5, "Software Engineer");
        JobApplication app2 = new JobApplication("Bob", 3, "Data Analyst");
        
        assertTrue(app1.compareTo(app2) > 0); // app1 has more experience than app2
        assertTrue(app2.compareTo(app1) < 0); // app2 has less experience than app1
        assertTrue(app1.compareTo(app1) == 0); // same object comparison should be equal
    }
}

