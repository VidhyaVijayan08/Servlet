package com.chainsys.studentmodel;

public class Student {
		public String name;
		String mailId;
		String phoneNumber;
		//Getters and Setters
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name; 
		}
		public String getMailId() {
			return mailId;
		}
		public void setMailId(String mailId) {
			this.mailId = mailId;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public Student(){
			
		}
		
		public Student(String name, String mailId, String phoneNumber) {
			super();
			this.name = name;
			this.mailId = mailId;
			this.phoneNumber = phoneNumber;
		}
		//toString
		@Override
		public String toString() {
			return "Student [name=" + name + ", mailId=" + mailId + ", phoneNumber=" + phoneNumber + "]";
		}


}
