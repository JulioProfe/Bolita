import java.io.IOException;
import java.net.DatagramPacket;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Logica implements Observer {
	private int x, y;
	private Comunicacion com;
	private String data;
	private boolean up = false, down = false, left = false, right = false;

	public Logica() {
		// TODO Auto-generated constructor stub
		data = "";
		com = new Comunicacion();
		Thread hilo = new Thread(com);
		hilo.start();

		x = 500 / 2;
		y = 500 / 2;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		DatagramPacket p = (DatagramPacket) arg1;
		data = new String(p.getData(), 0, p.getLength());
		System.out.println("DAtos: " + data);

		if (data.equals("up")) {
			y ++;
		}
//		if (data.contains("down")) {
//			down = true;
//		}
//		if (data.contains("right")) {
//			right = true;
//		}
//		if (data.contains("left")) {
//			left = true;
//		}
	}

	public void click(PApplet app) {
		if (app.mouseX > 0 && app.mouseX < 500 && app.mouseY > 0 && app.mouseY < 500) {
			try {
				String lolis = new String("up");
				com.sendMessage(lolis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void pintar(PApplet app) {
		// TODO Auto-generated method stub
		app.fill(0, 255, 0);
		app.noStroke();
		app.ellipse(x, y, 50, 50);

//		if (up = true) {
//			y--;
//		}
//		if (down = true) {
//			y++;
//		}
//		if (right = true) {
//			x++;
//		}
//		if (left = true) {
//			x--;
//		}
	}

}