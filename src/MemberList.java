

import java.util.ArrayList;

public class MemberList {

	/** 
	 * @uml.property name="member"
	 * @uml.associationEnd multiplicity="(0 -1)" ordering="true" aggregation="shared" inverse="memberList:Member"
	 */
	ArrayList<Member> member = new ArrayList<Member>();

	/** 
	 * Getter of the property <tt>member</tt>
	 * @return  Returns the member.
	 * @uml.property  name="member"
	 */
	public ArrayList<Member> getMember() {
		return member;
	}

	/** 
	 * Setter of the property <tt>member</tt>
	 * @param member  The member to set.
	 * @uml.property  name="member"
	 */
	public void setMember(ArrayList<Member> member) {
		this.member = member;
	}

}
