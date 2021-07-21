package entity;

public class user {
		private int users_id;
		private String user_name;
		private String email;
		
		
		public user(int users_id, String user_name, String email) {
			this.users_id = users_id;
			this.user_name = user_name;
			this.email = email;
		}
		
		public user(String user_name, String email) {
			super();
			this.user_name = user_name;
			this.email = email;
		}

		public int getUsers_id() {
			return users_id;
		}
		public void setUsers_id(int users_id) {
			this.users_id = users_id;
		}
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
}
