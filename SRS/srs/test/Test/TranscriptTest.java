package Test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.srs.service.TranscriptService;
@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("../applicationContext.xml") 
@org.springframework.transaction.annotation.Transactional
public class TranscriptTest {
	@Autowired
	private TranscriptService transcriptService;
	@Test
	public void queryTranscriptTest() {
		System.out.println(transcriptService.queryTranscript("09143613"));;
	}

}
