import entity.MallardDuck;
import entity.RedHeadDuck;
import entity.RubberDuck;

public class DuckTest {
	public static void main(String[] args){
		RedHeadDuck redHeadDuck=new RedHeadDuck();
		RubberDuck rubberDuck=new RubberDuck();
		MallardDuck mallardDuck=new MallardDuck();
		System.out .println("��ͷѼ��˵��");
		redHeadDuck.performFly();
		redHeadDuck.performQuack();
		System.out .println("��ƤѼ��˵��");
		rubberDuck.performFly();
		rubberDuck.performQuack();
		System.out .println("ҰѼ��˵��");
		mallardDuck.performFly();
		mallardDuck.performQuack();
	}

}
