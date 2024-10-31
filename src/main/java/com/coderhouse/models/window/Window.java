package com.coderhouse.models.window;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "windows_details")
public class Window {

	//Attributes
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long id;

		public Window() {
			super();
			// TODO Auto-generated constructor stub
		}

		public long getId() {
			return id;
		}

		@Override
		public String toString() {
			return "Window [id=" + id + "]";
		}
		
		
}
