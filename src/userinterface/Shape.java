package userinterface;

import java.awt.Color;

public interface Shape {

	public void drawShape();

	public boolean pointWithShape(double x, double y);

	public void setX(double x);

	public void setY(double y);

	public void eraseShape();

	public void moveShape(double x, double y);

	public void reSize(double size);

	public void fillColor(Color color);

}
