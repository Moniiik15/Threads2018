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
    
    private boolean Patti;
    private boolean Bruce;
    private boolean choir;
    
    private boolean openIndividual;
    public Synchronizer(boolean firstVoiceFlag,boolean secondVoiceFlag, JTextArea textArea, boolean Patti, boolean Bruce,boolean choir, boolean openIndividual) {
        super();
        this.firstVoiceFlag = firstVoiceFlag;
        this.secondVoiceFlag = secondVoiceFlag;
        this.textArea=textArea;
        this.Patti=Patti;
        this.Bruce=Bruce;
        this.choir=choir;
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
    	 
       if(openIndividual) {
    	  
    	   
    	   if(firstVoiceFlag) {
    		   if(Bruce) {
    			   firstVoiceFlag = !firstVoiceFlag;
    		       secondVoiceFlag=!secondVoiceFlag;
    			   
    		   }
    		   else if(!Bruce && choir) {
    			   firstVoiceFlag=!firstVoiceFlag;
    		   }
    		   
    	   }
    	   else if(secondVoiceFlag) {
    		   if(Patti && !choir) {
    			   firstVoiceFlag = !firstVoiceFlag;
    		       secondVoiceFlag=!secondVoiceFlag;
    			   
    		   }
    		   else if(choir) {
    			   secondVoiceFlag=!secondVoiceFlag;
    			   
    		   }
    		  
    		   
    	   }
    	   else {
    		   if(Patti) {
    			   firstVoiceFlag=!firstVoiceFlag;
    			   
    		   }
    		   else if(!Patti && Bruce) {
    			   secondVoiceFlag=!secondVoiceFlag;
    		   }
    		   
    	   }
    	 
    	   
    	   
       }
       else{
    	   
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
        
       }
        notifyAll();
    }

	public boolean isFirstVoiceFlag() {
		return firstVoiceFlag;
	}

	public void setFirstVoiceFlag(boolean firstVoiceFlag) {
		this.firstVoiceFlag = firstVoiceFlag;
	}

	public boolean isSecondVoiceFlag() {
		return secondVoiceFlag;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}

	public void setSecondVoiceFlag(boolean secondVoiceFlag) {
		this.secondVoiceFlag = secondVoiceFlag;
	}

	public boolean isPatti() {
		return Patti;
	}

	public void setPatti(boolean patti) {
		Patti = patti;
	}

	public boolean isBruce() {
		return Bruce;
	}

	public void setBruce(boolean bruce) {
		Bruce = bruce;
	}

	public boolean isChoir() {
		return choir;
	}

	public void setChoir(boolean choir) {
		this.choir = choir;
	}

	public boolean isOpenIndividual() {
		return openIndividual;
	}

	public void setOpenIndividual(boolean openIndividual) {
		this.openIndividual = openIndividual;
	}

}

