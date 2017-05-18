package entity;

public class RedHeadDuck extends Duck {
	public RedHeadDuck(){
		flyBehavior=new FlyWithWings();
		quackBehavior=new Quack();
	}

	@Override
	void display() {
		System.out .println("我是纯种的红头鸭子！！");
		
	}

}
