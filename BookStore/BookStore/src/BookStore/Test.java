package BookStore;

import static org.junit.Assert.*;

public class Test {

	@org.junit.Test
	public void test() {
		System.out.println("您好借书BOOK1成功");
		Member member = new Member("1","RXY");
		Book book1 = new Book("1","ISBN-001-001", "面向对象分析与设计");
		Loan loan1 = member.loan(book1);		
		member.Return(book1);

		//不能同时借阅同一本书
		System.out.println("借书BOOK2成功");
		Book book2 = new Book("2","ISBN-001-002", "数据挖掘理论");
		Loan loan2 = member.loan(book2);		
		Book book3 = new Book("2","ISBN-001-002", "数据挖掘理论");
		Loan loan3 = member.loan(book3);
		
		
		System.out.println("借书BOOK3成功");
		Book book4 = new Book("3","ISBN-001-003", "javaEE");
		Loan loan4 = member.loan(book4);
		
	    	
		
	}

}
