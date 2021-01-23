public class AuthenticationToken {
	public static int authenToken(int[][] commands, int expTime) {
		int active = 0;
		Map<Integer, Integer> mapping = new HashMap<>();

		for (int[] command : commands) {
			int curT = command[2];
			if (command[0] == 0) {
				mapping.put(command[1], curT + expTime);
			} else if (command == 1) {
				if (mapping.containsKey(command[1]) 
					&& mapping.get(command[1]) >= curT) {
					mapping.put(command[1], curT + expTime);
				}
			}
		}

		// get the final time, and check which key is still valid.
		int finalT = commands[commands.length - 1][2];
		int ans = 0;
		for (int key : mapping.keySet()) {
			if (mapping.get(key) >= finalT) {
				ans++;
			}
		}

		return ans;
	}
}