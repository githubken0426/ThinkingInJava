package th.part_19_ENUM.chapter_10_constants._01;


public class PostOffice {
	enum MailHandler {
		GENERAL_DELIVERY {
			boolean handler(Mail m) {
				switch (m.genericDelivery) {
				case YES:
					System.out.println("Using general delivery for " + m);
					return true;
				default:
					return false;
				}
			}
		},
		MACHINE_SCAN {
			boolean handler(Mail m) {
				switch (m.scannability) {
				case UNSCANNABLE:
					return false;
				default:
					switch (m.address) {
					case INCORRECT:
						return false;
					default:
						System.out.println("Delivering " + m + " automatically");
						return true;
					}
				}
			}
		};
		abstract boolean handler(Mail mail);
	}
	
	static void hanlder(Mail mail){
		for (MailHandler ele : MailHandler.values()) {
			if(ele.handler(mail))
				return;
			System.out.println(mail+" is a dead letter£¡");
		}
	}
	
	public static void main(String[] args) {
		for (Mail mail : Mail.generator(5)) {
			System.out.println(mail.details());
			hanlder(mail);
			System.out.println("*****");
		}
		
		/*Iterable<Mail> m=Mail.generator(5);
		Iterator<Mail> it=m.iterator();
		boolean result=it.hasNext();
		while(result){
			Mail mail=it.next();
			System.out.println(mail.details());
			hanlder(mail);
			result=it.hasNext();
			if(result)
				System.out.println("***");
		}*/
	}
}
