package userinterface;

import java.awt.Color;

import ecs100.UI;

public class Triangle implements Shape {

	private double x1, x2, x3;
	private double y1, y2, y3;
	private double[] x = { x1, x2, x3 };
	private double[] y = { y1, y2, y3 };
	private Color color;
	private boolean isFilled = false;

	@Override
	public void setX(double x) {

		this.x[0] = x;
		this.x[1] = x + 50;
		this.x[2] = x - 50;

	}

	@Override
	public void setY(double y) {
		this.y[0] = y;
		this.y[1] = y + 50;
		this.y[2] = y + 50;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Triangle(double x, double y, Color color) {

		this.x[0] = x;
		this.x[1] = x + 50;
		this.x[2] = x - 50;

		this.y[0] = y;
		this.y[1] = y + 50;
		this.y[2] = y + 50;

		this.color = color;
	}

	@Override
	public void drawShape() {
		// TODO Auto-generated method stub

		UI.setColor(this.color);
		if (isFilled) {
			UI.fillPolygon(this.x, this.y, 3);
		} else {
			UI.drawPolygon(x, y, 3);
		}
	}

	@Override
	public boolean pointWithShape(double x, double y) {

		double ABC = Math.abs(x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
		double ABP = Math.abs(x1 * (y2 - y1) + x2 * (y - y1) + x * (y1 - y2));
		double APC = Math.abs(x1 * (y - y3) + x * (y3 - y1) + x3 * (y1 - y));
		double PBC = Math.abs(x * (y2 - y3) + x2 * (y3 - y) + x3 * (y - y2));

		if (ABP + APC + PBC == ABC) {
			return true;
		}

		return false;
	}

	@Override
	public void eraseShape() {
		// TODO Auto-generated method stub
		UI.erasePolygon(x, y, 3);
	}

	@Override
	public void moveShape(double x, double y) {
		this.x[0] = x;
		this.x[1] = x + 50;
		this.x[2] = x - 50;

		this.y[0] = y;
		this.y[1] = y + 50;
		this.y[2] = y + 50;
		this.drawShape();

	}

	@Override
	public void reSize(double size) {
		// TODO Auto-generated method stub
		for (int i = 0; i < x.length; i++) {
			x[i] = x[i] * size;
		}
		for (int i = 0; i < y.length; i++) {
			y[i] = y[i] * size;
		}

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
