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
				System.out.println("Sorry,您已经借过这本书还未归还，不能再次借阅");
			}
		}else{
			System.out.println("Sorry,您最多只能借阅三本书籍！！！");
		}		
		return null;		
	}

}
