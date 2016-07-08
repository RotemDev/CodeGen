package codegen.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Here are the user features.
 * 
 * @author RotemDev
 *
 */
public class User {
	/**
	 * The usertable
	 */
	public String[][] users = new String[10][2];

	/**
	 * Set user in the usertable to USERNAME:name, PASSWORD:password
	 * 
	 * @param num
	 *            the row number to set
	 * @param name
	 *            the username
	 * @param pass
	 *            the password
	 */
	public void setUser(int num, String name, String pass) {
		users[num][0] = name;
		users[num][1] = pass;
		saveUsertable();
	}

	public User() {
		File check = new File("codegen.usertable");
		
		if (!(check.exists())) {
			saveUsertable();
		} else {
			loadUsertable();
		}
	}

	/**
	 * Get String[] user which is {name, pass}.
	 * 
	 * @param num
	 *            the row number in the usertable
	 * @return The user located in [num]
	 */
	public String[] getUser(int num) {
		String name = users[num][0];
		String pass = users[num][1];
		try {
			String[] user = {name, pass};
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Add user to the usertable.
	 * 
	 * @param name
	 *            the username
	 * @param pass
	 *            the password
	 */
	public void addUser(String name, String pass) {
		int num = (users.length) / 2 + 1;
		users[num][0] = name;
		users[num][1] = pass;
		saveUsertable();
	}

	/**
	 * Delete (set to null) user in users[num][*]
	 * 
	 * @param num
	 *            the row in the usertable
	 */
	public void delUser(int num) {
		users[num][0] = null;
		users[num][1] = null;
		saveUsertable();
	}

	/**
	 * Checks is the user uname exists
	 * 
	 * @param uname
	 *            the username to check
	 * @return <code>true</code> if the user exists, <code>false</code>
	 *         otherwise.
	 */
	public boolean exists(String uname) {
		for (int i = 0; 1 < (users.length) / 2; i++) {
			if (uname.equals(users[i][0])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Checks the index of the user (name)
	 * 
	 * @param name
	 *            the username
	 * @return the index if exists, <code>-1</code> otherwise.
	 */
	public int getUserIndex(String name) {
		if (exists(name)) {
			for (int i = 0; i < (users.length) / 2; i++) {
				if (name.equals(users[i][0]))
					return i;
			}
		} else {
			System.out.println("The user " + name + " does not exist!");
		}
		return -1;
	}

	/**
	 * Saves the usertable to a file.
	 * 
	 * @see codegen.java.User.loadUsertable()
	 */
	private void saveUsertable() {
		File f = new File("codegen.usertable");
		try {
			FileOutputStream fos = new FileOutputStream(f);
			ObjectOutputStream out = new ObjectOutputStream(fos);
			out.writeObject(users);
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the usertable to the program
	 * 
	 * @see codegen.java.User.saveUsertable()
	 */
	public void loadUsertable() {
		File f = new File("codegen.usertable");
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream in = new ObjectInputStream(fis);
			users = (String[][]) in.readObject();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
