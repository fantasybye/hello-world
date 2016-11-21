package servlet;

import java.util.ArrayList;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import data.projectLogic;
import data.riskLogic;
import model.risk;

public class ProjectAction extends ActionSupport{
	
	//p
	private int selectedprojectid;
	private ArrayList<risk> risklist;
	private String plan_name;
	
	public int getSelectedprojectid() {
		return selectedprojectid;
	}

	public void setSelectedprojectid(int selectedprojectid) {
		this.selectedprojectid = selectedprojectid;
	}

	public ArrayList<risk> getRisklist() {
		return risklist;
	}

	public void setRisklist(ArrayList<risk> risklist) {
		this.risklist = risklist;
	}

	public String getPlan_name() {
		return plan_name;
	}

	public void setPlan_name(String plan_name) {
		this.plan_name = plan_name;
	}

	
	
	public String getProjectRisk(){
		riskLogic r=new riskLogic();
		if(selectedprojectid>0){
			risklist=r.getExistRisk(selectedprojectid);
			ActionContext actionContext = ActionContext.getContext();			  
		    Map session = actionContext.getSession();  			  
		    session.put("projectid",selectedprojectid);		
		}
		else{
			ActionContext actionContext = ActionContext.getContext();			  
		    Map session = actionContext.getSession();  			  
		    risklist=r.getExistRisk((Integer)session.get("projectid"));		
		}
		setRiskList();
		return "success";
	}
	
	
	
	private void setRiskList(){
		for(int i=0;i<risklist.size();i++){
			switch(risklist.get(i).getRiskPossibility()){
				case 1:
					risklist.get(i).setRiskPossibilityStr("��");
					break;
				case 2:
					risklist.get(i).setRiskPossibilityStr("��");
					break;
				case 3:
					risklist.get(i).setRiskPossibilityStr("��");
					break;
				default:
					System.out.println("riskPossibility false");
					break;
			}
			
			switch(risklist.get(i).getRiskEfficiency()){
				case 1:
					risklist.get(i).setRiskEfficiencyStr("��");
					break;
				case 2:
					risklist.get(i).setRiskEfficiencyStr("��");
					break;
				case 3:
					risklist.get(i).setRiskEfficiencyStr("��");
					break;
				default:
					System.out.println("riskEfficiencyStr false");
					break;
			}
		}
	}
}
