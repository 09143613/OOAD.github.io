package BookStore;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		System.out.println("���ý���BOOK1�ɹ�");
		Member member = new Member("1","RXY");
		Book book1 = new Book("1","ISBN-001-001", "���������������");
		Loan loan1 = member.loan(book1);		
		member.Return(book1);

		//����ͬʱ����ͬһ����
		System.out.println("����BOOK2�ɹ�");
		Book book2 = new Book("2","ISBN-001-002", "�����ھ�����");
		Loan loan2 = member.loan(book2);		
		Book book3 = new Book("2","ISBN-001-002", "�����ھ�����");
		Loan loan3 = member.loan(book3);
		
		
		System.out.println("����BOOK3�ɹ�");
		Book book4 = new Book("3","ISBN-001-003", "javaEE");
		Loan loan4 = member.loan(book4);
		
	    	
		
	}

}
