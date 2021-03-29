package model;

import it.unical.mat.embasp.base.Handler;
import it.unical.mat.embasp.base.InputProgram;
import it.unical.mat.embasp.base.OptionDescriptor;
import it.unical.mat.embasp.base.Output;
import it.unical.mat.embasp.languages.IllegalAnnotationException;
import it.unical.mat.embasp.languages.ObjectNotValidException;
import it.unical.mat.embasp.languages.asp.ASPInputProgram;
import it.unical.mat.embasp.languages.asp.ASPMapper;
import it.unical.mat.embasp.languages.asp.AnswerSet;
import it.unical.mat.embasp.languages.asp.AnswerSets;
import it.unical.mat.embasp.platforms.desktop.DesktopHandler;
import it.unical.mat.embasp.specializations.dlv2.desktop.DLV2DesktopService;
import view.FinishDialog;
import view.GamePanel;

public class GameThread implements Runnable{
	
	private static final int TIME = 2000;
	
	private final String encodingResource = "encodings/ai";
	private Handler handler;
	private InputProgram facts;
	
	public GameThread() {
		facts = new ASPInputProgram();
		try {
			ASPMapper.getInstance().registerClass(Pallina.class);
		} catch (ObjectNotValidException | IllegalAnnotationException e) {
			e.printStackTrace();
		}
	}
		
	@Override
	public void run() {
		try {
			Thread.sleep(TIME);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				handler = new DesktopHandler(new DLV2DesktopService("lib/dlv2.exe"));
				facts.addFilesPath(encodingResource);
				for (Pallina p : Container.getInstance().getPalline())
					facts.addObjectInput(p);
				handler.addProgram(facts);
				handler.addOption(new OptionDescriptor("--no-facts"));
				Output o = handler.startSync();
				AnswerSets answersets = (AnswerSets) o;
				if (answersets.getOptimalAnswerSets().isEmpty()) 
					break;
				
				for(AnswerSet a:answersets.getOptimalAnswerSets()){
					try {
						for (Object obj : a.getAtoms()) {
							if(!(obj instanceof Pallina))
								continue;
							Pallina pallinaAS = (Pallina) obj;
							for (Pallina p : Container.getInstance().getPalline()) {
								if (p.equals(pallinaAS)) {
									p.setColor(pallinaAS.getColor());
									if(!p.getColor().toString().equals(Pallina.VUOTA))
										p.setMoved(true);
									if(p.getColor().toString().equals(Pallina.VUOTA))
										GamePanel.getInstance().setPosition(p.getColonna());
								}
							}
						}
						facts.clearAll();
					} catch (Exception e) {
						e.printStackTrace();
					} 
				}
				GamePanel.getInstance().repaint();
				Thread.sleep(TIME);
				GamePanel.getInstance().repaint();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		new FinishDialog();
	}
}
