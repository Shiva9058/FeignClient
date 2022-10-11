package com.test.exception;

public class UserNotFound extends Exception {
	
	private static final long serialVersionUID = 1L;
		public String msg;
		public UserNotFound(String msg) {
			super(msg);
			this.msg = msg;
		}
		public String getMsg() {
			return msg;
		}
}
