/**
 * 
 */
package project1;

/**
 * @author Endril
 *
 */
//public class Model {

	
//	public interface TableModel{
		
	//	void calcAge{
	//		reutrn;
	//	}
		
	//}
	public class RetirementAccount
	{
	private	int age;
	private	double retireSave;
	private	double retireCon;
	private	double target;
		             
	
	 
	    public RetirementAccount (int age, double retireSave, double retireCon, double target)
	    {
	        this.age = age;
	        this.retireSave = retireSave;
	        this.retireCon = retireCon;
	        this.target = target;
	    }
	 
	    public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public double getRetireSave() {
			return retireSave;
		}

		public void setRetireSave(double retireSave) {
			this.retireSave = retireSave;
		}

		public double getRetireCon() {
			return retireCon;
		}

		public void setRetireCon(double retireCon) {
			this.retireCon = retireCon;
		}

		public double getTarget() {
			return target;
		}

		public void setTarget(double target) {
			this.target = target;
		}

	
	 
	}
		