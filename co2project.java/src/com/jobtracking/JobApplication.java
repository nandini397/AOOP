package com.jobtracking;

public class JobApplication implements Comparable<JobApplication>, Cloneable {
    private String applicantName;
    private int experienceYears;
    private String positionApplied;

    public JobApplication(String applicantName, int experienceYears, String positionApplied) {
        this.applicantName = applicantName;
        this.experienceYears = experienceYears;
        this.positionApplied = positionApplied;
    }

    public String getApplicantName() {
        return applicantName;
    } 
    public int getExperienceYears() {
        return experienceYears;
    }

    public String getPositionApplied1() {
        return positionApplied;
    }
    @Override
    public int compareTo(JobApplication other) {
        // Sort by experience years (ascending)
        return Integer.compare(this.experienceYears, other.experienceYears);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Applicant: " + applicantName + ", Experience: " + experienceYears + " years, Position: " + positionApplied;
    }

	public String getPositionApplied() {
		// TODO Auto-generated method stub
		return null;
	}
}
