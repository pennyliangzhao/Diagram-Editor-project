package userinterface;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JColorChooser;

import ecs100.UI;

public class Rectangle implements Shape {

	private double x;
	private double y;
	private double Width;
	private double Height;
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

	public double getWidth() {
		return Width;
	}

	public void setWidth(double width) {
		Width = width;
	}

	public double getHeight() {
		return Height;
	}

	public void setHeight(double height) {
		Height = height;
	}

	public Rectangle(double x, double y, double Width, double Height) {

		this.x = x;
		this.y = y;
		this.Width = Width;
		this.Height = Height;

	}

	@Override
	public void drawShape() {
		UI.setColor(this.color);
		if (isFilled) {
			UI.fillRect(this.x, this.y, Width, Height);
		} else {
			UI.drawRect(x, y, Width, Height);
		}
	}

	@Override
	public boolean pointWithShape(double x, double y) {

		if (x > this.x && x < (this.x + this.Width) && y > this.y && y < (this.y + this.Height)) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void eraseShape() {
		UI.eraseRect(x, y, Width, Height);

	}

	@Override
	public void moveShape(double x, double y) {
		this.x = x;
		this.y = y;
		this.drawShape();
	}

	@Override
	public void reSize(double size) {
		this.Height = this.Height * size;
		this.Width = this.Width * size;
		this.drawShape();
	}

	@Override
	public void fillColor(Color color) {
		this.color = color;
		this.isFilled = true;
		this.drawShape();
	}

}
