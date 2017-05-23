package cn.sort;

public enum SingletonEnum {
	
	INSTANCE{
		@Override
		public Singleton getInstance(){
			System.out.println("创建了单例模式！");
			return new Singleton();
		}

		@Override
		public String sayHi() {
			return "Hi";
		}
	},
	RED{  
		@Override
		public String sayHi() {
			return "I'm Red;";
		}

		@Override
		public Singleton getInstance() {
			return null;
		}  
    },  
    GREEN{  
    	@Override
		public String sayHi() {
			return"I'm Green;";
		}

		@Override
		public Singleton getInstance() {
			return null;
		}  
    },  
    BLUE{  
    	@Override
		public String sayHi() {
			return "I'm Blue;";
		}

		@Override
		public Singleton getInstance() {
			return null;
		}   
    };  
	public abstract String sayHi();
	public abstract Singleton getInstance();
}

