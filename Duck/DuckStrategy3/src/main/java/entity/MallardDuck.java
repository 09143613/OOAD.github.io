package entity;

public class MallardDuck extends Duck {
	public MallardDuck(){
		flyBehavior=new FlyWithWings();
		quackBehavior=new Quack();
	}

	@Override
	void display() {
		System.out.println("我是一只没人爱的野鸭子！！！");

	}

}
