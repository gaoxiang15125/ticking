package bean.user;

import java.io.Serializable;
/**
 * �ʼ�����JavaBean
 * @author Li YongQiang
 */
public class Email implements Serializable {
	//  serialVersionUID ֵ
	private static final long serialVersionUID = 1L;
	// Email��ַ
	private String mailAdd;
	// �Ƿ���һ����׼��Email��ַ
	private boolean eamil;
	/**
	 * Ĭ���޲εĹ��췽��
	 */
	public Email() {
	}
	/**
	 * ���췽��
	 * @param mailAdd Email��ַ
	 */
	public Email(String mailAdd) {
		this.mailAdd = mailAdd;
	}
	/**
	 * �Ƿ���һ����׼��Email��ַ
	 * @return ����ֵ
	 */
	public boolean isEamil() {
		// ������ʽ�����������ʽ
		String regex = "\\w+([-+.']\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*"; 
		// matches()�������ж��ַ����Ƿ���������ʽƥ��
		if (mailAdd.matches(regex)) { 
			// eamilΪ��
			eamil = true;
		}
		// ����eamil
		return eamil;
	}
	public String getMailAdd() {
		return mailAdd;
	}
	public void setMailAdd(String mailAdd) {
		this.mailAdd = mailAdd;
	}
}
