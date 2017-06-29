package Test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.srs.daomain.Course;
import com.srs.service.CourseService;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("../applicationContext.xml") 
@org.springframework.transaction.annotation.Transactional
public class CourseServiceTest {
	@Resource
	private CourseService courseService;
	@Test
	public void queryCourseTest() {
		
		System.out.println(courseService.queryCourse());
		
	}
/*	@Test
	public void addCourseTest(){
		Course course=new Course();
		course.setCredits(2.0);
		course.setName("数据结构");
		course.setNumber("0032");
		System.out.println(courseService.addCourse(course));
	}
	@Test public void deleteCourseTest(){
		System.out.println(courseService.deleteCourse("0001"));
	}*/
}
