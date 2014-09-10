package net.xtslasher.rpg;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class InputManager implements KeyListener {

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
			case KeyEvent.VK_W:
				EntityPlayer.isMoving = true;
				Core.bW = true;
				break;
			case KeyEvent.VK_D:
				EntityPlayer.isMoving = true;
				Core.bD = true;
				break;
			case KeyEvent.VK_A:
				EntityPlayer.isMoving = true;
				Core.bA = true;
				break;
			case KeyEvent.VK_S:
				EntityPlayer.isMoving = true;
				Core.bS = true;
				break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		switch (key) {
			case KeyEvent.VK_W:
				EntityPlayer.isMoving = false;
				Core.bW = false;
				break;
			case KeyEvent.VK_D:
				EntityPlayer.isMoving = false;
				Core.bD = false;
				break;
			case KeyEvent.VK_A:
				EntityPlayer.isMoving = false;
				Core.bA = false;
				break;
			case KeyEvent.VK_S:
				EntityPlayer.isMoving = false;
				Core.bS = false;
				break;
		}
	}

	public void keyTyped(KeyEvent e) {
	}

}
