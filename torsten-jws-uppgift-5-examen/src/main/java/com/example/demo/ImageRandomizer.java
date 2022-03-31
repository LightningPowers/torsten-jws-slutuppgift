package com.example.demo;

public class ImageRandomizer {

	public String randomizeImg() {
		String imgAdress = "";

		double imgWeight = Math.random();
		if (imgWeight <= 0.2) {
			imgAdress = "images/axolotl.jpg";
		} else if (imgWeight > 0.2 && imgWeight <= 0.4) {
			imgAdress = "images/clownfish.jpg";
		} else if (imgWeight > 0.4 && imgWeight <= 0.6) {
			imgAdress = "images/lionfish.jpg";
		} else if (imgWeight > 0.6 && imgWeight <= 0.8) {
			imgAdress = "images/sea_snake.jpg";
		} else {
			imgAdress = "images/sea_turtle.jpg";
		}

		return imgAdress;
	}
}
