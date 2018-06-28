
public class Sending_mail {

	static StringBuffer buffer1=null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		sendMail(buffer1);
		
		
	}
	
	static void sendMail(StringBuffer buffer)
	{
		String jobname="nitin";
		String in="nitin";
		String state="nitin";
		
		
		buffer.append("<html><head><style>table{border:1pxsolid;width:65%}"
				+"th,td{border:1px solid black; text-align:left;padding: 3px;} tr{backgroud-color:#0F8FFF;color:black}"
				+"th{backgoud-color:#5F9EA0;color:white;}</style></head>");
		
		buffer.append("<body>")
		.append("<p>Hi All,</p>")
		.append("<table>")
		.append("<tr>"+
		"<th style='width:>%'>JObname</th>"+
		"<th style='width:>%'>ins</th>"+
		"</tr>");
		
		for (int i = 0; i < 10; i++)
		{
			buffer.append("<tr><td>")
			.append(jobname)
			.append("</td><td>");
			
			buffer.append(in)
			.append("</td><td>");
			
			buffer.append("<font color=\"red\">"+state+"</font>")
			.append("</td><td>");
		}
		
		
		
		buffer.append("</table>");
		buffer.append("<BR>");
		buffer.append("</BR>");
		
		
			buffer.append("</body>"+"</html>");
		
		
			
			
		System.out.println(buffer);
		
		
	}

}
