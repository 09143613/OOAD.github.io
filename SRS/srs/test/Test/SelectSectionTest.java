package Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.srs.service.SectionService;
import com.srs.service.SelectSectionService;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("../applicationContext.xml") 
@org.springframework.transaction.annotation.Transactional
public class SelectSectionTest {
	@Autowired
	private SelectSectionService selectSectionService;
	@Autowired
	private SectionService sectionService;
	@Test
	public void querySectionTest() {
		System.out.println(sectionService.querySection());
	}
	@Test
	public void selectSectionTest() {
		System.out.println(selectSectionService.selectSection("09143605",4));
	}
	@Test
	public void queryEnrolledStudentsTest() {
		System.out.println(selectSectionService.queryEnrolledStudents(4));
	}
}
