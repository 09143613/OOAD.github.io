package BookStore;

import java.time.LocalDateTime;


public class LoanFactory {
	public static Loan creatLoan(Book book,Member member){
		Loan loan = new Loan();
		HasReachMaxSpecification hasReachMaxSpecification = new HasReachMaxSpecification();
		LoanOnlyOneSpecification loanOnlyOneSpecification = new LoanOnlyOneSpecification(book);		
		loan.setBook(book);
		loan.setMember(member);
		if(hasReachMaxSpecification.isSatisfied(member)){
			if(loanOnlyOneSpecification.isSatisfied(member)){
				book.setLoanTo(member);
				loan.setLoanDate(LocalDateTime.now());
				loan.setDateForReturn(loan.getLoanDate().plusDays(10));
				return loan;
			}else{
				System.out.println("Sorry,���Ѿ�����Ȿ�黹δ�黹�������ٴν���");
			}
		}else{
			System.out.println("Sorry,�����ֻ�ܽ��������鼮������");
		}		
		return null;		
	}

}
