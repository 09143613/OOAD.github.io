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

}
