package com.jobtracking;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JobApplicationTracker {
	private List<JobApplication> applications;

    public JobApplicationTracker() {
        applications = new ArrayList<>();
    }

    public void addApplication(JobApplication application) {
        applications.add(application);
    }

    public void displayApplications() {
        Iterator<JobApplication> iterator = applications.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
    public void sortByExperience() {
        applications.sort(null); 
        System.out.println("Sorted by Experience:");
        displayApplications();
    }

    public void sortByName() {
        applications.sort(new NameComparator());
        System.out.println("Sorted by Name:");
        displayApplications();
    }
}
