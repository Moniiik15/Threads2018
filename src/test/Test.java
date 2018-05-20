/*
 * Created on May 9, 2018
 *
 */
package test;

import java.util.Scanner;

import javax.swing.JTextArea;

import gui.MainWindow;
import gui.playIndividual;
import music.Performance;
import music.Singer;
import music.Synchronizer;
import music.Voice;

public class Test {

    private Singer pattiSmith;
    private Singer bruceSpringsteen;
    private Singer choir;
    
    private Synchronizer synch;
    
    public void initializeSingingInThreads() {
        String lyrics1 = "Patti: Because the night";
        String lyrics2 = "Bruce: Belongs to lovers";
        String lyrics3= "Choir: Because the night belongs to lust";
        boolean stopIt = false;
        
        synch = new Synchronizer(true,false,false, null,false, false, false, false);
        
        Performance firstVoicePerformance = new Performance(lyrics1, 1500);
        Performance secondVoicePerformance = new Performance(lyrics2, 1500);
        Performance choirPerformance = new Performance(lyrics3, 1500);
        pattiSmith = new Singer("Patti Smith", Voice.FIRST, firstVoicePerformance, stopIt, synch);
        bruceSpringsteen = new Singer("Bruce Springsteen", Voice.SECOND, secondVoicePerformance, stopIt, synch);
        choir = new Singer("Choir", Voice.BACKGROUND, choirPerformance, stopIt, synch);
    }
    

    public void startThreads() {
    	synch.setTextArea(MainWindow.getTextArea());
    	 pattiSmith.start();
         bruceSpringsteen.start();
         choir.start();
    	
    }
    
    public void stopThreads() {
    	 pattiSmith.setStopIt(true);
         bruceSpringsteen.setStopIt(true);
         choir.setStopIt(true);
         
    	
    }
    
    public void startNewWindow() {
    	synch.setOpenIndividual(true);
    	synch.setTextArea(playIndividual.getTextArea());
    	
    }
	public void startPatti() {
		synch.setFirstVoiceFlag(true);
		synch.setPatti(true);
		pattiSmith.start();
		
		
	}
	
	public void stopPatti() {
		pattiSmith.setStopIt(true);
		synch.setPatti(false);
		//synch.setFirstVoiceFlag(false);
		
		
	}
	
	public void startBruce() {
		synch.setFirstVoiceFlag(false);
		synch.setChoirFlag(false);
		synch.setSecondVoiceFlag(true);
		synch.setBruce(true);
		bruceSpringsteen.start();
		
	}
	
	public void stopBruce() {
		synch.setBruce(false);
		bruceSpringsteen.setStopIt(true);
		
	}
	
	public void startChoir() {
		synch.setFirstVoiceFlag(false);
		synch.setSecondVoiceFlag(false);
		synch.setChoirFlag(true);
		synch.setChoir(true);
		choir.start();
		
	}
	public void stopChoir() {
		synch.setChoir(false);
		choir.setStopIt(true);
		
	}
    public void simpleDelay() {
        long l1 = System.currentTimeMillis();
        System.out.println("Wait 2sec...");
        while (System.currentTimeMillis() < (l1 + 2000)) {
        }
        System.out.println("Done.");
    }
    
    public synchronized void waitDelay() {
        System.out.println("Wait 2sec...");
        try {
            wait(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Done.");
    }
    
    public synchronized void loopDelay() {
        System.out.println("Wait 5 times 2sec...");
        for (int i = 0; i < 4; i++) {
            try {
                wait(2000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } 
            System.out.println(i + 1);
        }
        System.out.println("Done.");
    }
    
    public synchronized void threadWaitDelay() {
        WaitThread w1 = new WaitThread("t1");
        WaitThread w2 = new WaitThread("t2");
        System.out.println("Two threads...");
        w1.start();
        try {
            wait(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        w2.start();
    }


    
}

