package Test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.srs.daomain.Professor;
import com.srs.service.ProfessorService;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("../applicationContext.xml") 
@org.springframework.transaction.annotation.Transactional
public class ProfessorServiceTest {
	@Autowired
	private ProfessorService prfessorService;
	@Test
	public void addProfessorTest() {
		Professor professor=new Professor();
		professor.setDepartment("信电学院");
		professor.setName("张三");
		professor.setSsn("5446");
		professor.setTitle("教授");
		System.out.println(prfessorService.addProfessor(professor));
	}
	@Test
	public void deleteProfessorTest(){
		System.out.println(prfessorService.deleteProfessor("318212"));
	}
	@Test
	public void updateProfessor(){
		Professor professor=new Professor();
		professor.setDepartment("信电学院");
		professor.setName("张三");
		professor.setSsn("318212");
		professor.setTitle("教授");
		System.out.println(prfessorService.updateProfessor(professor));
	}
}
