package tools;
/**
 * ת�������JavaBean
 * @author Li YongQiang
 */
public class Convert {
	/**
	 * ������ת����Ϊ�ַ���
	 * @param arr ����
	 * @return �ַ���
	 */
	public String arr2Str(String[] arr){
		// ʵ����StringBuffer
		StringBuffer sb = new StringBuffer();
		// �ж�arr�Ƿ�Ϊ��Ч����
		if(arr != null && arr.length > 0){
			// ��������
			for (String s : arr) {
				// ���ַ���׷�ӵ�StringBuffer��
				sb.append(s);
				// ���ַ���׷�ӵ�StringBuffer��
				sb.append(",");
			}
			// �ж��ַ��������Ƿ���Ч
			if(sb.length() > 0){
				// ��ȡ�ַ�
				sb = sb.deleteCharAt(sb.length() - 1);
			}
		}
		// �����ַ���
		return sb.toString();
	}
}
