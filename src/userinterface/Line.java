package userinterface;

import java.awt.Color;

import javax.swing.JColorChooser;

import ecs100.UI;

public class Line implements Shape {

	private double x;
	private double y;
	private double x1;
	private double y1;
	private double width;
	private Color color;
	private boolean isFilled = false;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getX1() {
		return x1;
	}

	public void setX1(double x1) {
		this.x1 = x1;
	}

	public double getY1() {
		return y1;
	}

	public void setY1(double y1) {
		this.y1 = y1;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public Line(double x, double y, double x1, double y1, double width) {

		this.x = x;
		this.y = y;
		this.x1 = x1;
		this.y1 = y1;
		this.width = width;
//		this.color = color;
	}

// 

	@Override
	public boolean pointWithShape(double x, double y) {
		// TODO Auto-generated method stub
		if (x > this.x && x < (this.x + this.width * 2) && y > this.y && y < (this.y + this.width * 2)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void drawShape() {
		// TODO Auto-generated method stub
		UI.setColor(this.color);

		UI.drawLine(x, y, x1, y1);

		UI.setLineWidth(2);
	}

	@Override
	public void eraseShape() {
		// TODO Auto-generated method stub
		UI.eraseRect(x, y, x1, y1);

	}

	@Override
	public void moveShape(double x, double y) {
		this.x = x;
		this.y = y;
		this.drawShape();

	}

	@Override
	public void reSize(double size) {
		// TODO Auto-generated method stub

		this.width = this.width * size;
		this.drawShape();
	}

	@Override
	public void fillColor(Color color) {
		// TODO Auto-generated method stub
		this.color = color;
		this.isFilled = true;
		this.drawShape();
	}
}
