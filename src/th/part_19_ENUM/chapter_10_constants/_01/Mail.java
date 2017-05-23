package th.part_19_ENUM.chapter_10_constants._01;

import java.util.Iterator;

import TIJ4_code.net.mindview.util.Enums;

public class Mail {
	enum GenericDelivery {
		YES, NO1, NO2, NO3, NO4, NO5
	}

	enum Scannability {
		UNSCANNABLE, YES1, YES2, YES3, YES4
	}
	enum Address {
		INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6
	}
	
	GenericDelivery genericDelivery;
	Scannability scannability;
	Address address;
	static long counter = 0;
	long id = counter++;

	public String toString() {
		return "mail" + id;
	}

	public String details() {
		return toString() + ",General Delivery " + genericDelivery
				+ ",Scannability " + scannability + ",Address " + address;
	}

	public static Mail randomMail() {
		Mail mail = new Mail();
		mail.genericDelivery = Enums.random(GenericDelivery.class);
		mail.scannability = Enums.random(Scannability.class);
		mail.address = Enums.random(Address.class);
		return mail;
	}

	public static Iterable<Mail> generator(final int count) {
		return new Iterable<Mail>() {
			int n = count;

			@Override
			public Iterator<Mail> iterator() {
				return new Iterator<Mail>() {
					@Override
					public boolean hasNext() {
						return n-->0;
					}
					@Override
					public Mail next() {
						return randomMail();
					}
					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}
		};
	}
}
