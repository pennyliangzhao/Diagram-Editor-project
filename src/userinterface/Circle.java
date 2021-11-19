package userinterface;

import java.awt.Color;

import javax.swing.JColorChooser;

import ecs100.UI;

public class Circle implements Shape {

	private double x;
	private double y;
	private double radius;
	private Color color;
	private boolean isFilled = false;

	public Circle(double x, double y, double radius) {

		this.x = x;
		this.y = y;
		this.radius = radius;

	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public boolean containsPoint(double x, double y) {
		double distance = Math.hypot(this.x - x, this.y - y);
		return distance < radius;
	}

	public void draw() {
		UI.setColor(this.color);
		if (isFilled) {
			UI.fillRect(x, y, radius, radius);
		} else {
			UI.drawRect(x, y, radius, radius);
		}
	}

	@Override
	public void drawShape() {
		// TODO Auto-generated method stub
		UI.setColor(this.color);
		if (isFilled) {
			UI.fillOval(this.x, this.y, radius, radius);
		} else {
			UI.drawOval(x, y, radius, radius);
		}
	}

	@Override
	public boolean pointWithShape(double x, double y) {
		// TODO Auto-generated method stub
		if ((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y) <= radius * radius) {
			return true;
		}
		return false;
	}

	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		this.x = x;
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		this.y = y;

	}

	@Override
	public void eraseShape() {
		UI.eraseOval(this.x, this.y, this.radius, radius);
//		UI.eraseOval(this.x, this.y, this.radius * radius, radius * 2);
	}

	@Override
	public void moveShape(double x, double y) {
		this.x = x;
		this.y = y;
		this.drawShape();
	}

	@Override
	public void reSize(double size) {
		this.radius = this.radius * size;
		this.drawShape();
	}

	@Override
	public void fillColor(Color color) {
		this.color = color;
		this.isFilled = true;
		this.drawShape();
	}
}
