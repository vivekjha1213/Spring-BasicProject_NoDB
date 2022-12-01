package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	List<Course> list;

	public CourseServiceImpl() {

		list = new ArrayList<>();
		list.add(new Course(145, "Java Core", "Java is Easy"));
		list.add(new Course(146, "Spring Core", "Spring is tough"));
		list.add(new Course(147, "Spring JDBC", "JDBC is Data base is toughest"));
		int size = list.size();
		System.out.println("The size of the list is" + size);

	}

	@Override
	public List<Course> getCourses() {

		return list;
	}

	@Override
	public Course getEachCourseName(long courseId) {

		Course obj = null;
		for (Course course : list) {

			if (course.getId() == courseId) {
				obj = course;
			}
		}
		return obj;

	}

	@Override
	public Course addCourse(Course course) {

		list.add(course);

		return course;
	}

	@Override
	public Course updateCourse(Course course) {

		System.out.println("The id is" + course.getId());
		System.out.println("the tittle is" + course.getTitle());
		System.out.println("The description is" + course.getDescription());

		list.forEach(e -> {

			if (e.getId() == course.getId()) {

				e.setTitle(course.getTitle());
				e.setDescription(course.getDescription());
			}
		});

		System.out.println(list);

		return course;
	}

}
