package cn.singleton;

public enum SingletonEnum {
	
	INSTANCE{
		@Override
		public Singleton2 getInstance(){
			System.out.println("instance");
			return new Singleton2();
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
		public Singleton2 getInstance() {
			return null;
		}  
    },  
    GREEN{  
    	@Override
		public String sayHi() {
			return"I'm Green;";
		}

		@Override
		public Singleton2 getInstance() {
			return null;
		}  
    },  
    BLUE{  
    	@Override
		public String sayHi() {
			return "I'm Blue;";
		}

		@Override
		public Singleton2 getInstance() {
			return null;
		}   
    };  
	public abstract String sayHi();
	public abstract Singleton2 getInstance();
}

