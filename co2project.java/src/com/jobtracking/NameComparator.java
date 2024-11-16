package com.jobtracking;

import java.util.Comparator; 

public class NameComparator implements Comparator<JobApplication> {
    @Override
    public int compare(JobApplication app1, JobApplication app2) {
        return app1.getApplicantName().compareTo(app2.getApplicantName());
    }
}
