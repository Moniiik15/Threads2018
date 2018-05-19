/*
 * Created on May 10, 2018
 *
 */
package music;

import java.awt.TextArea;

import javax.swing.JTextArea;

public class Synchronizer {
    
    private boolean firstVoiceFlag;
    private boolean secondVoiceFlag;
    private JTextArea textArea;
    public Synchronizer(boolean firstVoiceFlag, JTextArea textArea) {
        super();
        this.firstVoiceFlag = firstVoiceFlag;
        this.secondVoiceFlag=!firstVoiceFlag;
        this.textArea=textArea;
    }
    
    public synchronized void singFirstVoice(String lyrics, int delay) {
        while (!firstVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void singSecondVoice(String lyrics, int delay) {
        while (!secondVoiceFlag) {
            try {
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        sing(lyrics, delay);
    }
    
    public synchronized void singChoir(String lyrics, int delay) {
    	while(firstVoiceFlag || secondVoiceFlag) {
    		try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		
    	}
    	sing(lyrics, delay);
    	
    	
    }
    
    private void sing(String lyrics, int delay) {
       textArea.append(lyrics + '\n');
        try {
            wait(delay);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if(firstVoiceFlag) {
        firstVoiceFlag = !firstVoiceFlag;
        secondVoiceFlag=!secondVoiceFlag;
        }
        else if(secondVoiceFlag) {
        	secondVoiceFlag=!secondVoiceFlag;
        	
        }
        else {
        	firstVoiceFlag=!firstVoiceFlag;	
        }
        notifyAll();
    }

}

