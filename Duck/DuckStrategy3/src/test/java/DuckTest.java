import entity.MallardDuck;
import entity.RedHeadDuck;
import entity.RubberDuck;

public class DuckTest {
	public static void main(String[] args){
		RedHeadDuck redHeadDuck=new RedHeadDuck();
		RubberDuck rubberDuck=new RubberDuck();
		MallardDuck mallardDuck=new MallardDuck();
		System.out .println("红头鸭子说：");
		redHeadDuck.performFly();
		redHeadDuck.performQuack();
		System.out .println("橡皮鸭子说：");
		rubberDuck.performFly();
		rubberDuck.performQuack();
		System.out .println("野鸭子说：");
		mallardDuck.performFly();
		mallardDuck.performQuack();
	}

}
