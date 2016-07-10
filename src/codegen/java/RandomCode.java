package codegen.java;

import java.util.Random;

/**
 * {@link RandomCode} is a class which handles the random code generation.
 * 
 * @author RotemDev
 * @since CodeGen v1.0
 */
public class RandomCode {
	private int length = 0;
	private long seed = 0;
	private Random random = null;

	/**
	 * Start the {@link RandomCode} generator with stats:<br>
	 * <b>length</b> = 5,<br>
	 * <b>seed</b> = random {@link Integer} from <code>0</code> to
	 * <code>9</code><br>
	 * <b>The random generator</b> = seed (see seed)
	 * 
	 * @see codegen.java.RandomCode#RandomCode(int, long)
	 */
	public RandomCode() {
		this.length = 5;
		this.seed = new Random().nextInt(10);
		this.random = new Random(this.seed);
	}

	/**
	 * Start the {@link RandomCode} generator with stats:<br>
	 * <b>length</b> = length,<br>
	 * <b>seed</b> = seed<br>
	 * <b>The random generator</b> = seed (see seed)
	 * 
	 * @see codegen.java.RandomCode#RandomCode()
	 */
	public RandomCode(int length, long seed) {
		this.length = length;
		this.seed = seed;
		this.random = new Random(seed);
	}

	/**
	 * Generate the code
	 * 
	 * @return the code
	 */
	public String generateCode() {
		String code = "";
		char c = '\u0000';
		outer: for (int i = 0; i < length; i++) {
			int rand = random.nextInt(62);
			/*
			 * This switch is to "choose" what character to put. The random
			 * generates an integer, then the switch chooses a char according to
			 * the int. For example: 1] random selects int 16 2] switch figures
			 * out that 16 --> 'g' 3] 'g' gets added to the String "code".
			 */
			switch (rand) {
			case 0:
				c = '0';
				break;
			case 1:
				c = '1';
				break;
			case 2:
				c = '2';
				break;
			case 3:
				c = '3';
				break;
			case 4:
				c = '4';
				break;
			case 5:
				c = '5';
				break;
			case 6:
				c = '6';
				break;
			case 7:
				c = '7';
				break;
			case 8:
				c = '8';
				break;
			case 9:
				c = '9';
				break;
			case 10:
				c = 'a';
				break;
			case 11:
				c = 'b';
				break;
			case 12:
				c = 'c';
				break;
			case 13:
				c = 'd';
				break;
			case 14:
				c = 'e';
				break;
			case 15:
				c = 'f';
				break;
			case 16:
				c = 'g';
				break;
			case 17:
				c = 'h';
				break;
			case 18:
				c = 'i';
				break;
			case 19:
				c = 'j';
				break;
			case 20:
				c = 'k';
				break;
			case 21:
				c = 'l';
				break;
			case 22:
				c = 'm';
				break;
			case 23:
				c = 'n';
				break;
			case 24:
				c = 'o';
				break;
			case 25:
				c = 'p';
				break;
			case 26:
				c = 'q';
				break;
			case 27:
				c = 'r';
				break;
			case 28:
				c = 's';
				break;
			case 29:
				c = 't';
				break;
			case 30:
				c = 'u';
				break;
			case 31:
				c = 'v';
				break;
			case 32:
				c = 'w';
				break;
			case 33:
				c = 'x';
				break;
			case 34:
				c = 'y';
				break;
			case 35:
				c = 'z';
				break;
			case 36:
				c = 'A';
				break;
			case 37:
				c = 'B';
				break;
			case 38:
				c = 'C';
				break;
			case 39:
				c = 'D';
				break;
			case 40:
				c = 'E';
				break;
			case 41:
				c = 'F';
				break;
			case 42:
				c = 'G';
				// The meaning of life, the universe and everything
				break;
			case 43:
				c = 'H';
				break;
			case 44:
				c = 'I';
				break;
			case 45:
				c = 'J';
				break;
			case 46:
				c = 'K';
				break;
			case 47:
				c = 'L';
				break;
			case 48:
				c = 'M';
				break;
			case 49:
				c = 'N';
				break;
			case 50:
				c = 'O';
				break;
			case 51:
				c = 'P';
				break;
			case 52:
				c = 'Q';
				break;
			case 53:
				c = 'R';
				break;
			case 54:
				c = 'S';
				break;
			case 55:
				c = 'T';
				break;
			case 56:
				c = 'U';
				break;
			case 57:
				c = 'V';
				break;
			case 58:
				c = 'W';
				break;
			case 59:
				c = 'X';
				break;
			case 60:
				c = 'Y';
				break;
			case 61:
				c = 'Z';
				break;
			default:
				code = "There was an error in the random number generator.";
				break outer;
			}
			code += c;
		}
		return code;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @return the seed
	 */
	public long getSeed() {
		return seed;
	}

	/**
	 * @param seed
	 *            the seed to set
	 */
	public void setSeed(long seed) {
		this.seed = seed;
	}

	/**
	 * @return the randomiser
	 */
	public Random getRandom() {
		return random;
	}
}
