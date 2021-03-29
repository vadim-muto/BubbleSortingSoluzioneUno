package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;

import model.Container;
import model.SceneHandler;
import utilities.ScaleImage;
import view.FinishDialog;
import view.GamePanel;
import view.LabelImage;
import view.MainPanel;

public class GameController extends KeyAdapter implements MouseListener{
	
	private ImageIcon oldIcon;
	private LabelImage button;
	
	public GameController(LabelImage button) {
		if (button == null)
			return;
		
		this.button = button;
		this.oldIcon = (ImageIcon) button.getIcon();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
			SceneHandler.getInstance().exitGame();
		else if (e.getKeyCode() == KeyEvent.VK_Q) {
			SceneHandler.getInstance().changePanel(MainPanel.getInstance());
			FinishDialog.getDialog().dispose();
			Container.getInstance().clearAll();
			Container.getInstance().createBalls();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		GamePanel.getInstance().setNumProvette(7);
		SceneHandler.getInstance().changePanel(GamePanel.getInstance());
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		button.setIcon(ScaleImage.getInstance().scaleButtonImage(button.getImg(), button.getType()));
	}

	@Override
	public void mouseExited(MouseEvent e) {
		button.setIcon(oldIcon);
	}
}
