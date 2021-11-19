package userinterface;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JColorChooser;

import ecs100.UI;

public class UserInterface {

	public ArrayList<Shape> shapes = new ArrayList<>();
	private boolean isDrawSquare = false;
	private boolean isDrawLine = false;
	private boolean isDrawCircle = false;
	private boolean isDrawRectangle = false;
	private boolean isDrawTriangle = false;
	private boolean isMove = false;
	private boolean isErase = false;
	private boolean isResize = false;
	private boolean isFillColor = false;
	private boolean isPutMessage = false;
	private String msg;
	private Shape targetShape;

	public void addLine() {
		UI.println("click and draw a line");
		if (isDrawLine) {
			isDrawLine = false;
		} else {
			isDrawLine = true;
		}
	}

	public void addCircle() {
		UI.println("click and draw a circle");
		if (isDrawCircle) {
			isDrawCircle = false;
		} else {
			isDrawCircle = true;
		}
	}

	public void addRectangle() {
		UI.println("click and draw a rectangle");
		if (isDrawRectangle) {
			isDrawRectangle = false;
		} else {
			isDrawRectangle = true;

		}
	}

	public void addSquare() {
		UI.println("click and draw a square");
		if (isDrawSquare) {
			isDrawSquare = false;
		} else {
			isDrawSquare = true;

		}
	}

	public void addTriangle() {
		UI.println("click and draw a triangle");
		if (isDrawTriangle) {
			isDrawTriangle = false;
		} else {
			isDrawTriangle = true;
		}
	}

	public void setMove() {
		UI.println("click and move \nand click one more time to stop ");
		if (isMove) {
			isMove = false;
		} else {
			isMove = true;

		}
	}

	public void setErase() {
		UI.println("click and remove \n Click one more time to stop");
		if (isErase) {
			isErase = false;
		} else {
			isErase = true;

		}
	}

	public void setResize() {
		if (isResize) {
			isResize = false;
		} else {
			UI.println("Click on shape to resize \n Click to stop");
			isResize = true;

		}
	}

	public void fillColor() {

		if (isFillColor) {
			isFillColor = false;
		} else {
			isFillColor = true;
		}
	}

	public void setText() {
		msg = UI.askString("Please enter a message: ");
		UI.println("Please select an object to print message");
		if (isPutMessage) {
			isPutMessage = false;
		} else {
			isPutMessage = true;
		}
	}

	public void doMouse(String action, double x, double y) {
		if (isDrawSquare) {
			drawSquare(action, x, y);

		} else if (isDrawRectangle) {
			drawRectangle(action, x, y);

		} else if (isDrawLine) {
			drawLine(action, x, y);

		} else if (isDrawCircle) {
			drawCircle(action, x, y);

		} else if (isMove) {
			moveObject(action, x, y);

		} else if (isErase) {
			mouseRemove(action, x, y);

		} else if (isResize) {
			selectResizeShape(action, x, y);

		} else if (isFillColor) {
			fillColor(action, x, y);

		} else if (isPutMessage) {
			putMessage(action, x, y);

		} else if (isDrawTriangle) {
			drawTriangle(action, x, y);
		}

	}

	private void drawSquare(String action, double x, double y) {
		if (action.equals("released")) {

			Square square = new Square(x, y, 100, 100, Color.BLACK);
			square.drawShape();
			shapes.add(square);
			this.isDrawSquare = false;
		}
	}

	private void drawRectangle(String action, double x, double y) {
		if (action.equals("released")) {

			Rectangle rectangle = new Rectangle(x, y, 100, 200);
			rectangle.drawShape();
			shapes.add(rectangle);
			this.isDrawRectangle = false;
		}
	}

	private void drawTriangle(String action, double x, double y) {
		if (action.equals("released")) {

			Triangle triangle = new Triangle(x, y, Color.black);
			triangle.drawShape();
			shapes.add(triangle);
			this.isDrawTriangle = false;
		}
	}

	private void drawLine(String action, double x, double y) {
		if (action.equals("released")) {

			Line line = new Line(x, y, 250, 350, 8);
			line.drawShape();
			shapes.add(line);
			this.isDrawLine = false;
		}
	}

	private void drawCircle(String action, double x, double y) {
		if (action.equals("released")) {

			Circle circle = new Circle(x, y, 100);
			circle.drawShape();
			shapes.add(circle);
			this.isDrawCircle = false;
		}
	}

	private void moveObject(String action, double x, double y) {
		if (action.equals("pressed")) {
			targetShape = getShape(x, y);
		}

		if (action.equals("released") && targetShape != null) {

			targetShape.moveShape(x, y);
			redrawShapes();

			targetShape = null;
		}
	}

	public void mouseRemove(String action, double x, double y) {
		if (action.equals("pressed")) {
			targetShape = getShape(x, y);
		}

		if (action.equals("released") && targetShape != null) {
			targetShape.eraseShape();
			shapes.remove(targetShape);
			redrawShapes();
			this.isErase = false;
		}
	}

	private void redrawShapes() {
		UI.clearGraphics();
		for (Shape s : shapes) {
			s.drawShape();
		}
	}

	private void selectResizeShape(String action, double x, double y) {
		if (action.equals("released")) {
			targetShape = getShape(x, y);
			if (targetShape != null) {
				UI.println("You selected a shape successfully.\n Please select the size from the slider");
				this.isResize = true;
			} else {
				UI.println("A shape wasn't selected.");
			}
		}
	}

	public void resizeShape(double size) {
		if (isResize && targetShape != null) {
			if (size < 0) {
				size = 1 - Math.abs(size) / 10;
			}
			targetShape.eraseShape();
			targetShape.reSize(size);

		}
	}

	private Shape getShape(double x, double y) {
		for (Shape s : shapes) {
			System.out.println(s.pointWithShape(x, y));
			if (s.pointWithShape(x, y)) {
				return s;
			}
		}
		return null;
	}

	public void fillColor(String action, double x, double y) {
		if (action.equals("pressed")) {
			targetShape = getShape(x, y);
		}
		if (action.equals("released") && targetShape != null) {
			Color c = JColorChooser.showDialog(null, "Select color", Color.BLACK);
			targetShape.fillColor(c);
			this.isFillColor = false;
		}
	}

	public void putMessage(String action, double x, double y) {
		if (action.equals("pressed")) {
			targetShape = getShape(x, y);
		}
		if (action.equals("released") && targetShape != null) {
			UI.drawString(msg, x, y);
			isPutMessage = true;
		}
	}

	public void clearPanes() {

		UI.clearGraphics();
	}

	public UserInterface() {

		UI.addButton("Add box", this::addSquare);
		UI.addButton("Add Line", this::addLine);
		UI.addButton("Add Circle", this::addCircle);
		UI.addButton("Add Rectangle", this::addRectangle);
		UI.addButton("Add triangle", this::addTriangle);
		UI.addButton("Move Shape", this::setMove);
		UI.addButton("Add Text", this::setText);
		UI.addButton("Resize shape", this::setResize);
		UI.addSlider("Size", -5, 5, 1, this::resizeShape);
		UI.addButton("Fill color", this::fillColor);
		UI.setMouseListener(this::doMouse);
		UI.addButton("Mouse Remove", this::setErase);
		UI.addButton("Clear", this::clearPanes);
		UI.addButton("Quit", UI::quit);

	}

	public static void main(String[] args) {
		new UserInterface();

	}

}
