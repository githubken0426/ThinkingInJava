package th.part_19_ENUM.chapter_10_constants._02;

import java.util.Iterator;

import TIJ4_code.net.mindview.util.TextFile;

import th.util.Generator;

public class VendingMachine {
	private static State state = State.RESTING;
	private static int amount = 0;
	private static Input selection = null;

	enum StateDuration {
		TRANSIENT;
	}

	/**
	 * 在switch语句的case中，只有无限制的枚举名称可以被使用.
	 * 
	 * @author ken 2017-5-4 上午09:17:47
	 */
	enum State {
		RESTING {
			void next(Input input) {
				switch (Catagory.catagorize(input)) {
				case MONEY:// Catagory.MONEY compile error
					amount += input.amount();
					state = ADDING_MONEY;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
				default:
				}
			}
		},
		ADDING_MONEY {
			void next(Input input) {
				switch (Catagory.catagorize(input)) {
				case MONEY:
					amount += input.amount();
					break;
				case ITEM_SECTION:
					selection = input;
					if (amount < selection.amount())
						System.out.println("Insuffictent money for "
								+ selection);
					else
						state = DISPENSING;
					break;
				case QUIT_TRANSACTION:
					state = GRVING_CHANGE;
					break;
				case SHUT_DOWN:
					state = TERMINAL;
				default:
				}
			}
		},
		DISPENSING(StateDuration.TRANSIENT) {
			void next() {
				System.out.println("here is your " + selection);
				amount -= selection.amount();
				state = GRVING_CHANGE;
			}
		},
		GRVING_CHANGE {
			void next(Input input) {
				if (amount > 0) {
					System.out.println("you change " + amount);
					amount = 0;
				}
				state = RESTING;
			}
		},
		TERMINAL {
			void output() {
				System.out.println("Halted");
			}
		};

		private boolean isTransient = false;

		State() {
		}

		State(StateDuration trans) {
			isTransient = true;
		}

		void next(Input input) {
			throw new RuntimeException(
					"Only Call next(Input input) for non-transient states");
		}

		void next() {
			throw new RuntimeException(
					"Only Call next() for StateDuration.TRANSIENT states");
		}

		void output() {
			System.out.println(amount);
		}
	}

	class RamndomInputGenerator implements Generator<Input> {
		@Override
		public Input next() {
			return Input.randomSection();
		}
	}

	class FileInputGenerator implements Generator<Input> {
		private Iterator<String> input;

		public FileInputGenerator(String fileName) {
			input = new TextFile(fileName, ";").iterator();
		}

		@Override
		public Input next() {
			if (!input.hasNext())
				return null;
			return Enum.valueOf(Input.class, input.next().trim());
		}
	}

	static void run(Generator<Input> gen) {
		while (state != State.TERMINAL) {
			state.next(gen.next());
			while (state.isTransient)
				state.next();
			state.output();
		}
	}

	public static void main(String[] args) {
		Generator<Input> gen = new VendingMachine().new RamndomInputGenerator();
		run(gen);
	}
}
