package classes;

import java.io.Serializable;

public class Risk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long rid;
	private int possibility;
	private int effect;
	private String trigger;
	private String tracker;
	private String rname;
	public Risk(){
		
	}
	//¹æ¶¨1=high,0=medium£¬-1=low
	public Risk(long rid,String rname,int possibility,int effect,String trigger,String committer,String tracker){
		this.rid = rid;
		this.possibility = possibility;
		this.effect = effect;
		this.trigger = trigger;
		this.tracker = tracker;
	}
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getPossibility() {
		return possibility;
	}
	public void setPossibility(int possibility) {
		this.possibility = possibility;
	}
	public int getEffect() {
		return effect;
	}
	public void setEffect(int effect) {
		this.effect = effect;
	}
	public String getTrigger() {
		return trigger;
	}
	public void setTrigger(String trigger) {
		this.trigger = trigger;
	}
	public String getTracker() {
		return tracker;
	}
	public void setTracker(String tracker) {
		this.tracker = tracker;
	}

}
