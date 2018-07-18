package cn.edu.lingnan.dto;

public class TicketDTO {
		private String ticketID;
		private String offtime;
		private String falltime;
		private String address;
		private String price;
		private String surplus;
		public String getSurplus() {
			return surplus;
		}
		public void setSurplus(String surplus) {
			this.surplus = surplus;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		private String state;
		public String getTicketID() {
			return ticketID;
		}
		public void setTicketID(String ticketID) {
			this.ticketID = ticketID;
		}
		public String getOfftime() {
			return offtime;
		}
		public void setOfftime(String offtime) {
			this.offtime = offtime;
		}
		public String getFalltime() {
			return falltime;
		}
		public void setFalltime(String falltime) {
			this.falltime = falltime;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
}
