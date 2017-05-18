package entity;

public class RubberDuck extends Duck {
	public RubberDuck(){
		flyBehavior=new FlyNoWay();
		quackBehavior=new Squeak();
	}

	@Override
	void display() {
		System.out.println("我是一只橡皮鸭！！！");

	}

}
