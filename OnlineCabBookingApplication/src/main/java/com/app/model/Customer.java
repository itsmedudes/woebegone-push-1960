package com.app.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
public class Customer {

		@Embedded
		ModelUser user;

		@Id
		@SequenceGenerator(name="customer_generator", sequenceName = "customer_seq", allocationSize=50)
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
		private Integer customerId;

		public ModelUser getUser() {
			return user;
		}

		public void setUser(ModelUser user) {
			this.user = user;
		}

		public Integer getCustomerId() {
			return customerId;
		}

		public void setCustomerId(Integer customerId) {
			this.customerId = customerId;
		}

		public Customer(ModelUser user, Integer customerId) {
			super();
			this.user = user;
			this.customerId = customerId;
		}

		public Customer() {
			super();
		}
	
}
