package com.company.timesheet.project.pojo;

import java.util.ArrayList;
import java.util.List;

import com.company.timesheet.profile.person.pojo.PersonDetail;

public class ProjectSearchResult {

	List<ProjectDetail>	projectDetailList	= new ArrayList<ProjectDetail>();

	Long				numberOfProject;

	public List<ProjectDetail> getProjectDetailList() {
		return projectDetailList;
	}

	public void setProjectDetailList(List<ProjectDetail> projectDetailList) {
		this.projectDetailList = projectDetailList;
	}

	public Long getNumberOfProject() {
		return numberOfProject;
	}

	public void setNumberOfProject(Long numberOfProject) {
		this.numberOfProject = numberOfProject;
	}
	
	}
