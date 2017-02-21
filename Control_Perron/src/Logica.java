import java.io.IOException;
import java.net.DatagramPacket;
import java.util.Observable;
import java.util.Observer;

import processing.core.PApplet;

public class Logica implements Observer {
	private int x, y;
	private Comunicacion com;
	private String data;

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
	}

	public void click(PApplet app) {

		// DatagramPacket packet = new DatagramPacket(data, data.length);
		// String shi = data.toString();
		if (app.mouseX > 0 && app.mouseX < 500 && app.mouseY > 0 && app.mouseY < 500) {
			try {
				String lolis = new String("up");
				com.sendMessage(lolis);
				System.out.println(lolis);
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

		if (data.equals("up")) {
			y--;
		}
		if (data.contains("down")) {
			y++;
		}
		if (data.contains("right")) {
			x++;
		}
		if (data.contains("left")) {
			x--;
		}
	}

}